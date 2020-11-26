package com.duws;

import com.webops.duas.*;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

public class JobRuns {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(JobRuns.class);

    private ObjectsList nodesList;
    private ObjectsList jobsList;
    private ObjectsList jobInfo;
    private ObjectsList taskList;
    private ObjectsList sessionList;
    private ObjectsList uprocList;
    private ObjectsList muList;

    public JobRuns() {
        nodesList = new NodesList();
        jobsList = new JobsList();
        jobInfo = new JobInfo();
        taskList = new TaskList();
        sessionList = new SessionList();
        uprocList = new UprocList();
        muList = new MuList();

        init();
    }

    public JobRuns(HttpServletRequest request) {

        logger.info(this.getClass().getName()+": initialize all lists and maps");

        nodesList = new NodesList();
        jobsList = new JobsList();
        jobInfo = new JobInfo();
        taskList = new TaskList();
        sessionList = new SessionList();
        uprocList = new UprocList();
        muList = new MuList();

        init();
        setInRequest(request);
    }

    public void init() {
        nodesList.init();
        jobsList.init();
        jobInfo.init();
        taskList.init();
        sessionList.init();
        uprocList.init();
        muList.init();
    }

    public void setInSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        nodesList.setInSession(session);
        jobsList.setInSession(session);
        jobInfo.setInSession(session);
        taskList.setInSession(session);
        sessionList.setInSession(session);
        uprocList.setInSession(session);
        muList.setInSession(session);
    }

    public void setFromSession(HttpServletRequest request) {
        nodesList.setFromSession(request);
        jobsList.setFromRequest(request);
        jobInfo.setFromRequest(request);
        taskList.setFromRequest(request);
        sessionList.setFromRequest(request);
        uprocList.setFromRequest(request);
        muList.setFromRequest(request);
    }

    public void setInRequest(HttpServletRequest request) {
        nodesList.setInRequest(request);
        jobsList.setInRequest(request);
        jobInfo.setInRequest(request);
        taskList.setInRequest(request);
        sessionList.setInRequest(request);
        uprocList.setInRequest(request);
        muList.setInRequest(request);
    }

    public void getFromRequest(HttpServletRequest request) {
        nodesList.setFromRequest(request);
        jobsList.setFromRequest(request);
        jobInfo.setFromRequest(request);
        taskList.setFromRequest(request);
        sessionList.setFromRequest(request);
        uprocList.setFromRequest(request);
        muList.setFromRequest(request);
    }

    public NodesList getNodesList() {
        return (NodesList) nodesList;
    }

    public JobsList getJobsList() {
        return (JobsList) jobsList;
    }

    public TaskList getTaskList() {
        return (TaskList) muList;
    }
    public SessionList getSessionList() {
        return (SessionList) muList;
    }
    public UprocList getUprocList() {
        return (UprocList) muList;
    }
    public MuList getMuList() {
        return (MuList) muList;
    }

    public boolean getDUEnvironmentList(HttpServletRequest request, UvmsConnection uvmsConnection) {
        boolean ret = false;
        Client duwsClient = null;
        try {
            duwsClient = new Client();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if(uvmsConnection == null) {
            logger.info(this.getClass().getName()+": No user stored yet in session");
            uvmsConnection = new UvmsConnection();
        } else {
            try {
                ret = duwsClient.getDUEnvironmentList(uvmsConnection, (NodesList) nodesList);
            } catch (Exception e) {
                logger.error(this.getClass().getName()+": "+duwsClient.getLastResponse()+ "("+duwsClient.getLastResult()+")");
                logger.error("Exception: ",e);
                e.printStackTrace();
            }

            if(ret) {
                logger.info(this.getClass().getName()+"/getDUEnvironmentList: Add data to nodesList");
                //TODO: set in session ?
                nodesList.setInRequest(request);
            } else {
                logger.error(this.getClass().getName()+"/getDUEnvironmentList: nodesList = null");
            }
        }

        request.setAttribute("lastResult", duwsClient.getLastResponse());
        request.setAttribute("returnCode", duwsClient.getLastResult());

        return ret;
    }

    public boolean getListExecution(HttpServletRequest request, UvmsConnection uvmsConnection, List<String> currentNodesList, String offset) {
        Client duwsClient = null;
        try {
            duwsClient = new Client();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        boolean ret = false;

        List<Map<String,String>> nodesList = (List<Map<String,String>>) request.getAttribute("nodesList");
        if(nodesList == null || nodesList.isEmpty()) {
            logger.error(this.getClass().getName()+"/getListExecution: nodesList null or empty");
        }

        if(!currentNodesList.isEmpty()) {
            jobsList.reset();

            logger.info(this.getClass().getName()+"/getListExecution: Nodes selected by form:");
            for (String idx : currentNodesList) {
                Map<String, String> item = nodesList.get(Integer.parseInt(idx));
                logger.info(this.getClass().getName() + "/getListExecution: node " + idx + "=" + item.get("company") + "|" + item.get("node") + "|" + item.get("area"));
                try {
                    ret = duwsClient.getListExecution(uvmsConnection, item, (JobsList) jobsList, offset);
                } catch (Exception e) {
                    logger.error(this.getClass().getName() + ": " + duwsClient.getLastResponse() + "(" + duwsClient.getLastResult() + ")");
                    logger.error("Exception: ", e);
                    e.printStackTrace();
                }
            }
            logger.info(this.getClass().getName()+"/getListExecution: Add data to jobsMap");
            ret = true;
        } else {
            logger.info(this.getClass().getName()+"/getListExecution: No nodes selected in form");
            ret = false;
        }

        if(ret) {
            logger.info(this.getClass().getName()+"/getListExecution: Add data to jobsList");
            //TODO: set in session?
            jobsList.setInRequest(request);
        } else {
            logger.error(this.getClass().getName()+"/getListExecution: nodesList = null");
        }

        request.setAttribute("lastResult", duwsClient.getLastResponse());
        request.setAttribute("returnCode", duwsClient.getLastResult());

        return ret;
    }

    public boolean getJobLogs(HttpServletRequest request, UvmsConnection uvmsConnection) {
        Client duwsClient = null;
        try {
            duwsClient = new Client();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Map<String, List<String>> jobLogs;
        boolean ret = true;

        String company = request.getParameter("company");
        String node  = request.getParameter("node");
        String area = request.getParameter("area");
        String task = request.getParameter("task");
        String session = request.getParameter("session");
        String uproc = request.getParameter("uproc");
        String mu = request.getParameter("mu");
        String numJob = request.getParameter("numproc");
        String numSess = request.getParameter("numsess");

        if(company == null || company.isEmpty()) {
            logger.error(this.getClass().getName()+"/getJobLogs: company null or empty");
        }
        if(node == null || node.isEmpty()) {
            logger.error(this.getClass().getName()+"/getJobLogs: node null or empty");
        }
        if(area == null || area.isEmpty()) {
            logger.error(this.getClass().getName()+"/getJobLogs: area null or empty");
        }

        jobLogs = duwsClient.getJobLogs(uvmsConnection, company, node, area, task, session, uproc, mu, numSess, numJob);

        request.setAttribute("historyTrace", jobLogs.get("historyTrace"));
        request.setAttribute("jobLog", jobLogs.get("jobLog"));
        request.setAttribute("uproclabel", jobLogs.get("uproclabel"));
        request.setAttribute("sessionlabel", jobLogs.get("sessionlabel"));
        request.setAttribute("mulabel", jobLogs.get("mulabel"));
        request.setAttribute("resLog", jobLogs.get("resLog"));

        request.setAttribute("lastResult", duwsClient.getLastResponse());
        request.setAttribute("returnCode", duwsClient.getLastResult());

        return ret;
    }

    public boolean getExecution(HttpServletRequest request, UvmsConnection uvmsConnection) {
        Client duwsClient = null;
        try {
            duwsClient = new Client();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //Map<String, List<String>> jobParams;
        boolean ret = true;

        String company = request.getParameter("company");
        String node  = request.getParameter("node");
        String area = request.getParameter("area");
        String task = request.getParameter("task");
        String session = request.getParameter("session");
        String uproc = request.getParameter("uproc");
        String mu = request.getParameter("mu");
        String numJob = request.getParameter("numproc");
        String numSess = request.getParameter("numsess");
        String numLanc = request.getParameter("numlanc");

        if(company == null || company.isEmpty()) {
            logger.error(this.getClass().getName()+"/getExecution: company null or empty");
        }
        if(node == null || node.isEmpty()) {
            logger.error(this.getClass().getName()+"/getExecution: node null or empty");
        }
        if(area == null || area.isEmpty()) {
            logger.error(this.getClass().getName()+"/getExecution: area null or empty");
        }

        ret = duwsClient.getExecution(uvmsConnection, company, node, area, task, session, uproc, mu, numSess, numJob, numLanc, (JobInfo) jobInfo);
        if(ret) {
            logger.info(this.getClass().getName()+"/getExecution: Add data to jobInfo");
            //TODO: set in session?
            jobInfo.setInRequest(request);
        } else {
            logger.error(this.getClass().getName()+"/getExecution: jobInfo = null");
        }

        request.setAttribute("lastResult", duwsClient.getLastResponse());
        request.setAttribute("returnCode", duwsClient.getLastResult());

        return ret;
    }

    public boolean actionOnJob(HttpServletRequest request, UvmsConnection uvmsConnection) {
        Client duwsClient = null;
        try {
            duwsClient = new Client();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        //Map<String, List<String>> jobParams;
        boolean ret = true;

        String action = request.getParameter("action");
        String company = request.getParameter("company");
        String node  = request.getParameter("node");
        String area = request.getParameter("area");
        String task = request.getParameter("task");
        String session = request.getParameter("session");
        String uproc = request.getParameter("uproc");
        String mu = request.getParameter("mu");
        String numJob = request.getParameter("numproc");
        String numSess = request.getParameter("numsess");
        String numLanc = request.getParameter("numlanc");
        String status = request.getParameter("status");

        if(company == null || company.isEmpty()) {
            logger.error(this.getClass().getName()+"/actionOnJob: company null or empty");
        }
        if(node == null || node.isEmpty()) {
            logger.error(this.getClass().getName()+"/actionOnJob: node null or empty");
        }
        if(area == null || area.isEmpty()) {
            logger.error(this.getClass().getName()+"/actionOnJob: area null or empty");
        }

        String jobType;
        if(status.equals("RUNNING") || status.equals("COMPLETED") || status.equals("ABORTED")) {
            jobType = "ctl";
        } else {
            jobType = "fla";
        }

        if(jobType.equals("ctl")) {
            if (action.equals("delete")) {
                    ret = duwsClient.purgeExecution(uvmsConnection, company, node, area, task, session, uproc, mu, numSess, numJob);
            } else {
                if (action.equals("stop") && jobType.equals("ctl") && status.equals("RUNNING")) {
                    ret = duwsClient.stopExecution(uvmsConnection, company, node, area, task, session, uproc, mu, numSess, numJob);
                }
            }
        } else {
            if (action.equals("delete")) {
                ret = duwsClient.deleteLaunch(uvmsConnection, company, node, area, task, session, uproc, mu, numSess, numJob, numLanc);
            }
            if (action.equals("hold")) {
                ret = duwsClient.holdLaunch(uvmsConnection, company, node, area, task, session, uproc, mu, numSess, numJob, numLanc);
            }
            if (action.equals("release")) {
                ret = duwsClient.releaseLaunch(uvmsConnection, company, node, area, task, session, uproc, mu, numSess, numJob, numLanc);
            }
            if (action.equals("force")) {
                ret = duwsClient.forceCompleteLaunch(uvmsConnection, company, node, area, task, session, uproc, mu, numSess, numJob, numLanc);
            }
            if (status.equals("LAUNCH_WAIT") || status.equals("EVENT_WAIT")) {
                if (action.equals("bypass")) {
                    ret = duwsClient.bypassLaunchConditionCheck(uvmsConnection, company, node, area, task, session, uproc, mu, numSess, numJob, numLanc);
                } else {
                    if (action.equals("skip")) {
                        ret = duwsClient.skipExecution(uvmsConnection, company, node, area, task, session, uproc, mu, numSess, numJob, numLanc);
                    }
                }
            }
        }

        if(ret) {
            logger.info(this.getClass().getName()+"/actionOnJob: Successful");
            //TODO: set in session?
        } else {
            logger.error(this.getClass().getName()+"/actionOnJob: failed");
        }

        request.setAttribute("lastResult", duwsClient.getLastResponse());
        request.setAttribute("returnCode", duwsClient.getLastResult());

        return ret;
    }

    public boolean getObjectsForNewRun(HttpServletRequest request, UvmsConnection uvmsConnection, Map<String, String> node) {
        Client duwsClient = null;
        try {
            duwsClient = new Client();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Map<String, List<String>> objects;
        boolean ret = true;
        boolean globalret = true;

        ret = duwsClient.getListTask(uvmsConnection, node.get("company"), node.get("node"), node.get("area"), (TaskList) taskList);
        if(ret) {
            logger.info(this.getClass().getName()+"/getObjetsForNewRun: Add taskList to request");
            //TODO: set in session?
            taskList.setInRequest(request);
        } else {
            logger.error(this.getClass().getName()+"/getObjetsForNewRun: taskList = null");
            globalret = false;
        }
        ret = duwsClient.getListSession(uvmsConnection, node.get("company"), node.get("node"), node.get("area"), (SessionList) sessionList);
        if(ret) {
            logger.info(this.getClass().getName()+"/getObjetsForNewRun: Add sessionList to request");
            //TODO: set in session?
            sessionList.setInRequest(request);
        } else {
            logger.error(this.getClass().getName()+"/getObjetsForNewRun: sessionList = null");
            globalret = false;
        }
        ret = duwsClient.getListUproc(uvmsConnection, node.get("company"), node.get("node"), node.get("area"), (UprocList) uprocList);
        if(ret) {
            logger.info(this.getClass().getName()+"/getObjetsForNewRun: Add uprocList to request");
            //TODO: set in session?
            uprocList.setInRequest(request);
        } else {
            logger.error(this.getClass().getName()+"/getObjetsForNewRun: uprocList = null");
            globalret = false;
        }
        ret = duwsClient.getListMu(uvmsConnection, node.get("company"), node.get("node"), node.get("area"), (MuList) muList);
        if(ret) {
            logger.info(this.getClass().getName()+"/getObjetsForNewRun: Add muList to request");
            //TODO: set in session?
            muList.setInRequest(request);
        } else {
            logger.error(this.getClass().getName()+"/getObjetsForNewRun: muList = null");
            globalret = false;
        }

        request.setAttribute("lastResult", duwsClient.getLastResponse());
        request.setAttribute("returnCode", duwsClient.getLastResult());

        return globalret;
    }

    public boolean addLaunch(HttpServletRequest request, UvmsConnection uvmsConnection, Map<String, String> node, JobInfo newRun) {
        Client duwsClient = null;
        try {
            duwsClient = new Client();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        boolean ret = true;
        boolean launchDone = false;

        Pattern sep = Pattern.compile("\\|");

        if(newRun.getEntry("session") != null) {
            if (!newRun.getEntry("session").isEmpty() && !newRun.getEntry("session").equals("none")) {
                String sessionname = sep.split(newRun.getEntry("session"))[0];
                newRun.putEntry("session", sessionname);
            } else {
                newRun.putEntry("session", "");
            }
        }

        if(newRun.getEntry("task") != null) {
            if (!newRun.getEntry("task").isEmpty() && !newRun.getEntry("task").equals("none")) {
                String taskname = sep.split(newRun.getEntry("task"))[0];
                newRun.putEntry("task", taskname);
                ret = duwsClient.addLaunchFromTask(uvmsConnection, node.get("company"), node.get("node"), node.get("area"), newRun);
                launchDone = true;
            } else {
                newRun.putEntry("task", "");
            }
        }

        if(!launchDone) {
            ret = duwsClient.addLaunch(uvmsConnection, node.get("company"), node.get("node"), node.get("area"), newRun);
            launchDone = true;
        }

        if(ret) {
            logger.info(this.getClass().getName()+"/addLaunch succeeded");
            //TODO: set in session?
            request.setAttribute("numlanc", newRun.getEntry("numlanc"));
        } else {
            logger.error(this.getClass().getName()+"/addLaunch failed");
            ret = false;
        }

        request.setAttribute("lastResult", duwsClient.getLastResponse());
        request.setAttribute("returnCode", duwsClient.getLastResult());

        return ret;

    }

}
