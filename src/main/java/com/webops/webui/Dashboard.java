package com.webops.webui;

import com.duws.JobRuns;
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

        logger.info(this.getServletName()+"/doPost: going to "+PAGE_DASHBOARD);
        this.getServletContext().getRequestDispatcher(PAGE_DASHBOARD).forward(request, response);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
        if(request.getAttribute(ATTR_JOBSLIST) == null) {
            jobRuns.getJobsList().setInRequest(request);
        }
        if(request.getAttribute(ATTR_NODESLIST) == null) {
            jobRuns.getNodesList().setInRequest(request);
        }
        boolean ret;

        boolean refresh = settings.getItem(ATTR_REFRESH).equals("true");
        String action = request.getParameter(ATTR_ACTION);
        if(action != null) {
/*
            if(action.equals("udpate")) {
                this.getServletContext().getRequestDispatcher(PAGE_UPDATE).forward(request, response);
            }
            if(action.equals("rerun")) {
                this.getServletContext().getRequestDispatcher(PAGE_RERUN).forward(request, response);
            }
*/
            ret = jobRuns.actionOnJob(request, uvmsConnection);
            if(ret) {
                refresh = true;
            }
        }
        String offset = request.getParameter("offset");
        String timer = request.getParameter("timer");
        String chart = request.getParameter("chart");
        if(offset != null) {
            settings.setItemFromSelectValue("offset",offset);
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

        logger.info(this.getServletName()+"/doGet: got from session="+ uvmsConnection.toString());

        //TODO: delete this line: ?
        //request.setAttribute(ATTR_UVMSCONN, uvmsConnection);

        logger.info(this.getServletName()+"/doGet: going to "+PAGE_DASHBOARD);
        this.getServletContext().getRequestDispatcher(PAGE_DASHBOARD).forward(request, response);
    }
}
