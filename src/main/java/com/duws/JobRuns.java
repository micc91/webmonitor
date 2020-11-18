package com.duws;

import com.webops.duas.NodesList;
import com.webops.duas.UvmsConnection;
import com.webops.duas.objectsList;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobRuns {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(JobRuns.class);

    private objectsList nodesList;

    public JobRuns() {
        nodesList = new NodesList();
        nodesList.init();

    }

    private Map<String, List<String>> resetJobsMap(HttpServletRequest request) {
        List<String> empty = new ArrayList<>();
        empty.add("");
        logger.info(this.getClass().getName()+": initialize Jobs lists and maps");

        Map<String, List<String>> jobsMap = new HashMap<>();
        jobsMap.put("nodeList", new ArrayList<>());
        jobsMap.get("nodeList").add("");
        jobsMap.put("jobIdList", new ArrayList<>());
        jobsMap.get("jobIdList").add("");
        jobsMap.put("statusList", new ArrayList<>());
        jobsMap.get("statusList").add("");
        jobsMap.put("beginList", new ArrayList<>());
        jobsMap.get("beginList").add("");
        jobsMap.put("endList", new ArrayList<>());
        jobsMap.get("endList").add("");
        jobsMap.put("infoList", new ArrayList<>());
        jobsMap.get("infoList").add("");
        jobsMap.put("otherList", new ArrayList<>());
        jobsMap.get("otherList").add("");

        request.setAttribute("jobsMap", jobsMap);
        request.setAttribute("jobNodeList", empty);
        request.setAttribute("jobIdList", empty);
        request.setAttribute("jobStatusList", empty);
        request.setAttribute("beginList", empty);
        request.setAttribute("endList", empty);
        request.setAttribute("infoList", empty);
        request.setAttribute("otherList", empty);

        return jobsMap;
    }

    private Map<String, List<String>> resetNodesMap(HttpServletRequest request) {
        List<String> empty = new ArrayList<>();
        empty.add("");
        logger.info(this.getClass().getName()+": initialize Nodes lists and maps");

        Map<String, List<String>> duasMap = new HashMap<>();
        duasMap.put("company", new ArrayList<>());
        duasMap.get("company").add("");
        duasMap.put("node", new ArrayList<>());
        duasMap.get("node").add("");
        duasMap.put("area", new ArrayList<>());
        duasMap.get("area").add("");
        duasMap.put("version", new ArrayList<>());
        duasMap.get("version").add("");
        duasMap.put("status", new ArrayList<>());

        duasMap.get("status").add("");
        request.setAttribute("duasMap", duasMap);
        request.setAttribute("companyList", empty);
        request.setAttribute("nodeList", empty);
        request.setAttribute("areaList", empty);
        request.setAttribute("versionList", empty);
        request.setAttribute("statusList", empty);

        return duasMap;
    }

    public JobRuns(HttpServletRequest request) {

        logger.info(this.getClass().getName()+": initialize all lists and maps");

        Map<String, List<String>> duasMap = resetNodesMap(request);
        Map<String, List<String>> jobsMap = resetJobsMap(request);

        nodesList = new NodesList();
        nodesList.init();
        nodesList.setInRequest(request);
    }

    public NodesList getNodesList() {
        return (NodesList) nodesList;
    }

    public boolean getDUEnvironmentList(HttpServletRequest request, UvmsConnection uvmsConnection) {
        Client duwsClient = null;
        try {
            duwsClient = new Client();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        Map<String, List<String>> duasMap;
        boolean ret = false;

        if(uvmsConnection == null) {
            logger.info(this.getClass().getName()+": No user stored yet in session");
            uvmsConnection = new UvmsConnection();
        } else {
            try {
                duasMap = duwsClient.getDUEnvironmentList(uvmsConnection, (NodesList) nodesList);
            } catch (Exception e) {
                logger.error(this.getClass().getName()+": "+duwsClient.getLastResponse()+ "("+duwsClient.getLastResult()+")");
                logger.error("Exception: ",e);
                e.printStackTrace();
                duasMap = null;
            }

            if(duasMap != null) {
                logger.info(this.getClass().getName()+"/getDUEnvironmentList: Add data to duasMap");
                request.setAttribute("duasMap", duasMap);
                request.setAttribute("companyList", duasMap.get("company"));
                request.setAttribute("nodeList", duasMap.get("node"));
                request.setAttribute("areaList", duasMap.get("area"));
                request.setAttribute("versionList", duasMap.get("version"));
                request.setAttribute("statusList", duasMap.get("status"));
                nodesList.setInRequest(request);
                ret = true;
            } else {
                logger.error(this.getClass().getName()+"/getDUEnvironmentList: duasMap = null");
                duasMap = resetNodesMap(request);
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
        Map<String, List<String>> jobsMap = new HashMap<>();
        boolean ret = false;

        List<String> companyList = (List<String>) request.getAttribute("companyList");
        List<String> nodeList  = (List<String>) request.getAttribute("nodeList");
        List<String> areaList = (List<String>) request.getAttribute("areaList");

        if(companyList == null || companyList.isEmpty()) {
            logger.error(this.getClass().getName()+"/getListExecution: companyList null or empty");
        }
        if(nodeList == null || nodeList.isEmpty()) {
            logger.error(this.getClass().getName()+"/getListExecution: nodeList null or empty");
        }
        if(areaList == null || areaList.isEmpty()) {
            logger.error(this.getClass().getName()+"/getListExecution: areaList null or empty");
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
            logger.info(this.getClass().getName()+"/getListExecution: Nodes selected by form:");
            for (String idx : currentNodesList) {
                logger.info(this.getClass().getName() + "/getListExecution: node " + idx + "=" + companyList.get(Integer.parseInt(idx)) + "|" + nodeList.get(Integer.parseInt(idx)) + "|" + areaList.get(Integer.parseInt(idx)));
                try {
                    ret = duwsClient.getListExecution(uvmsConnection, companyList.get(Integer.parseInt(idx)), nodeList.get(Integer.parseInt(idx)), areaList.get(Integer.parseInt(idx)), jobsMap);
                } catch (Exception e) {
                    logger.error(this.getClass().getName() + ": " + duwsClient.getLastResponse() + "(" + duwsClient.getLastResult() + ")");
                    logger.error("Exception: ", e);
                    e.printStackTrace();
                }
            }
            logger.info(this.getClass().getName()+"/getListExecution: Add data to jobsMap");
            request.setAttribute("jobsMap", jobsMap);
            request.setAttribute("jobNodeList", jobsMap.get("nodeList"));
            request.setAttribute("jobIdList", jobsMap.get("jobIdList"));
            request.setAttribute("jobStatusList", jobsMap.get("statusList"));
            request.setAttribute("beginList", jobsMap.get("beginList"));
            request.setAttribute("endList", jobsMap.get("endList"));
            request.setAttribute("infoList", jobsMap.get("infoList"));
            request.setAttribute("otherList", jobsMap.get("otherList"));
            ret = true;
        } else {
            logger.info(this.getClass().getName()+"/getListExecution: No nodes selected in form");
            jobsMap = resetJobsMap(request);
            ret = false;
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
        boolean ret = false;

        String company = request.getParameter("company");
        String node  = request.getParameter("node");
        String area = request.getParameter("area");
        String task = request.getParameter("task");
        String session = request.getParameter("session");
        String uproc = request.getParameter("uproc");
        String mu = request.getParameter("mu");
        String numJob = request.getParameter("numjob");
        String numSess = request.getParameter("numsess");

        if(company == null || company.isEmpty()) {
            logger.error(this.getClass().getName()+"/getListExecution: companyList null or empty");
        }
        if(node == null || node.isEmpty()) {
            logger.error(this.getClass().getName()+"/getListExecution: nodeList null or empty");
        }
        if(area == null || area.isEmpty()) {
            logger.error(this.getClass().getName()+"/getListExecution: areaList null or empty");
        }

        jobLogs = duwsClient.getJobLogs(uvmsConnection, company, node, area, task, session, uproc, mu, numSess, numJob);

        request.setAttribute("historyTrace", jobLogs.get("historyTrace"));
        request.setAttribute("jobLog", jobLogs.get("jobLog"));

        return ret;
    }
}
