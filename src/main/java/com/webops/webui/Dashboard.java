package com.webops.webui;

import com.duws.JobRuns;
import com.webops.duas.JobInfo;
import com.webops.duas.JobsList;
import com.webops.duas.UvmsConnection;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@WebServlet(urlPatterns = "/dashboard")
public class Dashboard extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Dashboard.class);

    private static final String PAGE_LOGIN = "/WEB-INF/views/login.jsp";
    private static final String PAGE_DASHBOARD = "/WEB-INF/views/dashboard.jsp";
    private static final String ATTR_UVMSCONN = "uvmsConnection";
    private static final String ATTR_CONTEXT = "selectedContext";
    private static final String ATTR_SELECTEDNODES = "selectedNodes";
    private static final String ATTR_NODESLIST = "nodesList";
    private static final String ATTR_JOBSLIST = "jobsList";
    private static final String ATTR_REFRESH = "refresh";
    private static final String ATTR_ACTION = "action";
    private static final String ATTR_IDLIST = "idlist";
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dashboard() {
        super();
        // TODO Auto-generated constructor stub

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UvmsConnection uvmsConnection = (UvmsConnection) session.getAttribute(ATTR_UVMSCONN);
        SettingsMap settings = new SettingsMap();

        settings.setFromSession(request);
        settings.setFromRequest(request);

        if(uvmsConnection == null || uvmsConnection.isDisconnected()) {
            logger.info(this.getServletName()+"/doGet: No user stored in session");
            session.setAttribute(ATTR_UVMSCONN, uvmsConnection);
            request.setAttribute(ATTR_UVMSCONN, uvmsConnection);
            this.getServletContext().getRequestDispatcher(PAGE_LOGIN).forward(request, response);
        }
        logger.info(this.getServletName()+"/doPost: Entering... ");

        JobRuns jobRuns = new JobRuns();
        boolean ret;

        ret = jobRuns.getDUEnvironmentList(request, uvmsConnection);
        if(!ret) {
            logger.error(this.getServletName()+"/doPost: Failed to get list of nodes");
            request.setAttribute("error", "Failed to get list of nodes");
        }

        if(request.getParameterValues(ATTR_SELECTEDNODES) != null) {
            settings.resetSelectedContext();
            logger.info(this.getServletName()+"/doPost: New nodes selected in form: ");
            settings.setSelectedContext(request.getParameterValues(ATTR_SELECTEDNODES));
        }


        String offset = "none";
        if(settings.getItem("offset") != null) {
            offset = settings.getItem("offset").split("#")[0];
        }

        ret = jobRuns.getListExecution(request, uvmsConnection, settings.getSelectedContext(), offset);
        if(!ret) {
            logger.error(this.getServletName()+"/doPost: Failed to get list of runs");
            request.setAttribute("error", "Failed to get list of job runs");
        }
        logger.info(this.getServletName()+"/doPost: got from session="+ uvmsConnection.toString());

        //TODO: delete this line: ?
        //request.setAttribute(ATTR_UVMSCONN, uvmsConnection);
        settings.setInSession(request);
        jobRuns.setInSession(request);

        logger.info(this.getServletName()+"/doPost: going to "+PAGE_DASHBOARD);
        this.getServletContext().getRequestDispatcher(PAGE_DASHBOARD).forward(request, response);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int returnCode = 0;
        String lastResult = "";
        HttpSession session = request.getSession();
        UvmsConnection uvmsConnection = (UvmsConnection) session.getAttribute(ATTR_UVMSCONN);
        List<String> selectedNodes = (List<String>) session.getAttribute(ATTR_CONTEXT);
        //TODO: Add get from session: Audit
        SettingsMap settings = new SettingsMap();

        //get from session: SettingsMap
        settings.setFromSession(request);
        settings.setFromRequest(request);

        if(uvmsConnection == null || uvmsConnection.isDisconnected()) {
            logger.info(this.getServletName()+"/doGet: No user stored in session");
            session.setAttribute(ATTR_UVMSCONN, uvmsConnection);
            request.setAttribute(ATTR_UVMSCONN, uvmsConnection);
            this.getServletContext().getRequestDispatcher(PAGE_LOGIN).forward(request, response);
        }
        logger.info(this.getServletName()+"/doGet: Entering... ");

        JobRuns jobRuns = new JobRuns();
        if(session.getAttribute(ATTR_JOBSLIST) == null) {
            logger.info(this.getServletName()+"/doGet: initialize jobs list");
            jobRuns.getJobsList().setInRequest(request);
        } else {
            jobRuns.getJobsList().setFromSession(request);
        }
        if(session.getAttribute(ATTR_NODESLIST) == null) {
            logger.info(this.getServletName()+"/doGet: initialize nodes list");
            jobRuns.getNodesList().setInRequest(request);
        } else {
            jobRuns.getNodesList().setFromSession(request);
        }
        boolean ret;

        boolean refresh = settings.getItem(ATTR_REFRESH).equals("true");
        String action = request.getParameter(ATTR_ACTION);
        if(action != null) {
            String idlist = request.getParameter(ATTR_IDLIST);

            if(idlist != null) {
                    boolean found;
                    lastResult="Action "+action+" on "+idlist.split(",").length+" jobs : ";
                    for(String id : idlist.split(",")) {
                        found = false;
                        int ii=0;
                        for(Map<String, String> job : jobRuns.getJobsList().getItems()) {
                            logger.info(this.getServletName()+"/doGet: "+ii+"/id="+id+"/ scanning job "+job.get("hashcode")+","+job.get("task")+","+job.get("session")+","+job.get("uproc")+","+job.get("mu")+","+job.get("status"));
                            if(job.get("hashcode").equals(id)) {
                                found = true;
                                ret = jobRuns.actionOnJob(request, uvmsConnection, job);
                                if (ret) {
                                    refresh = true;
                                } else {
                                    returnCode += jobRuns.getLastResult();
                                    lastResult = lastResult+"/"+jobRuns.getLastResponse();
                                }
                                break;
                            }
                            ii++;
                        }
                        if(!found) {
                            logger.error(this.getServletName() + "/doGet: job with id=" + id + " not found in list");
                        }
                    }
                    if(returnCode == 0) {
                        lastResult += "Successful!";
                    }
            } else {
                lastResult="Action "+action+" on 1 job : ";
                ret = jobRuns.actionOnJob(request, uvmsConnection, null);
                if (ret) {
                    refresh = true;
                    lastResult += "Successful!";
                } else {
                    returnCode = jobRuns.getLastResult();
                    lastResult = lastResult + jobRuns.getLastResponse();
                }
            }
        }
        String offset = request.getParameter("offset");
        String timer = request.getParameter("timer");
        String chart = request.getParameter("chart");
        if(offset != null) {
            settings.setItemFromSelectValue("offset",offset);
            logger.info(this.getServletName()+"/doGet: offset got from parameter="+offset+" => "+settings.getItem("offset"));
        } else {
            offset = settings.getItem("offset").split("#")[0];
        }
        if(timer != null) {
            settings.setItemFromSelectValue("timer",timer);
        }
        if(chart != null) {
            settings.setItemFromSelectValue("chart",chart);
        }

        // do not request data if already present in session - unless SettingsMap.refresh=true:
        if(refresh || jobRuns.getNodesList().getSize() == 0) {
            ret = jobRuns.getDUEnvironmentList(request, uvmsConnection);
            if (!ret) {
                logger.error(this.getServletName() + "/doGet: Failed to get list of nodes");
                request.setAttribute("error", "Failed to get list of nodes");
            }
        }

        ret = jobRuns.getListExecution(request, uvmsConnection, selectedNodes, offset);
        if(!ret) {
            logger.error(this.getServletName()+"/doGet: Failed to get list of runs");
            request.setAttribute("error", "Failed to get list of job runs");
        }

        //TODO: re-store data in session if a refresh has been done
        //...
        settings.setInSession(request);
        jobRuns.setInSession(request);

        logger.info(this.getServletName()+"/doGet: got from session="+ uvmsConnection.toString());

        //TODO: delete this line: ?
        //request.setAttribute(ATTR_UVMSCONN, uvmsConnection);
        if(action != null) {
            request.setAttribute("returnCode", returnCode);
            request.setAttribute("lastResult", lastResult);
        }
        logger.info(this.getServletName()+"/doGet: going to "+PAGE_DASHBOARD);
        this.getServletContext().getRequestDispatcher(PAGE_DASHBOARD).forward(request, response);
    }
}
