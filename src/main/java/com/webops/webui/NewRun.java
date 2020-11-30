package com.webops.webui;

import com.duws.JobRuns;
import com.webops.duas.JobInfo;
import com.webops.duas.UvmsConnection;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class NewRun extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(NewRun.class);
    private static final String PAGE_LOGIN = "/WEB-INF/views/login.jsp";
    private static final String PAGE_NEW = "/WEB-INF/views/new.jsp";
    private static final String ATTR_UVMSCONN = "uvmsConnection";
    private static final String ATTR_CONTEXT = "selectedContext";
    private static final String ATTR_SELECTEDNODES = "selectedNodes";
    private static final String ATTR_INPUTTASK = "inputTask";
    private static final String ATTR_INPUTSESSION = "inputSession";
    private static final String ATTR_INPUTUPROC = "inputUproc";
    private static final String ATTR_INPUTMU = "inputMu";
    private static final String ATTR_INPUTUSER = "inputUser";
    private static final String ATTR_INPUTQUEUE = "inputQueue";
    private static final String ATTR_INPUTSTARTDATE = "inputStartD";
    private static final String ATTR_INPUTSTARTTIME = "inputStartT";
    private static final String ATTR_INPUTENDDATE = "inputEndD";
    private static final String ATTR_INPUTENDTIME = "inputEndT";
    private static final String ATTR_INPUTPROCESSINGDATE = "inputPdate";
    private static final String VALUE_NONE = "none";
    private static final String ATTR_LASTRESULT = "lastResult";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewRun() {
        super();
        // TODO Auto-generated constructor stub

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UvmsConnection uvmsConnection = (UvmsConnection) session.getAttribute(ATTR_UVMSCONN);
        SettingsMap settings = new SettingsMap();

        settings.setFromSession(request);
        settings.setFromRequest(request);

        if(uvmsConnection == null || uvmsConnection.isDisconnected()) {
            logger.info(this.getServletName()+"/doPost: No user stored in session");
            session.setAttribute(ATTR_UVMSCONN, uvmsConnection);
            request.setAttribute(ATTR_UVMSCONN, uvmsConnection);
            this.getServletContext().getRequestDispatcher(PAGE_LOGIN).forward(request, response);
        }

        JobRuns jobRuns = new JobRuns();
        jobRuns.setFromSession(request);
        boolean ret;

        JobInfo newRun = new JobInfo();

        newRun.addEntry("task", request.getParameter(ATTR_INPUTTASK));
        newRun.addEntry("session", request.getParameter(ATTR_INPUTSESSION));
        newRun.addEntry("uproc", request.getParameter(ATTR_INPUTUPROC));
        newRun.addEntry("mu", request.getParameter(ATTR_INPUTMU));
        newRun.addEntry("user", request.getParameter(ATTR_INPUTUSER));
        newRun.addEntry("queue", request.getParameter(ATTR_INPUTQUEUE));
        newRun.addEntry("start_date", request.getParameter(ATTR_INPUTSTARTDATE));
        newRun.addEntry("start_time", request.getParameter(ATTR_INPUTSTARTTIME));
        newRun.addEntry("end_date", request.getParameter(ATTR_INPUTENDDATE));
        newRun.addEntry("end_time", request.getParameter(ATTR_INPUTENDTIME));
        newRun.addEntry("pDate", request.getParameter(ATTR_INPUTPROCESSINGDATE));
        newRun.log();

        ret = jobRuns.getDUEnvironmentList(request, uvmsConnection);
        if(!ret) {
            logger.error(this.getServletName()+"/doPost: Failed to get list of nodes");
            request.setAttribute(ATTR_LASTRESULT, "Failed to get list of nodes");
        }

        if(request.getParameterValues(ATTR_SELECTEDNODES) != null) {
            settings.setSelectedContext(request.getParameterValues(ATTR_SELECTEDNODES));
        }

        if(request.getParameter(ATTR_INPUTUPROC) != null) {
            if(!request.getParameter(ATTR_INPUTUPROC).isEmpty() && !request.getParameter(ATTR_INPUTUPROC).equals(VALUE_NONE)) {
                ret = jobRuns.addLaunch(request, uvmsConnection, jobRuns.getNodesList().getItems().get(Integer.parseInt(settings.getSelectedContext().get(0))), newRun);
                if(!ret) {
                    logger.error(this.getServletName()+"/doPost: Failed to create launch");
                    request.setAttribute(ATTR_LASTRESULT, "Failed to create launch");
                }
            }
            else {
                logger.info(this.getServletName()+"/doPost: parameter "+ATTR_INPUTUPROC+" EMPTY: nothing to launch");
            }
        }

        if(request.getParameterValues(ATTR_SELECTEDNODES) != null) {
            settings.setSelectedContext(request.getParameterValues(ATTR_SELECTEDNODES));

            ret = jobRuns.getObjectsForNewRun(request, uvmsConnection, jobRuns.getNodesList().getItems().get(Integer.parseInt(settings.getSelectedContext().get(0))));
            if(!ret) {
                logger.error(this.getServletName()+"/doPost: Failed to get list of objects for new run form");
                request.setAttribute(ATTR_LASTRESULT, "Failed to get list of objects for new run form");
            }
        }

        settings.setInSession(session);
        jobRuns.setInRequest(request);
        jobRuns.setInSession(request);
        request.setAttribute(ATTR_UVMSCONN, uvmsConnection);

        this.getServletContext().getRequestDispatcher(PAGE_NEW).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean ret;
        HttpSession session = request.getSession();
        UvmsConnection uvmsConnection = (UvmsConnection) session.getAttribute(ATTR_UVMSCONN);
        List<String> selectedNodes;
        boolean contextSelected = false;

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

        JobRuns jobRuns = new JobRuns();
        jobRuns.getFromRequest(request);

        if(jobRuns.getNodesList().getSize() == 0) {
            ret = jobRuns.getDUEnvironmentList(request, uvmsConnection);
            if (!ret) {
                logger.error(this.getServletName() + "/doGet: Failed to get list of nodes");
                request.setAttribute(ATTR_LASTRESULT, "Failed to get list of nodes");
            }
        }
        if(request.getParameterValues(ATTR_SELECTEDNODES) != null) {
            settings.setSelectedContext(request.getParameterValues(ATTR_SELECTEDNODES));
            contextSelected = true;
        } else {
            if(session.getAttribute(ATTR_CONTEXT) != null) {
                selectedNodes = (List<String>) session.getAttribute(ATTR_CONTEXT);
                settings.setSelectedContext(selectedNodes);
                contextSelected = true;
            }
        }
        if(contextSelected) {
            if (jobRuns.getTaskList().getSize() == 0 || jobRuns.getMuList().getSize() == 0 || jobRuns.getSessionList().getSize() == 0 || jobRuns.getUprocList().getSize() == 0) {
                ret = false;
                if(!settings.getSelectedContext().isEmpty()) {
                    ret = jobRuns.getObjectsForNewRun(request, uvmsConnection, jobRuns.getNodesList().getItems().get(Integer.parseInt(settings.getSelectedContext().get(0))));
                }
                if (!ret) {
                    logger.error(this.getServletName() + "/doPost: Failed to get list of objects for new run form");
                    request.setAttribute(ATTR_LASTRESULT, "Failed to get list of objects for new run form");
                }
            }
        }

        jobRuns.setInRequest(request);
        jobRuns.setInSession(request);
        request.setAttribute(ATTR_UVMSCONN, uvmsConnection);

        this.getServletContext().getRequestDispatcher(PAGE_NEW).forward(request, response);
    }
}
