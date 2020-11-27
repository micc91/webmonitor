package com.duws;

import com.webops.duas.*;
import com.webops.duws.proxy.*;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBElement;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class Client {
    private static final Logger logger = Logger.getLogger(Client.class);
    private String errorMessage;
    private int errorCode;

    URL duwsUrl;
    DuWebService_Service ss;
    DuWebService service;
    UvmsContext uvmsContext;
    String token;

    ExecutionFilter currentFilter;
    LaunchFilter currentLFilter;

    public Client() throws MalformedURLException {
        duwsUrl = new URL("http://localhost:8080/du_web_services_6.10.51_all_os/DuwsSEI?wsdl");
        ss = new DuWebService_Service();//duwsUrl);
        service = ss.getDuWebServicePort();
        uvmsContext = new UvmsContext();
        token = "disconnected";
        errorMessage = "Successful";
        errorCode = 0;

        currentFilter = null;
        currentLFilter = null;
    }

    public String getLastResponse() {
        return errorMessage;
    }

    public int getLastResult() {
        return errorCode;
    }


    public void setLastResult(int code) {
        errorCode = code;
    }

    public void setLastResponse(String message) {
        errorMessage = message;
    }

    public ContextHolder setContext(UvmsConnection connection, String company, String node, String iArea) {
        token = connection.getToken();
        Context currentCtx = new Context();
        Envir currentEnvir = new Envir();
        ContextHolder ctxHolder = new ContextHolder();

        JAXBElement<String> area = new JAXBElement<>(ss.getServiceName(),String.class, iArea);
        currentEnvir.setArea(area);
        currentEnvir.setCompany(company);
        currentEnvir.setNode(node);
        JAXBElement<EnvirStatus> status = new JAXBElement<>(ss.getServiceName(),EnvirStatus.class,EnvirStatus.fromValue("CONNECTED"));
        currentEnvir.setStatus(status);
        currentCtx.setEnvir(currentEnvir);
        logger.info(this.getClass().getName()+"/setContext: currentEnvir="+currentEnvir.getCompany()+","+currentEnvir.getNode()+","+currentEnvir.getArea().getValue());
        // Setting up the context
        ctxHolder.setContext(currentCtx);
        ctxHolder.setToken(token);

        return ctxHolder;
    }

    private LaunchId setLaunchId(String task, String session, String uproc, String mu, String numSess, String numJob, String numLanc) {
        LaunchId launchId = new LaunchId();

        if(! task.equals("-")) {
            launchId.setTask(task);
        }
        if(! session.equals("-")) {
            launchId.setSession(session);
            launchId.setNumSess(numSess);
        }
        launchId.setUproc(uproc);
        launchId.setMu(mu);
        launchId.setNumProc(numJob);
        launchId.setNumLanc(numLanc);

        return launchId;
    }

    private ExecutionId setExecutionId(String task, String session, String uproc, String mu, String numSess, String numJob) {
        ExecutionId execId = new ExecutionId();

        JAXBElement<String> muElt = new JAXBElement<>(ss.getServiceName(),String.class, mu);
        if(! task.equals("-")) {
            execId.setTask(task);
        }
        if(! session.equals("-")) {
            execId.setSession(session);
            execId.setNumSess(numSess);
        }
        execId.setUproc(uproc);
        execId.setMu(muElt);
        execId.setNumProc(numJob);
        logger.info(this.getClass().getName()+"/setExecutionId: execId="+execId.getTask()+":"+execId.getSession()+":"+execId.getUproc()+":"+execId.getMu().getValue()+"/"+execId.getNumLanc()+":"+execId.getNumSess()+":"+execId.getNumProc());

        return execId;
    }

    public String login(UvmsConnection connection) {

        uvmsContext.setUvmsHost(connection.getUvmsHost());
        uvmsContext.setUvmsPort(Integer.parseInt(connection.getUvmsPort()));
        uvmsContext.setUvmsUser(connection.getLogin());
        uvmsContext.setUvmsPassword(connection.getPassword());

        logger.info(this.getClass().getName()+"/Login: Trying to log in "+uvmsContext.getUvmsUser()+" to "+uvmsContext.getUvmsHost()+":"+uvmsContext.getUvmsPort());

// Invoking authentication...
        try {
            token = service.login(uvmsContext);
        } catch (DuwsException_Exception duwse) {
            errorCode = duwse.getFaultInfo().getErrorCode();
            errorMessage = duwse.getMessage();
            logger.error(this.getClass().getName()+"/Login: Login failed: "+errorMessage+" ("+errorCode+")");
//            logger.error("Exception: ",duwse);
        }

        return(token);
    }

    public boolean getDUEnvironmentList(UvmsConnection connection, NodesList nodesList) throws Exception {
        boolean ret;
        token = connection.getToken();
        errorMessage = "Successful";
        errorCode = 0;

        // Setting up the context
        ContextHolder ctxHolder = new ContextHolder();
        ctxHolder.setToken(token);
        List<Envir> duEnvironmentList = service.getDUEnvironmentList(token,new UvmsNodeFilter());

        nodesList.reset();
        ret = true;
        int idx=0;
        for(Envir item : duEnvironmentList) {
            ret = ret & nodesList.addItem(item);
            idx++;
            logger.info(this.getClass().getName()+" [Adding "+ idx +"] "+item.getNode()+":"+item.getCompany()+":"+item.getArea().getValue()+":"+item.getVersion().getValue()+":"+item.getStatus().getValue().toString()+".");
        }

        return ret;
    }

    public boolean setExecutionAndLaunchFilters(String offset) {

        int iOffset = 1440; // D - 1 day by default
        if(offset != null) {
            if (!offset.equals("none") && !offset.isEmpty()) {
                iOffset = Integer.parseInt(offset);
            }
        }

        org.joda.time.DateTime nowDT = new org.joda.time.DateTime();
        org.joda.time.DateTime beginDT = nowDT.minusMinutes(iOffset);
        String sBegin = String.format("%04d",beginDT.getYear()) + String.format("%02d",beginDT.getMonthOfYear()) + String.format("%02d",beginDT.getDayOfMonth());
        String sBeginT = String.format("%02d",beginDT.getHourOfDay()) + String.format("%02d",beginDT.getMinuteOfHour()) + String.format("%02d",beginDT.getSecondOfMinute());
        org.joda.time.DateTime endDT = nowDT.plusSeconds(86400 - nowDT.getSecondOfDay());
        String sEnd = String.format("%04d",endDT.getYear()) + String.format("%02d",endDT.getMonthOfYear()) + String.format("%02d",endDT.getDayOfMonth());
        String sEndT = String.format("%02d",endDT.getHourOfDay()) + String.format("%02d",endDT.getMinuteOfHour()) + String.format("%02d",endDT.getSecondOfMinute());
        logger.info(this.getClass().getName()+"/setExecutionFilter: currentFilter set with begin="+sBegin+" "+sBeginT+", end="+sEnd + " "+sEndT+ "(offset="+iOffset+")");

        if(currentFilter == null) {
            currentFilter = new ExecutionFilter();
        }
        currentFilter.setBeginDateMin(sBegin);
        currentFilter.setBeginDateMax(sBegin);
        currentFilter.setBeginHourMin(sBeginT);
        currentFilter.setBeginHourMax(sBeginT);
        currentFilter.setEndDateMin(sEnd);
        currentFilter.setEndDateMax(sEnd);
        currentFilter.setEndHourMin(sEndT);
        currentFilter.setEndHourMin(sEndT);
        currentFilter.setProcessingDate("*");
        currentFilter.setNumlancMin("0000000");
        currentFilter.setNumlancMax("9999999");
        currentFilter.setNumsessMin("0000000");
        currentFilter.setNumsessMax("9999999");
        currentFilter.setNumprocMin("0000000");
        currentFilter.setNumprocMax("9999999");
        currentFilter.setOrder("DESC");
        currentFilter.setOrderByFields("START_DATE");
        currentFilter.setTask("*");
        currentFilter.setSession("*");
        currentFilter.setUproc("*");
        currentFilter.setMu("*");
        currentFilter.setStatus("*");

        if(currentLFilter == null) {
            currentLFilter = new LaunchFilter();
        }
        currentLFilter.setBeginDateMin(sBegin);
        currentLFilter.setBeginDateMax(sBegin);
        currentLFilter.setBeginHourMin(sBeginT);
        currentLFilter.setBeginHourMax(sBeginT);
        currentLFilter.setEndDateMin(sEnd);
        currentLFilter.setEndDateMax(sEnd);
        currentLFilter.setEndHourMin(sEndT);
        currentLFilter.setEndHourMin(sEndT);
        currentLFilter.setProcessingDate("*");
        currentLFilter.setNumlancMin("0000000");
        currentLFilter.setNumlancMax("9999999");
        currentLFilter.setNumsessMin("0000000");
        currentLFilter.setNumsessMax("9999999");
        currentLFilter.setNumprocMin("0000000");
        currentLFilter.setNumprocMax("9999999");
        currentLFilter.setOrder("DESC");
        currentLFilter.setOrderByFields("START_DATE");
        currentLFilter.setTask("*");
        currentLFilter.setSession("*");
        currentLFilter.setUproc("*");
        currentLFilter.setMu("*");
        currentLFilter.setStatus("*");
        return true;
    }

    private String formatDate(String inputDate) {
        String output;
        if(inputDate.length() != 8) {
            output = inputDate;
        } else {
            output = inputDate.substring(0, 4) + "/" + inputDate.substring(4, 6) + "/" + inputDate.substring(6, 8);
        }
        return output;
    }

    public boolean getListExecution(UvmsConnection connection, Map<String, String> node, JobsList jobsList, String offset) throws Exception {
        boolean ret;

        ContextHolder ctxHolder = setContext(connection, node.get("company"), node.get("node"), node.get("area"));
        List<ExecutionItem> jobRuns;
        List<LaunchItem> jobLaunches;

        if(currentFilter == null || currentLFilter == null) {
            ret = setExecutionAndLaunchFilters(offset);
            if(!ret) { return ret; }
        }

        try {
            jobLaunches = service.getListLaunch(ctxHolder, currentLFilter);
        } catch (DuwsException_Exception duwse) {
            errorCode = duwse.getFaultInfo().getErrorCode();
            errorMessage = duwse.getMessage();
            logger.error(this.getClass().getName()+"/getListExecution/getListLaunch failed: "+errorMessage+" ("+errorCode+")");
//            logger.error("Exception: ",duwse);

            jobLaunches = null;
        }

        try {
            jobRuns = service.getListExecution(ctxHolder, currentFilter);
        } catch (DuwsException_Exception duwse) {
            errorCode = duwse.getFaultInfo().getErrorCode();
            errorMessage = duwse.getMessage();
            logger.error(this.getClass().getName()+"/getListExecution failed: "+errorMessage+" ("+errorCode+")");
//            logger.error("Exception: ",duwse);

            jobRuns = null;
        }

        if(jobLaunches != null) {
            logger.info(this.getClass().getName()+"/getListExecution: Adding "+ jobLaunches.size() +" launches");
            for(LaunchItem item : jobLaunches) {
                if(item.getIdent().getTask() == null) {
                    item.getIdent().setTask("-");
                }
                if(item.getIdent().getSession() == null) {
                    item.getIdent().setSession("-");
                }
                item.setBeginDate(formatDate(item.getBeginDate()));
                item.setBeginHour(formatTime(item.getBeginHour()));
                item.setEndDate(formatDate(item.getEndDate()));
                item.setEndHour(formatTime(item.getEndHour()));
                item.setProcessingDate(formatDate(item.getProcessingDate()));
                jobsList.addItem(ctxHolder.getContext().getEnvir(), item);
            }
            ret = true;
        } else {
            logger.error(this.getClass().getName()+"/getListExecution: jobRuns = null");
            ret = false;
        }

        if(jobRuns != null) {

            logger.info(this.getClass().getName()+"/getListExecution: Adding "+ jobRuns.size() +" jobs");
            for(ExecutionItem item : jobRuns) {
                if(item.getIdent().getTask() == null) {
                    item.getIdent().setTask("-");
                }
                if(item.getIdent().getSession() == null) {
                    item.getIdent().setSession("-");
                }
                item.setBeginDate(formatDate(item.getBeginDate()));
                item.setBeginHour(formatTime(item.getBeginHour()));
                item.setEndDate(formatDate(item.getEndDate()));
                item.setEndHour(formatTime(item.getEndHour()));
                item.setProcessingDate(formatDate(item.getProcessingDate()));
                jobsList.addItem(ctxHolder.getContext().getEnvir(), item);
            }
            ret = true;
        } else {
            logger.error(this.getClass().getName()+"/getListExecution: jobRuns = null");
            ret = false;
        }

        return ret;
    }

    private String formatTime(String inputHour) {
        String output;
        if(inputHour.length() != 6) {
            output = inputHour;
        } else {
            output = inputHour.substring(0,2)+":"+inputHour.substring(2,4)+":"+inputHour.substring(4,6);
        }
        return output;
    }

    public Map<String, List<String>> getJobLogs(UvmsConnection connection, String company, String node, String iArea,
                                                String task, String session, String uproc, String mu,
                                                String numSess, String numJob) {
        ExecutionId execId = setExecutionId(task, session, uproc, mu, numSess, numJob);
        ContextHolder ctxHolder = setContext(connection, company, node, iArea);

        List<String> error4JobLogList = new ArrayList<>();
        List<String> error4HTraceList = new ArrayList<>();
        List<String> error4ResLogList = new ArrayList<>();
        ExecutionLog execLog = null;
        try {
            execLog = service.getExecutionLog(ctxHolder, execId);
        } catch (DuwsException_Exception duwse) {
            errorCode = duwse.getFaultInfo().getErrorCode();
            errorMessage = duwse.getMessage();
            logger.error(this.getClass().getName()+"/getJobLogs/getExecutionLog failed: "+errorMessage+" ("+errorCode+")");
//            logger.error("Exception: ",duwse);
            error4JobLogList.add("Job log request failed: "+errorMessage+" ("+errorCode+")");

        } catch (SessionTimedOutException_Exception e) {
            e.printStackTrace();
            error4JobLogList.add("Job log request failed: timeout reached");
        }

        HistoryTrace hTrace = null;
        try {
            hTrace = service.getHistoryTrace(ctxHolder, execId);
        } catch (DuwsException_Exception duwse) {
            errorCode = duwse.getFaultInfo().getErrorCode();
            errorMessage = duwse.getMessage();
            logger.error(this.getClass().getName()+"/getJobLogs/getHistoryTrace failed: "+errorMessage+" ("+errorCode+")");
//            logger.error("Exception: ",duwse);
            error4HTraceList.add("History trace request failed: "+errorMessage+" ("+errorCode+")");

        } catch (SessionTimedOutException_Exception e) {
            e.printStackTrace();
            error4HTraceList.add("History trace request failed: timeout reached");
        }

        ResourceLog resLog = null;
        try {
            resLog = service.getScriptResourceLog(ctxHolder, execId);
        } catch (DuwsException_Exception duwse) {
            errorCode = duwse.getFaultInfo().getErrorCode();
            errorMessage = duwse.getMessage();
            logger.error(this.getClass().getName()+"/getJobLogs/getScriptResourceLog failed: "+errorMessage+" ("+errorCode+")");
//            logger.error("Exception: ",duwse);
            error4ResLogList.add("Script resource log request failed: "+errorMessage+" ("+errorCode+")");

        } catch (SessionTimedOutException_Exception e) {
            e.printStackTrace();
            error4ResLogList.add("Script resource log request failed: timeout reached");
        }

        Map<String, List<String>> logsMap = new HashMap<>();
        if(resLog == null) {
            logsMap.put("resLog", error4ResLogList);
        } else {
            logsMap.put("resLog", resLog.getLog());
        }
        if(hTrace == null) {
            logsMap.put("historyTrace", error4HTraceList);
        } else {
            logsMap.put("historyTrace", hTrace.getTrace());
            List<String> uprlabel = new ArrayList<>();
            uprlabel.add(hTrace.getUprocLabel());
            List<String> seslabel = new ArrayList<>();
            seslabel.add(hTrace.getSessionLabel());
            List<String> mulabel = new ArrayList<>();
            mulabel.add(hTrace.getMuLabel());
            logsMap.put("uproclabel", uprlabel);
            logsMap.put("sessionlabel", seslabel);
            logsMap.put("mulabel", mulabel);
        }
        if(execLog == null) {
            logsMap.put("jobLog", error4JobLogList);
        } else {
            logsMap.put("jobLog", execLog.getLog());
        }

        return logsMap;
    }

    public boolean logout(UvmsConnection connection) throws Exception {
        boolean ret = true;

        try {
            service.logout(connection.getToken());
        } catch (DuwsException_Exception duwse) {
            errorCode = duwse.getFaultInfo().getErrorCode();
            errorMessage = duwse.getMessage();
            logger.error(this.getClass().getName()+"/Logout failed: "+errorMessage+" ("+errorCode+")");
//            logger.error("Exception: ",duwse);
            ret = false;
        }

        return ret;
    }

    public boolean getExecution(UvmsConnection connection, String company, String node, String iArea, String task, String session, String uproc, String mu, String numSess, String numJob, String numLanc, JobInfo jobInfo) {
        boolean ret;
        ExecutionId execId = setExecutionId(task, session, uproc, mu, numSess, numJob);
        LaunchId launchId = setLaunchId(task, session, uproc, mu, numSess, numJob, numLanc);
        ContextHolder ctxHolder = setContext(connection, company, node, iArea);

        List<String> errorList = new ArrayList<>();
        Execution exec = null;
        try {
            exec = service.getExecution(ctxHolder, execId);
        } catch (DuwsException_Exception duwse) {
            errorCode = duwse.getFaultInfo().getErrorCode();
            errorMessage = duwse.getMessage();
            logger.error(this.getClass().getName()+"/getExecution/getExecution failed: "+errorMessage+" ("+errorCode+")");
//            logger.error("Exception: ",duwse);
            errorList.add("getExecution request failed: "+errorMessage+" ("+errorCode+")");

        } catch (SessionTimedOutException_Exception e) {
            e.printStackTrace();
            errorList.add("getExecution request failed: timeout reached");
        }

        if(exec != null) {
            logger.info(this.getClass().getName()+"/getExecution: Adding exec data");
            jobInfo.addItems(ctxHolder.getContext().getEnvir(), exec);
            ret = true;
        } else {
            logger.error(this.getClass().getName()+"/getExecution: jobInfo = null");
            ret = false;
        }

        Launch launch = null;
        try {
            launch = service.getLaunch(ctxHolder, launchId);
        } catch (DuwsException_Exception duwse) {
            errorCode = duwse.getFaultInfo().getErrorCode();
            errorMessage = duwse.getMessage();
            logger.error(this.getClass().getName()+"/getExecution/getLaunch failed: "+errorMessage+" ("+errorCode+")");
//            logger.error("Exception: ",duwse);
            errorList.add("getLaunch request failed: "+errorMessage+" ("+errorCode+")");

        } catch (SessionTimedOutException_Exception e) {
            e.printStackTrace();
            errorList.add("getLaunch request failed: timeout reached");
        }

        if(launch != null) {
            logger.info(this.getClass().getName()+"/getLaunch: Adding exec data");
            jobInfo.addItems(ctxHolder.getContext().getEnvir(), launch);
            ret = true;
        } else {
            logger.error(this.getClass().getName()+"/getLaunch: jobInfo = null");
            ret = false;
        }

        return ret;
    }

    public Map<String, String> getDuwsVersion() {
        Map<String, String> output = new HashMap<>();
        DuwsVersion duwsVersion = null;

        output.put("status","");
        output.put("version", "unknown");

        try {
            duwsVersion = service.getWsVersion();
        } catch (DuwsException_Exception duwse) {
            errorCode = duwse.getFaultInfo().getErrorCode();
            errorMessage = duwse.getMessage();
            logger.error(this.getClass().getName()+"/getDuwsVersion failed: "+errorMessage+" ("+errorCode+")");
//            logger.error("Exception: ",duwse);
            output.put("status", "Request failed: "+errorMessage+" ("+errorCode+")");
        }

        if(duwsVersion != null) {
            output.put("version", duwsVersion.getFullVersion());
            output.put("status", "available");
        }
        return output;
    }

    //icon: trash.svg
    public boolean deleteLaunch(UvmsConnection connection, String company, String node, String iArea, String task, String session, String uproc, String mu, String numSess, String numJob, String numLanc) {
        boolean ret = true;
        errorCode = 0;
        errorMessage = "Successful";
        ContextHolder ctxHolder = setContext(connection, company, node, iArea);
        LaunchId launchId = setLaunchId(task, session, uproc, mu, numSess, numJob, numLanc);

        try {
            service.deleteLaunch(ctxHolder, launchId);
        } catch (DuwsException_Exception e) {
            errorCode = e.getFaultInfo().getErrorCode();
            errorMessage = e.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/deleteLaunch failed: "+errorMessage+" ("+errorCode+")");
            e.printStackTrace();
            ret = false;
        } catch (SessionTimedOutException_Exception e) {
            errorCode = 0;
            errorMessage = e.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/deleteLaunch timeout reached: "+errorMessage+" ("+errorCode+")");
            e.printStackTrace();
            ret = false;
        }
        return ret;
    }

    //icon: caret-right-square.svg
    public boolean releaseLaunch(UvmsConnection connection, String company, String node, String iArea, String task, String session, String uproc, String mu, String numSess, String numJob, String numLanc) {
        boolean ret = true;
        errorCode = 0;
        errorMessage = "Successful";
        ContextHolder ctxHolder = setContext(connection, company, node, iArea);
        LaunchId launchId = setLaunchId(task, session, uproc, mu, numSess, numJob, numLanc);

        try {
            service.releaseLaunch(ctxHolder, launchId);
        } catch (DuwsException_Exception e) {
            errorCode = e.getFaultInfo().getErrorCode();
            errorMessage = e.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/releaseLaunch failed: "+errorMessage+" ("+errorCode+")");
            e.printStackTrace();
            ret = false;
        } catch (SessionTimedOutException_Exception e) {
            errorCode = 0;
            errorMessage = e.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/releaseLaunch timeout reached: "+errorMessage+" ("+errorCode+")");
            e.printStackTrace();
            ret = false;
        }

        return ret;
    }

    //icon: cone-striped.svg
    public boolean holdLaunch(UvmsConnection connection, String company, String node, String iArea, String task, String session, String uproc, String mu, String numSess, String numJob, String numLanc) {
        boolean ret = true;
        errorCode = 0;
        errorMessage = "Successful";
        ContextHolder ctxHolder = setContext(connection, company, node, iArea);
        LaunchId launchId = setLaunchId(task, session, uproc, mu, numSess, numJob, numLanc);

        try {
            service.holdLaunch(ctxHolder, launchId);
        } catch (DuwsException_Exception e) {
            errorCode = e.getFaultInfo().getErrorCode();
            errorMessage = e.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/holdLaunch failed: "+errorMessage+" ("+errorCode+")");
            e.printStackTrace();
            ret = false;
        } catch (SessionTimedOutException_Exception e) {
            errorCode = 0;
            errorMessage = e.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/holdLaunch timeout reached: "+errorMessage+" ("+errorCode+")");
            e.printStackTrace();
            ret = false;
        }

        return ret;
    }

    //icon: arrow-return-right.svg
    public boolean bypassLaunchConditionCheck(UvmsConnection connection, String company, String node, String iArea, String task, String session, String uproc, String mu, String numSess, String numJob, String numLanc) {
        boolean ret = true;
        errorCode = 0;
        errorMessage = "Successful";
        ContextHolder ctxHolder = setContext(connection, company, node, iArea);
        LaunchId launchId = setLaunchId(task, session, uproc, mu, numSess, numJob, numLanc);

        try {
            service.bypassLaunchConditionCheck(ctxHolder, launchId);
        } catch (DuwsException_Exception e) {
            errorCode = e.getFaultInfo().getErrorCode();
            errorMessage = e.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/bypassLaunchConditionCheck failed: "+errorMessage+" ("+errorCode+")");
            e.printStackTrace();
            ret = false;
        } catch (SessionTimedOutException_Exception e) {
            errorCode = 0;
            errorMessage = e.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/bypassLaunchConditionCheck timeout reached: "+errorMessage+" ("+errorCode+")");
            e.printStackTrace();
            ret = false;
        }

        return ret;
    }

    //icon: check2-square.svg
    public boolean forceCompleteLaunch(UvmsConnection connection, String company, String node, String iArea, String task, String session, String uproc, String mu, String numSess, String numJob, String numLanc) {
        boolean ret = true;
        errorCode = 0;
        errorMessage = "Successful";
        ContextHolder ctxHolder = setContext(connection, company, node, iArea);
        LaunchId launchId = setLaunchId(task, session, uproc, mu, numSess, numJob, numLanc);

        try {
            service.forceCompleteLaunch(ctxHolder, launchId);
        } catch (DuwsException_Exception e) {
            errorCode = e.getFaultInfo().getErrorCode();
            errorMessage = e.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/forceCompleteLaunch failed: "+errorMessage+" ("+errorCode+")");
            e.printStackTrace();
            ret = false;
        } catch (SessionTimedOutException_Exception e) {
            errorCode = 0;
            errorMessage = e.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/forceCompleteLaunch timeout reached: "+errorMessage+" ("+errorCode+")");
            e.printStackTrace();
            ret = false;
        }

        return ret;
    }

    //icon: chevron-double-right.svg
    public boolean skipExecution(UvmsConnection connection, String company, String node, String iArea, String task, String session, String uproc, String mu, String numSess, String numJob, String numLanc) {
        boolean ret = true;
        errorCode = 0;
        errorMessage = "Successful";
        ContextHolder ctxHolder = setContext(connection, company, node, iArea);
        LaunchId launchId = setLaunchId(task, session, uproc, mu, numSess, numJob, numLanc);

        try {
            service.skipExecution(ctxHolder, launchId);
        } catch (DuwsException_Exception e) {
            errorCode = e.getFaultInfo().getErrorCode();
            errorMessage = e.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/skipExecution failed: "+errorMessage+" ("+errorCode+")");
            e.printStackTrace();
            ret = false;
        } catch (SessionTimedOutException_Exception e) {
            errorCode = 0;
            errorMessage = e.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/skipExecution timeout reached: "+errorMessage+" ("+errorCode+")");
            e.printStackTrace();
            ret = false;
        }

        return ret;
    }

    //icon: exclamation-octagon-fill.svg
    public boolean stopExecution(UvmsConnection connection, String company, String node, String iArea, String task, String session, String uproc, String mu, String numSess, String numJob) {
        boolean ret = true;
        errorCode = 0;
        errorMessage = "Successful";
        ContextHolder ctxHolder = setContext(connection, company, node, iArea);
        ExecutionId execId = setExecutionId(task, session, uproc, mu, numSess, numJob);
        int delay = 60;

        try {
            service.stopExecution(ctxHolder, execId, delay);
        } catch (DuwsException_Exception e) {
            errorCode = e.getFaultInfo().getErrorCode();
            errorMessage = e.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/stopExecution failed: "+errorMessage+" ("+errorCode+")");
            e.printStackTrace();
            ret = false;
        } catch (SessionTimedOutException_Exception e) {
            errorCode = 0;
            errorMessage = e.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/stopExecution timeout reached: "+errorMessage+" ("+errorCode+")");
            e.printStackTrace();
            ret = false;
        }

        return ret;
    }

    //icon: trash.svg
    public boolean purgeExecution(UvmsConnection connection, String company, String node, String iArea, String task, String session, String uproc, String mu, String numSess, String numJob) {
        boolean ret = true;
        errorCode = 0;
        errorMessage = "Successful";
        ContextHolder ctxHolder = setContext(connection, company, node, iArea);
        ExecutionId execId = setExecutionId(task, session, uproc, mu, numSess, numJob);

        try {
            service.purgeExecution(ctxHolder, execId);
        } catch (DuwsException_Exception e) {
            errorCode = e.getFaultInfo().getErrorCode();
            errorMessage = e.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/purgeExecution failed: "+errorMessage+" ("+errorCode+")");
            e.printStackTrace();
            ret = false;
        } catch (SessionTimedOutException_Exception e) {
            errorCode = 0;
            errorMessage = e.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/purgeExecution timeout reached: "+errorMessage+" ("+errorCode+")");
            e.printStackTrace();
            ret = false;
        }

        return ret;

    }

    public boolean getListTask(UvmsConnection connection, String company, String node, String iArea, TaskList objList) {
        boolean ret = true;
        errorCode = 0;
        errorMessage = "Successful";
        ContextHolder ctxHolder = setContext(connection, company, node, iArea);

        List<TaskItem> responseList = null;
        TaskFilter filter = new TaskFilter();
        filter.setTask("*");
        filter.setSession("*");
        filter.setUproc("*");
        filter.setMu("*");

        try {
            responseList = service.getListTask(ctxHolder, filter);
        } catch (DuwsException_Exception e) {
            errorCode = e.getFaultInfo().getErrorCode();
            errorMessage = e.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/getListTask failed: "+errorMessage+" ("+errorCode+")");
            e.printStackTrace();
            ret = false;
        } catch (SessionTimedOutException_Exception e) {
            errorCode = 0;
            errorMessage = e.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/getListTask timeout reached: "+errorMessage+" ("+errorCode+")");
            e.printStackTrace();
            ret = false;
            responseList = null;
        }

        objList.reset();
        int idx=0;
        if(responseList != null) {
            for (TaskItem item : responseList) {
                ret = ret & objList.addItem(ctxHolder.getContext().getEnvir(), item);
                idx++;
                logger.info(this.getClass().getName() + " [Adding " + idx + "] " + ctxHolder.getContext().getEnvir().getNode() + ":" + ctxHolder.getContext().getEnvir().getCompany() + ":" + ctxHolder.getContext().getEnvir().getArea().getValue() + ".");
            }
            ret = true;
        }

        return ret;
    }

    public boolean getListSession(UvmsConnection connection, String company, String node, String iArea, SessionList objList) {
        boolean ret = true;
        errorCode = 0;
        errorMessage = "Successful";
        ContextHolder ctxHolder = setContext(connection, company, node, iArea);

        SessionFilter filter = new SessionFilter();
        filter.setSession("*");

        List<SessionItem> responseList = null;

        try {
            responseList = service.getListSession(ctxHolder, filter);
        } catch (DuwsException_Exception e) {
            errorCode = e.getFaultInfo().getErrorCode();
            errorMessage = e.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/getListSession failed: "+errorMessage+" ("+errorCode+")");
            e.printStackTrace();
            ret = false;
        } catch (SessionTimedOutException_Exception e) {
            errorCode = 0;
            errorMessage = e.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/getListSession timeout reached: "+errorMessage+" ("+errorCode+")");
            e.printStackTrace();
            ret = false;
        }

        objList.reset();
        int idx=0;
        if(responseList != null) {
            for (SessionItem item : responseList) {
                ret = ret & objList.addItem(ctxHolder.getContext().getEnvir(), item);
                idx++;
                logger.info(this.getClass().getName() + " [Adding " + idx + "] " + ctxHolder.getContext().getEnvir().getNode() + ":" + ctxHolder.getContext().getEnvir().getCompany() + ":" + ctxHolder.getContext().getEnvir().getArea().getValue() + ".");
            }
            ret = true;
        }

        return ret;
    }

    public boolean getListUproc(UvmsConnection connection, String company, String node, String iArea, UprocList objList) {
        boolean ret = true;
        errorCode = 0;
        errorMessage = "Successful";
        ContextHolder ctxHolder = setContext(connection, company, node, iArea);
        List<UprocItem> responseList = null;

        UprocFilter filter = new UprocFilter();
        filter.setUproc("*");

        try {
            responseList = service.getListUproc(ctxHolder, filter);
        } catch (DuwsException_Exception e) {
            errorCode = e.getFaultInfo().getErrorCode();
            errorMessage = e.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/getListUproc failed: "+errorMessage+" ("+errorCode+")");
            e.printStackTrace();
            ret = false;
        } catch (SessionTimedOutException_Exception e) {
            errorCode = 0;
            errorMessage = e.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/getListUproc timeout reached: "+errorMessage+" ("+errorCode+")");
            e.printStackTrace();
            ret = false;
        }

        objList.reset();
        int idx=0;
        if(responseList != null) {
            for (UprocItem item : responseList) {
                ret = ret & objList.addItem(ctxHolder.getContext().getEnvir(), item);
                idx++;
                logger.info(this.getClass().getName() + " [Adding " + idx + "] " + ctxHolder.getContext().getEnvir().getNode() + ":" + ctxHolder.getContext().getEnvir().getCompany() + ":" + ctxHolder.getContext().getEnvir().getArea().getValue() + ".");
            }
            ret = true;
        }

        return ret;
    }

    public boolean getListMu(UvmsConnection connection, String company, String node, String iArea, MuList objList) {
        boolean ret = true;
        errorCode = 0;
        errorMessage = "Successful";
        ContextHolder ctxHolder = setContext(connection, company, node, iArea);
        List<MuItem> responseList = null;

        MuFilter filter = new MuFilter();
        filter.setMu("*");

        try {
            responseList = service.getListMU(ctxHolder, filter);
        } catch (DuwsException_Exception e) {
            errorCode = e.getFaultInfo().getErrorCode();
            errorMessage = e.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/getListMu failed: "+errorMessage+" ("+errorCode+")");
            e.printStackTrace();
            ret = false;
        } catch (SessionTimedOutException_Exception e) {
            errorCode = 0;
            errorMessage = e.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/getListMu timeout reached: "+errorMessage+" ("+errorCode+")");
            e.printStackTrace();
            ret = false;
        }

        objList.reset();
        int idx=0;
        if(responseList != null) {
            for (MuItem item : responseList) {
                ret = ret & objList.addItem(ctxHolder.getContext().getEnvir(), item);
                idx++;
                logger.info(this.getClass().getName() + " [Adding " + idx + "] " + ctxHolder.getContext().getEnvir().getNode() + ":" + ctxHolder.getContext().getEnvir().getCompany() + ":" + ctxHolder.getContext().getEnvir().getArea().getValue() + ".");
            }
            ret = true;
        }

        return ret;
    }

    public boolean addLaunchFromTask(UvmsConnection connection, String company, String node, String area, JobInfo newRun) {
        boolean ret = true;
        errorCode = 0;
        errorMessage = "Successful";
        ContextHolder ctxHolder = setContext(connection, company, node, area);

        TaskId objId = new TaskId();
        objId.setTask(newRun.getEntry("task"));
        objId.setSession(newRun.getEntry("session"));
        objId.setUproc(newRun.getEntry("uproc"));
        objId.setMu(newRun.getEntry("mu"));
        LaunchId newLaunchId = new LaunchId();

        try {
            newLaunchId = service.addLaunchFromTask(ctxHolder, objId);
        } catch (DuwsException_Exception e) {
            errorCode = e.getFaultInfo().getErrorCode();
            errorMessage = e.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/addLaunchFromTask failed: "+errorMessage+" ("+errorCode+")");
            e.printStackTrace();
            ret = false;
        } catch (SessionTimedOutException_Exception e) {
            errorCode = 255;
            errorMessage = e.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/addLaunchFromTask timeout reached: "+errorMessage+" ("+errorCode+")");
            e.printStackTrace();
            ret = false;
        }

        if(newLaunchId != null) {
            newRun.addEntry("numlanc", newLaunchId.getNumLanc());
            logger.info(this.getClass().getName() + " Launch "+newRun.getEntry("numlanc")+" created on " + ctxHolder.getContext().getEnvir().getNode() + ":" + ctxHolder.getContext().getEnvir().getCompany() + ":" + ctxHolder.getContext().getEnvir().getArea().getValue() + ".");
        }

        return ret;
    }

    private String parseDate(String format, String input) {

        if (input == null) {
            logger.info("parseDate: input = NULL");
            return "";
        }

        String[] sepList = new String [] { "/","-"," " };
        String separator = "/";
        for(String sep : sepList) {
            if (format.contains(sep)) {
                separator = sep; break;
            }  //else logger.info("parseDate: format "+format+" doesnt contain "+sep );

        }
        Pattern p = Pattern.compile(separator);
        logger.info("parseDate: input="+input+", separator="+separator+ ", pattern="+p.toString());
        String[] fields = p.split(input);
        String[] fieldTypes = p.split(format);
        int ii = 0;
        String year = "";
        String month = "";
        String day = "";
        for(String field: fields) {
            switch (fieldTypes[ii]) {
                case "yyyy":
                    year = field;
                    break;
                case "mm":
                    month = field;
                    break;
                case ("dd"):
                    day = field;
                    break;
            }
            ii++;
        }
        return year+month+day;
    }

    public boolean addLaunch(UvmsConnection connection, String company, String node, String area, JobInfo newRun) {
        boolean ret = true;
        errorCode = 0;
        errorMessage = "Successful";
        ContextHolder ctxHolder = setContext(connection, company, node, area);

        LaunchId launchId = new LaunchId();
        launchId.setTask("");
        launchId.setSession(newRun.getEntry("session"));
        launchId.setUproc(newRun.getEntry("uproc"));
        launchId.setMu(newRun.getEntry("mu"));

        Launch objId = new Launch();
        objId.setBeginDate(parseDate("dd/mm/yyyy", newRun.getEntry("start_date")));
        objId.setBeginHour(newRun.getEntry("start_time").replaceAll(":",""));
        objId.setEndDate(parseDate("dd/mm/yyyy", newRun.getEntry("end_date")));
        objId.setEndHour(newRun.getEntry("end_time").replaceAll(":",""));
        objId.setProcessingDate(parseDate("dd/mm/yyyy", newRun.getEntry("pdate")));
        objId.setStep("0");
        objId.setQueue(newRun.getEntry("queue"));
        objId.setInformation("");
        objId.setPriority("100");
        objId.setSeverity(0);
        objId.setUser(newRun.getEntry("user"));
        objId.setIdent(launchId);

        LaunchId newLaunchId = new LaunchId();

        try {
            newLaunchId = service.addLaunch(ctxHolder, objId);
        } catch (DuwsException_Exception e) {
            errorCode = e.getFaultInfo().getErrorCode();
            errorMessage = e.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/addLaunchFromTask failed: "+errorMessage+" ("+errorCode+")");
            e.printStackTrace();
            ret = false;
        } catch (SessionTimedOutException_Exception e) {
            errorCode = 255;
            errorMessage = e.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/addLaunchFromTask timeout reached: "+errorMessage+" ("+errorCode+")");
            e.printStackTrace();
            ret = false;
        }

        if(newLaunchId != null) {
            newRun.addEntry("numlanc", newLaunchId.getNumLanc());
            logger.info(this.getClass().getName() + " Launch "+newRun.getEntry("numlanc")+" created on " + ctxHolder.getContext().getEnvir().getNode() + ":" + ctxHolder.getContext().getEnvir().getCompany() + ":" + ctxHolder.getContext().getEnvir().getArea().getValue() + ".");
        }

        return ret;
    }

    //public addLaunchFromTask2() {}  ==> with variables....

    //public void rerunExecution()
    //public void updateLaunch()

    //public stopEngine()
    //public restartEngine()
    //public stopQueue()
    //public startQueue()
    //public void resetQueue()
    //public void getListEvent()
    //+delete, update, add event

}
