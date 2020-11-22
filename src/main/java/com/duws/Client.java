package com.duws;

import com.webops.duas.JobInfo;
import com.webops.duas.JobsList;
import com.webops.duas.NodesList;
import com.webops.duas.UvmsConnection;
import com.webops.duws.proxy.*;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBElement;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public String login(UvmsConnection connection) throws Exception {

        uvmsContext.setUvmsHost(connection.getUvmsHost());
        uvmsContext.setUvmsPort(Integer.parseInt(connection.getUvmsPort()));
        uvmsContext.setUvmsUser(connection.getLogin());
        uvmsContext.setUvmsPassword(connection.getPassword());

        logger.info("Trying to log in "+uvmsContext.getUvmsUser()+" to "+uvmsContext.getUvmsHost()+":"+uvmsContext.getUvmsPort());

// Invoking authentication...
        try {
            token = service.login(uvmsContext);
        } catch (DuwsException_Exception duwse) {
            errorCode = duwse.getFaultInfo().getErrorCode();
            errorMessage = duwse.getFaultInfo().getMessage();
            logger.error("Login failed: "+errorMessage+" ("+errorCode+")");
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

        Integer iOffset = 1440; // D - 1 day by default
        if(offset != null) {
            if (!offset.equals("none")) {
                iOffset = Integer.parseInt(offset);
            }
        }

/*        DateFormat fmtYyyyMmDd = new SimpleDateFormat("yyyyMMdd");
        DateFormat fmtHhMmSs = new SimpleDateFormat("HHmmSS");
        Calendar calb = Calendar.getInstance();
        calb.add(Calendar.MINUTE, iOffset);
        Date begin = calb.getTime();
        String sBegin = fmtYyyyMmDd.format(begin);

        String sBeginT = fmtHhMmSs.format(begin);

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE,1);
        Date tomorrow = cal.getTime();
        String sTomorrow = fmtYyyyMmDd.format(tomorrow);
  */

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

        Context currentCtx = new Context();
        Envir currentEnvir = new Envir();
        ContextHolder ctxHolder = new ContextHolder();
        List<ExecutionItem> jobRuns;
        List<LaunchItem> jobLaunches;

        JAXBElement<String> area = new JAXBElement<>(ss.getServiceName(),String.class, node.get("area"));
        currentEnvir.setArea(area);
        currentEnvir.setCompany(node.get("company"));
        currentEnvir.setNode(node.get("node"));
        JAXBElement<EnvirStatus> status = new JAXBElement<>(ss.getServiceName(),EnvirStatus.class,EnvirStatus.fromValue("CONNECTED"));
        currentEnvir.setStatus(status);
        currentCtx.setEnvir(currentEnvir);
        logger.info(this.getClass().getName()+"/getListExecution: currentEnvir="+currentEnvir.toString());

        token = connection.getToken();
        logger.info(this.getClass().getName()+"/getListExecution("+node.get("company")+"|"+node.get("node")+"|"+node.get("area")+"): token="+token);

        // Setting up the context
        ctxHolder.setContext(currentCtx);
        ctxHolder.setToken(token);

        if(currentFilter == null || currentLFilter == null) {
            ret = setExecutionAndLaunchFilters(offset);
        }

        try {
            jobLaunches = service.getListLaunch(ctxHolder, currentLFilter);
        } catch (DuwsException_Exception duwse) {
            errorCode = duwse.getFaultInfo().getErrorCode();
            errorMessage = duwse.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/getListExecution/getListLaunch failed: "+errorMessage+" ("+errorCode+")");
//            logger.error("Exception: ",duwse);

            jobLaunches = null;
        }

        try {
            jobRuns = service.getListExecution(ctxHolder, currentFilter);
        } catch (DuwsException_Exception duwse) {
            errorCode = duwse.getFaultInfo().getErrorCode();
            errorMessage = duwse.getFaultInfo().getMessage();
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
                jobsList.addItem(currentEnvir, item);
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
                jobsList.addItem(currentEnvir, item);
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
        token = connection.getToken();
        ExecutionId execId = new ExecutionId();
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
        logger.info(this.getClass().getName()+"/getJobLogs: currentEnvir="+currentEnvir.toString());
        logger.info(this.getClass().getName()+"/getJobLogs: input params="+task+":"+session+":"+uproc+":"+mu+"::"+numSess+":"+numJob+".");
        // Setting up the context
        ctxHolder.setContext(currentCtx);
        ctxHolder.setToken(token);

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
        logger.info(this.getClass().getName()+"/getJobLogs: execId="+execId.getTask()+":"+execId.getSession()+":"+execId.getUproc()+":"+execId.getMu().getValue()+"/"+execId.getNumLanc()+":"+execId.getNumSess()+":"+execId.getNumProc());

        List<String> error4JobLogList = new ArrayList<>();
        List<String> error4HTraceList = new ArrayList<>();
        List<String> error4ResLogList = new ArrayList<>();
        ExecutionLog execLog = null;
        try {
            execLog = service.getExecutionLog(ctxHolder, execId);
        } catch (DuwsException_Exception duwse) {
            errorCode = duwse.getFaultInfo().getErrorCode();
            errorMessage = duwse.getFaultInfo().getMessage();
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
            errorMessage = duwse.getFaultInfo().getMessage();
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
            errorMessage = duwse.getFaultInfo().getMessage();
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
            errorMessage = duwse.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/Logout failed: "+errorMessage+" ("+errorCode+")");
//            logger.error("Exception: ",duwse);
            ret = false;
        }

        return ret;
    }

    public boolean getExecution(UvmsConnection connection, String company, String node, String iArea, String task, String session, String uproc, String mu, String numSess, String numJob, String numLanc, JobInfo jobInfo) {
        boolean ret;
        token = connection.getToken();
        ExecutionId execId = new ExecutionId();
        LaunchId launchId = new LaunchId();
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
        logger.info(this.getClass().getName()+"/getExecution: currentEnvir="+currentEnvir.toString());
        logger.info(this.getClass().getName()+"/getExecution: input params="+task+":"+session+":"+uproc+":"+mu+"::"+numSess+":"+numJob+".");
        // Setting up the context
        ctxHolder.setContext(currentCtx);
        ctxHolder.setToken(token);

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
        logger.info(this.getClass().getName()+"/getExecution: execId="+execId.getTask()+":"+execId.getSession()+":"+execId.getUproc()+":"+execId.getMu().getValue()+"/"+execId.getNumLanc()+":"+execId.getNumSess()+":"+execId.getNumProc());

        List<String> errorList = new ArrayList<>();
        Execution exec = null;
        try {
            exec = service.getExecution(ctxHolder, execId);
        } catch (DuwsException_Exception duwse) {
            errorCode = duwse.getFaultInfo().getErrorCode();
            errorMessage = duwse.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/getExecution/getExecution failed: "+errorMessage+" ("+errorCode+")");
//            logger.error("Exception: ",duwse);
            errorList.add("getExecution request failed: "+errorMessage+" ("+errorCode+")");

        } catch (SessionTimedOutException_Exception e) {
            e.printStackTrace();
            errorList.add("getExecution request failed: timeout reached");
        }

        if(exec != null) {
            logger.info(this.getClass().getName()+"/getExecution: Adding exec data");
            jobInfo.addItems(currentEnvir, exec);
            ret = true;
        } else {
            logger.error(this.getClass().getName()+"/getExecution: jobInfo = null");
            ret = false;
        }

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

        Launch launch = null;
        try {
            launch = service.getLaunch(ctxHolder, launchId);
        } catch (DuwsException_Exception duwse) {
            errorCode = duwse.getFaultInfo().getErrorCode();
            errorMessage = duwse.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/getExecution/getLaunch failed: "+errorMessage+" ("+errorCode+")");
//            logger.error("Exception: ",duwse);
            errorList.add("getLaunch request failed: "+errorMessage+" ("+errorCode+")");

        } catch (SessionTimedOutException_Exception e) {
            e.printStackTrace();
            errorList.add("getLaunch request failed: timeout reached");
        }

        if(launch != null) {
            logger.info(this.getClass().getName()+"/getLaunch: Adding exec data");
            jobInfo.addItems(currentEnvir, launch);
            ret = true;
        } else {
            logger.error(this.getClass().getName()+"/getLaunch: jobInfo = null");
            ret = false;
        }

        return ret;
    }
}
