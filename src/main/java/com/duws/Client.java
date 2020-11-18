package com.duws;

import com.webops.duas.NodesList;
import com.webops.duas.UvmsConnection;
import com.webops.duws.proxy.*;
import org.apache.log4j.Logger;

import javax.xml.bind.JAXBElement;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

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

    public Map<String, List<String>> getDUEnvironmentList(UvmsConnection connection, NodesList nodesList) throws Exception {

        token = connection.getToken();
        errorMessage = "Successful";
        errorCode = 0;

        // Setting up the context
        ContextHolder ctxHolder = new ContextHolder();
        ctxHolder.setToken(token);
        List<Envir> duEnvironmentList = service.getDUEnvironmentList(token,new UvmsNodeFilter());

        Map<String, List<String>> duasMap = new HashMap<>();
        duasMap.put("company", new ArrayList<>());
        duasMap.put("node", new ArrayList<>());
        duasMap.put("area", new ArrayList<>());
        duasMap.put("version", new ArrayList<>());
        duasMap.put("status", new ArrayList<>());

        nodesList.reset();

        int idx=0;
        for(Envir item : duEnvironmentList) {
            nodesList.addItem(item);

            duasMap.get("company").add(item.getCompany());
            duasMap.get("node").add(item.getNode());
            duasMap.get("area").add(item.getArea().getValue());
            duasMap.get("version").add(item.getVersion().getValue());
            duasMap.get("status").add(item.getStatus().getValue().toString());
            idx++;
            logger.info(this.getClass().getName()+" [Adding "+ Integer.toString(idx) +"] "+item.getNode()+":"+item.getCompany()+":"+item.getArea().getValue()+":"+item.getVersion().getValue()+":"+item.getStatus().getValue().toString()+".");
        }

        return duasMap;
    }

    public boolean setExecutionAndLaunchFilters() {

        Calendar cal = Calendar.getInstance();
        Date now = cal.getTime();
        DateFormat fmtYyyyMmDd = new SimpleDateFormat("yyyyMMdd");
        String sNow = fmtYyyyMmDd.format(now);
        cal.add(Calendar.DATE,1);
        Date tomorrow = cal.getTime();
        String sTomorrow = fmtYyyyMmDd.format(tomorrow);
        logger.info(this.getClass().getName()+"/setExecutionFilter: currentFilter set with now="+sNow+", tomorrow="+sTomorrow);

        if(currentFilter == null) {
            currentFilter = new ExecutionFilter();
        }
        currentFilter.setBeginDateMin(sNow);
        currentFilter.setBeginDateMax(sNow);
        currentFilter.setBeginHourMin("000000");
        currentFilter.setBeginHourMax("000000");
        currentFilter.setEndDateMin(sTomorrow);
        currentFilter.setEndDateMax(sTomorrow);
        currentFilter.setEndHourMin("235959");
        currentFilter.setEndHourMin("235959");
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
        currentLFilter.setBeginDateMin(sNow);
        currentLFilter.setBeginDateMax(sNow);
        currentLFilter.setBeginHourMin("000000");
        currentLFilter.setBeginHourMax("000000");
        currentLFilter.setEndDateMin(sTomorrow);
        currentLFilter.setEndDateMax(sTomorrow);
        currentLFilter.setEndHourMin("235959");
        currentLFilter.setEndHourMin("235959");
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

    public boolean getListExecution(UvmsConnection connection, String company, String node, String iArea, Map<String, List<String>> jobsMap) throws Exception {
        boolean ret;

        Context currentCtx = new Context();
        Envir currentEnvir = new Envir();
        ContextHolder ctxHolder = new ContextHolder();
        List<ExecutionItem> jobRuns;
        List<LaunchItem> jobLaunches;

        JAXBElement<String> area = new JAXBElement<>(ss.getServiceName(),String.class, iArea);
        currentEnvir.setArea(area);
        currentEnvir.setCompany(company);
        currentEnvir.setNode(node);
        JAXBElement<EnvirStatus> status = new JAXBElement<>(ss.getServiceName(),EnvirStatus.class,EnvirStatus.fromValue("CONNECTED"));
        currentEnvir.setStatus(status);
        currentCtx.setEnvir(currentEnvir);
        logger.info(this.getClass().getName()+"/getListExecution: currentEnvir="+currentEnvir.toString());

        token = connection.getToken();
        logger.info(this.getClass().getName()+"/getListExecution("+company+"|"+node+"|"+iArea+"): token="+token);

        // Setting up the context
        ctxHolder.setContext(currentCtx);
        ctxHolder.setToken(token);

        if(currentFilter == null || currentLFilter == null) {
            ret = setExecutionAndLaunchFilters();
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

        try {
            jobLaunches = service.getListLaunch(ctxHolder, currentLFilter);
        } catch (DuwsException_Exception duwse) {
            errorCode = duwse.getFaultInfo().getErrorCode();
            errorMessage = duwse.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/getListExecution/getListLaunch failed: "+errorMessage+" ("+errorCode+")");
//            logger.error("Exception: ",duwse);

            jobLaunches = null;
        }

        if(! jobsMap.containsKey("nodeList")) {
            jobsMap.put("nodeList", new ArrayList<>());
        }
        if(! jobsMap.containsKey("jobIdList")) {
            jobsMap.put("jobIdList", new ArrayList<>());
        }
        if(! jobsMap.containsKey("statusList")) {
            jobsMap.put("statusList", new ArrayList<>());
        }
        if(! jobsMap.containsKey("beginList")) {
            jobsMap.put("beginList", new ArrayList<>());
        }
        if(! jobsMap.containsKey("endList")) {
            jobsMap.put("endList", new ArrayList<>());
        }
        if(! jobsMap.containsKey("infoList")) {
            jobsMap.put("infoList", new ArrayList<>());
        }
        if(! jobsMap.containsKey("otherList")) {
            jobsMap.put("otherList", new ArrayList<>());
        }

        String taskField;
        String sessionField;
        if(jobRuns != null) {

            logger.info(this.getClass().getName()+"/getListExecution: Adding "+ jobRuns.size() +" jobs");
            for(ExecutionItem item : jobRuns) {
                jobsMap.get("nodeList").add(currentEnvir.getCompany()+"|"+currentEnvir.getNode()+"|"+currentEnvir.getArea().getValue());

                if(item.getIdent().getTask() == null) {
                    taskField = "-";
                } else {
                    taskField = item.getIdent().getTask();
                }
                if(item.getIdent().getSession() == null) {
                    sessionField = "-";
                } else {
                    sessionField = item.getIdent().getSession();
                }
                jobsMap.get("jobIdList").add(taskField+"|"+sessionField+"|"+item.getIdent().getUproc()+"@"+item.getIdent().getMu().getValue());
                jobsMap.get("statusList").add(item.getStatus());
                jobsMap.get("beginList").add(formatDate(item.getBeginDate())+" "+formatTime(item.getBeginHour()));
                jobsMap.get("endList").add(formatDate(item.getEndDate())+" "+formatTime(item.getEndHour()));
                jobsMap.get("infoList").add(item.getInfo());
                jobsMap.get("otherList").add(item.getIdent().getNumSess()+";"+item.getIdent().getNumProc()+";"+item.getProcessingDate()+";"+item.getQueue()+";"+item.getPriority());
            }
            ret = true;
        } else {
            logger.error(this.getClass().getName()+"/getListExecution: jobRuns = null");
            ret = false;
        }

        if(jobLaunches != null) {
            logger.info(this.getClass().getName()+"/getListExecution: Adding "+ jobLaunches.size() +" launches");
            for(LaunchItem item : jobLaunches) {
                jobsMap.get("nodeList").add(currentEnvir.getCompany()+"|"+currentEnvir.getNode()+"|"+currentEnvir.getArea().getValue());
                if(item.getIdent().getTask() == null) {
                    taskField = "-";
                } else {
                    taskField = item.getIdent().getTask();
                }
                if(item.getIdent().getSession() == null) {
                    sessionField = "-";
                } else {
                    sessionField = item.getIdent().getSession();
                }
                jobsMap.get("jobIdList").add(taskField+"|"+sessionField+"|"+item.getIdent().getUproc()+"@"+item.getIdent().getMu());
                jobsMap.get("statusList").add(item.getStatus());
                jobsMap.get("beginList").add(formatDate(item.getBeginDate())+" "+formatTime(item.getBeginHour()));
                jobsMap.get("endList").add(formatDate(item.getEndDate())+" "+formatTime(item.getEndHour()));
                jobsMap.get("infoList").add("");
                jobsMap.get("otherList").add(item.getIdent().getNumLanc()+";"+item.getProcessingDate()+";"+item.getQueue()+";"+item.getPriority()+";"+item.getStep());

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
        logger.info(this.getClass().getName()+"/getListExecution: currentEnvir="+currentEnvir.toString());

        // Setting up the context
        ctxHolder.setContext(currentCtx);
        ctxHolder.setToken(token);

/*        String fields[] = jobIdent.split("[@|]");
        String task = fields[0];
        String session = fields[1];
        String uproc = fields[2];
        String mu = fields[3];
 */
        JAXBElement<String> muElt = new JAXBElement<>(ss.getServiceName(),String.class, mu);;
        if(! task.equals("-")) {
            execId.setTask(task);
        }
        if(! session.equals("-")) {
            execId.setSession(session);
        }
        execId.setUproc(uproc);
        execId.setMu(muElt);
        execId.setNumProc(numJob);
        execId.setNumSess(numSess);

        ExecutionLog execLog = null;
        try {
            execLog = service.getExecutionLog(ctxHolder, execId);
        } catch (DuwsException_Exception duwse) {
            errorCode = duwse.getFaultInfo().getErrorCode();
            errorMessage = duwse.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/getListExecution/getListLaunch failed: "+errorMessage+" ("+errorCode+")");
//            logger.error("Exception: ",duwse);

        } catch (SessionTimedOutException_Exception e) {
            e.printStackTrace();
        }

        HistoryTrace hTrace = null;
        try {
            hTrace = service.getHistoryTrace(ctxHolder, execId);
        } catch (DuwsException_Exception duwse) {
            errorCode = duwse.getFaultInfo().getErrorCode();
            errorMessage = duwse.getFaultInfo().getMessage();
            logger.error(this.getClass().getName()+"/getListExecution/getListLaunch failed: "+errorMessage+" ("+errorCode+")");
//            logger.error("Exception: ",duwse);

        } catch (SessionTimedOutException_Exception e) {
            e.printStackTrace();
        }

        Map<String, List<String>> logsMap = new HashMap<>();
        logsMap.put("historyTrace", hTrace.getTrace());
        logsMap.put("jobLog", execLog.getLog());

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
}
