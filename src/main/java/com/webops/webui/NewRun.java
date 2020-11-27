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

    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewRun() {
        super();
        // TODO Auto-generated constructor stub

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UvmsConnection uvmsConnection = (UvmsConnection) session.getAttribute("uvmsConnection");
        SettingsMap settings = new SettingsMap();

        settings.setFromSession(request);
        settings.setFromRequest(request);

        if(uvmsConnection == null || uvmsConnection.getToken().equals("disconnected")) {
            logger.info(this.getServletName()+"/doPost: No user stored in session");
            session.setAttribute("uvmsConnection", uvmsConnection);
            request.setAttribute("uvmsConnection", uvmsConnection);
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }

        JobRuns jobRuns = new JobRuns();
        jobRuns.setFromSession(request);
        boolean ret;

        JobInfo newRun = new JobInfo();

        newRun.addEntry("task", request.getParameter("inputTask"));
        newRun.addEntry("session", request.getParameter("inputSession"));
        newRun.addEntry("uproc", request.getParameter("inputUproc"));
        newRun.addEntry("mu", request.getParameter("inputMu"));
        newRun.addEntry("user", request.getParameter("inputUser"));
        newRun.addEntry("queue", request.getParameter("inputQueue"));
        newRun.addEntry("start_date", request.getParameter("inputStartD"));
        newRun.addEntry("start_time", request.getParameter("inputStartT"));
        newRun.addEntry("end_date", request.getParameter("inputEndD"));
        newRun.addEntry("end_time", request.getParameter("inputEndT"));
        newRun.addEntry("pDate", request.getParameter("inputPdate"));
        newRun.log();

        ret = jobRuns.getDUEnvironmentList(request, uvmsConnection);
        if(!ret) {
            logger.error(this.getServletName()+"/doPost: Failed to get list of nodes");
            request.setAttribute("error", "Failed to get list of nodes");
        }

        if(request.getParameterValues("selectedNodes") != null) {
            settings.setSelectedContext(request.getParameterValues("selectedNodes"));
        }

        if(request.getParameter("inputUproc") != null) {
            if(!request.getParameter("inputUproc").isEmpty() && !request.getParameter("inputUproc").equals("none")) {
                ret = jobRuns.addLaunch(request, uvmsConnection, jobRuns.getNodesList().getItems().get(Integer.parseInt(settings.getSelectedContext().get(0))), newRun);
                if(!ret) {
                    logger.error(this.getServletName()+"/doPost: Failed to create launch");
                    request.setAttribute("error", "Failed to create launch");
                }
            }
            else {
                logger.info(this.getServletName()+"/doPost: parameter inputUproc EMPTY: nothing to launch");
            }
        }

        if(request.getParameterValues("selectedNodes") != null) {
            settings.setSelectedContext(request.getParameterValues("selectedNodes"));

            ret = jobRuns.getObjectsForNewRun(request, uvmsConnection, jobRuns.getNodesList().getItems().get(Integer.parseInt(settings.getSelectedContext().get(0))));
            if(!ret) {
                logger.error(this.getServletName()+"/doPost: Failed to get list of objects for new run form");
                request.setAttribute("error", "Failed to get list of objects for new run form");
            }
        }

        settings.setInSession(session);
        jobRuns.setInRequest(request);
        jobRuns.setInSession(request);
        request.setAttribute("uvmsConnection", uvmsConnection);

        this.getServletContext().getRequestDispatcher("/WEB-INF/views/new.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        boolean ret;
        HttpSession session = request.getSession();
        UvmsConnection uvmsConnection = (UvmsConnection) session.getAttribute("uvmsConnection");
        List<String> selectedNodes;
        boolean contextSelected = false;

        //TODO: Add get from session: Audit
        SettingsMap settings = new SettingsMap();

        //get from session: SettingsMap
        settings.setFromSession(request);
        settings.setFromRequest(request);

        if(uvmsConnection == null || uvmsConnection.getToken().equals("disconnected")) {
            logger.info(this.getServletName()+"/doGet: No user stored in session");
            session.setAttribute("uvmsConnection", uvmsConnection);
            request.setAttribute("uvmsConnection", uvmsConnection);
            this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }

        JobRuns jobRuns = new JobRuns();
        jobRuns.getFromRequest(request);

        if(jobRuns.getNodesList().getSize() == 0) {
            ret = jobRuns.getDUEnvironmentList(request, uvmsConnection);
            if (!ret) {
                logger.error(this.getServletName() + "/doGet: Failed to get list of nodes");
                request.setAttribute("error", "Failed to get list of nodes");
            }
        }
        if(request.getParameterValues("selectedNodes") != null) {
            settings.setSelectedContext(request.getParameterValues("selectedNodes"));
            contextSelected = true;
        } else {
            if(session.getAttribute("selectedContext") != null) {
                selectedNodes = (List<String>) session.getAttribute("selectedContext");
                settings.setSelectedContext(selectedNodes);
                contextSelected = true;
            }
        }
        if(contextSelected) {
            if (jobRuns.getTaskList().getSize() == 0 || jobRuns.getMuList().getSize() == 0 || jobRuns.getSessionList().getSize() == 0 || jobRuns.getUprocList().getSize() == 0) {
                ret = false;
                if(!settings.getSelectedContext().isEmpty()){
                    ret = jobRuns.getObjectsForNewRun(request, uvmsConnection, jobRuns.getNodesList().getItems().get(Integer.parseInt(settings.getSelectedContext().get(0))));
                }
                if (!ret) {
                    logger.error(this.getServletName() + "/doPost: Failed to get list of objects for new run form");
                    request.setAttribute("error", "Failed to get list of objects for new run form");
                }
            }
        }

        jobRuns.setInRequest(request);
        jobRuns.setInSession(request);
        request.setAttribute("uvmsConnection", uvmsConnection);

        this.getServletContext().getRequestDispatcher("/WEB-INF/views/new.jsp").forward(request, response);
    }
}
