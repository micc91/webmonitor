package com.duws;

import com.webops.duas.*;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Map;

public class JobRuns {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(JobRuns.class);

    private ObjectsList nodesList;
    private ObjectsList jobsList;
    private ObjectsList jobInfo;

    public JobRuns() {
        nodesList = new NodesList();
        nodesList.init();
        jobsList = new JobsList();
        jobsList.init();
        jobInfo = new JobInfo();
        jobInfo.init();
    }

    public JobRuns(HttpServletRequest request) {

        logger.info(this.getClass().getName()+": initialize all lists and maps");

        nodesList = new NodesList();
        nodesList.init();
        nodesList.setInRequest(request);

        jobsList = new JobsList();
        jobsList.init();
        jobsList.setInRequest(request);

        jobInfo = new JobInfo();
        jobInfo.init();
        jobInfo.setInRequest(request);
    }

    public NodesList getNodesList() {
        return (NodesList) nodesList;
    }

    public JobsList getJobsList() {
        return (JobsList) jobsList;
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

        return ret;
    }

    public boolean getListExecution(HttpServletRequest request, UvmsConnection uvmsConnection, List<String> selectedNodes) {
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

        String[] currentNodesList;
        if(request.getParameterValues("selectedNodes") == null) {
            if(selectedNodes != null) {
                int ii = 0;
                currentNodesList = new String[selectedNodes.size()];
                for(String nodenum : selectedNodes) {
                    currentNodesList[ii] = nodenum;
                    ii++;
                }
            } else {
                currentNodesList = null;
            }
        } else {
            currentNodesList = request.getParameterValues("selectedNodes");
        }

        if(currentNodesList != null) {
            jobsList.reset();

            logger.info(this.getClass().getName()+"/getListExecution: Nodes selected by form:");
            for (String idx : currentNodesList) {
                Map<String, String> item = nodesList.get(Integer.parseInt(idx));
                logger.info(this.getClass().getName() + "/getListExecution: node " + idx + "=" + item.get("company") + "|" + item.get("node") + "|" + item.get("area"));
                try {
                    ret = duwsClient.getListExecution(uvmsConnection, item, (JobsList) jobsList);;
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

        return ret;
    }

    public boolean getExecution(HttpServletRequest request, UvmsConnection uvmsConnection) {
        Client duwsClient = null;
        try {
            duwsClient = new Client();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Map<String, List<String>> jobParams;
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

        return ret;
    }

}
