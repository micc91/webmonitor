package com.webops.webui;

import java.io.IOException;

import com.duws.JobRuns;
import com.webops.duas.UvmsConnection;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Page
 */
//@WebServlet("/test")
public class Info extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Info.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Info() {
        super();
        // TODO Auto-generated constructor stub

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		UvmsConnection uvmsConnection = (UvmsConnection) session.getAttribute("uvmsConnection");

		if(uvmsConnection == null) {
			logger.info(this.getServletName()+"/doGet: No user stored yet in session");
			this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
		}

		JobRuns jobRuns = new JobRuns();
		boolean ret = false;
		ret = jobRuns.getJobLogs(request, uvmsConnection);
		if(!ret) {
			logger.error(this.getServletName()+"/doGet: Failed to get logs of job");
			request.setAttribute("error", "Failed to get logs of job");
		}

		logger.info(this.getServletName()+"/doGet: got from session="+ uvmsConnection.toString());
		request.setAttribute("uvmsConnection", uvmsConnection);

		this.getServletContext().getRequestDispatcher("/WEB-INF/views/info.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
