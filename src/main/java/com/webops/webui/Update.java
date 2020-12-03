package com.webops.webui;

import com.duws.JobRuns;
import com.webops.duas.JobInfo;
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

@WebServlet(urlPatterns = "/update")
public class Update extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(NewRun.class);
    private static final String PAGE_LOGIN = "/WEB-INF/views/login.jsp";
    private static final String PAGE_UPDATE = "/WEB-INF/views/update.jsp";
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
    //private static final String VALUE_NONE = "none";
    private static final String ATTR_LASTRESULT = "lastResult";
    private static final String ATTR_INPUTPRIORITY = "inputPriority";
    private static final String ATTR_INPUTNUMLANC = "inputNumlanc";
    private static final String ATTR_INPUTNUMSESS = "inputNumsess";
    private static final String ATTR_INPUTNUMPROC = "inputNumproc";
    private static final String ATTR_INPUTNUMENTRY = "inputNumentry";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
        super();
        // TODO Auto-generated constructor stub

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UvmsConnection uvmsConnection = (UvmsConnection) session.getAttribute(ATTR_UVMSCONN);
        SettingsMap settings = new SettingsMap();

        settings.setFromSession(request);

        if(uvmsConnection == null || uvmsConnection.isDisconnected()) {
            logger.info(this.getServletName()+"/doPost: No user stored in session");
            session.setAttribute(ATTR_UVMSCONN, uvmsConnection);
            request.setAttribute(ATTR_UVMSCONN, uvmsConnection);
            this.getServletContext().getRequestDispatcher(PAGE_LOGIN).forward(request, response);
        }

        logger.info(this.getServletName()+"/doPost: entering...");

        JobRuns jobRuns = new JobRuns();
        jobRuns.getFromRequest(request);
        boolean ret;

        JobInfo newRun = jobRuns.getJobInfo();

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
        newRun.addEntry("priority", request.getParameter(ATTR_INPUTPRIORITY));
        newRun.addEntry("numlanc", request.getParameter(ATTR_INPUTNUMLANC));
        newRun.addEntry("numsess", request.getParameter(ATTR_INPUTNUMSESS));
        newRun.addEntry("numproc", request.getParameter(ATTR_INPUTNUMPROC));
        newRun.addEntry("numentry", request.getParameter(ATTR_INPUTNUMENTRY));
        if(newRun.getEntry("task").equals("-")) {
            newRun.putEntry("task", "");
        }
        if(newRun.getEntry("session").equals("-")) {
            newRun.putEntry("session", "");
        }
        newRun.log();

        ret = jobRuns.getDUEnvironmentList(request, uvmsConnection);
        if(!ret) {
            logger.error(this.getServletName()+"/doPost: Failed to get list of nodes");
        }

        if(request.getParameterValues(ATTR_SELECTEDNODES) != null) {
            settings.setSelectedContext(request.getParameterValues(ATTR_SELECTEDNODES));
        }

        ret = jobRuns.updateLaunch(request, uvmsConnection, jobRuns.getNodesList().getItems().get(Integer.parseInt(settings.getSelectedContext().get(0))), newRun);
        if(!ret) {
            logger.error(this.getServletName()+"/doPost: Failed to update launch");
        }
        if(request.getParameterValues(ATTR_SELECTEDNODES) != null) {
            settings.setSelectedContext(request.getParameterValues(ATTR_SELECTEDNODES));
        }

        settings.setInSession(request);
        jobRuns.setInRequest(request);
        jobRuns.setInSession(request);
        //request.setAttribute(ATTR_UVMSCONN, uvmsConnection);

        logger.info(this.getServletName()+"/doPost: going to "+PAGE_UPDATE);
        this.getServletContext().getRequestDispatcher(PAGE_UPDATE).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean ret;
        HttpSession session = request.getSession();
        UvmsConnection uvmsConnection = (UvmsConnection) session.getAttribute(ATTR_UVMSCONN);
        List<String> selectedNodes;

        //TODO: Add get from session: Audit
        SettingsMap settings = new SettingsMap();

        //get from session: SettingsMap
        settings.setFromSession(request);

        if(uvmsConnection == null || uvmsConnection.isDisconnected()) {
            logger.info(this.getServletName()+"/doGet: No user stored in session");
            session.setAttribute(ATTR_UVMSCONN, uvmsConnection);
            request.setAttribute(ATTR_UVMSCONN, uvmsConnection);
            this.getServletContext().getRequestDispatcher(PAGE_LOGIN).forward(request, response);
        }

        logger.info(this.getServletName()+"/doGet: entering...");
        JobRuns jobRuns = new JobRuns();
        jobRuns.getFromRequest(request);
        logger.info(this.getServletName()+"/doGet: job info=");
        jobRuns.getJobInfo().log();

        if(jobRuns.getNodesList().getSize() == 0) {
            ret = jobRuns.getDUEnvironmentList(request, uvmsConnection);
            if (!ret) {
                logger.error(this.getServletName() + "/doGet: Failed to get list of nodes");
            }
        }
        if(request.getParameterValues(ATTR_SELECTEDNODES) != null) {
            settings.setSelectedContext(request.getParameterValues(ATTR_SELECTEDNODES));
        } else {
            if(session.getAttribute(ATTR_CONTEXT) != null) {
                selectedNodes = (List<String>) session.getAttribute(ATTR_CONTEXT);
                settings.setSelectedContext(selectedNodes);
            }
        }

        jobRuns.setInRequest(request);
        jobRuns.setInSession(request);
        //request.setAttribute(ATTR_UVMSCONN, uvmsConnection);

        logger.info(this.getServletName()+"/doGet: going to "+PAGE_UPDATE);
        this.getServletContext().getRequestDispatcher(PAGE_UPDATE).forward(request, response);
    }
}
