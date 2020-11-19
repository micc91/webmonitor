package com.webops.webui;

import com.duws.JobRuns;
import com.webops.duas.UvmsConnection;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dashboard extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Dashboard.class);

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
        UvmsConnection uvmsConnection = (UvmsConnection) session.getAttribute("uvmsConnection");

        JobRuns jobRuns = new JobRuns();
        boolean ret = false;

        ret = jobRuns.getDUEnvironmentList(request, uvmsConnection);
        if(!ret) {
            logger.error(this.getServletName()+"/doPost: Failed to get list of nodes");
            request.setAttribute("error", "Failed to get list of nodes");
        }

        ret = jobRuns.getListExecution(request, uvmsConnection, null);
        if(!ret) {
            logger.error(this.getServletName()+"/doPost: Failed to get list of runs");
            request.setAttribute("error", "Failed to get list of job runs");
        }
        logger.info(this.getServletName()+"/doPost: got from session="+ uvmsConnection.toString());

        //TODO: delete this line: ?
        request.setAttribute("uvmsConnection", uvmsConnection);

        List<String> selectedNodes = new ArrayList<>();
        for(String nodenum : request.getParameterValues("selectedNodes")) {
            selectedNodes.add(nodenum);
        }

        session.setAttribute("selectedContext", selectedNodes);
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/dashboard.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UvmsConnection uvmsConnection = (UvmsConnection) session.getAttribute("uvmsConnection");
        List<String> selectedNodes = (List<String>) session.getAttribute("selectedContext");
        //TODO: Add get from session: Audit, SettingsMap, selectedContext

        JobRuns jobRuns = new JobRuns();
        boolean ret = false;

        //TODO: do not request data if already present in session - unless SettingsMap.refresh=true:
        ret = jobRuns.getDUEnvironmentList(request, uvmsConnection);
        if(!ret) {
            logger.error(this.getServletName()+"/doGet: Failed to get list of nodes");
            request.setAttribute("error", "Failed to get list of nodes");
        }

        ret = jobRuns.getListExecution(request, uvmsConnection, selectedNodes);
        if(!ret) {
            logger.error(this.getServletName()+"/doGet: Failed to get list of runs");
            request.setAttribute("error", "Failed to get list of job runs");
        }

        //TODO: sort the lines of jobsList according to user selection : SettingsMap.sort + SettingsMap.order
        //...
        //TODO: restore data in session if a refresh has been done
        //...

        logger.info(this.getServletName()+"/doGet: got from session="+ uvmsConnection.toString());

        //TODO: delete this line: ?
        request.setAttribute("uvmsConnection", uvmsConnection);

        this.getServletContext().getRequestDispatcher("/WEB-INF/views/dashboard.jsp").forward(request, response);
    }
}
