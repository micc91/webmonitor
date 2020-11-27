package com.webops.webui;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.duws.Client;
import com.duws.JobRuns;
import com.webops.duas.UvmsConnection;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
//@WebServlet("/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Login.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		HttpSession session = request.getSession();
		UvmsConnection uvmsConnection = (UvmsConnection) session.getAttribute("uvmsConnection");
		if(uvmsConnection == null) {
			logger.info(this.getServletName() + "/doGet: no data stored yet in session");
			uvmsConnection = new UvmsConnection();
		}
		else {
			logger.info(this.getServletName() + "/doGet: got from session=" + uvmsConnection.toString());
		}
		request.setAttribute("uvmsConnection", uvmsConnection);

		this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String result;
		Map<String, String> errors = new HashMap<>();
		HttpSession session = request.getSession();
		Client duwsClient = new Client();
		String nextPage = "login.jsp";
		SettingsMap settingsMap = new SettingsMap();
		settingsMap.init();
		settingsMap.setInSession(session);
		int returnCode = 0;

		UvmsConnection uvmsConnection = (UvmsConnection) session.getAttribute("uvmsConnection");
		if(uvmsConnection == null) {
			logger.info(this.getServletName()+"/doPost: No user already stored in session");
			uvmsConnection = new UvmsConnection();
		}

		/* Validation du champ login. */
		try {
			uvmsConnection.setLogin( request.getParameter("inputLogin"));
		} catch ( Exception e ) {
			errors.put( "inputLogin", e.getMessage() );
		}
		uvmsConnection.setPassword( request.getParameter("inputPassword"));
		try {
			uvmsConnection.setUvmsHost(request.getParameter("inputUvms"));
		} catch ( Exception e ) {
			errors.put( "inputUvms", e.getMessage() );
		}
		try {
			uvmsConnection.setUvmsPort( request.getParameter("inputPort"));
		} catch ( Exception e ) {
			errors.put( "inputPort", e.getMessage() );
		}

		/* Initialisation du résultat global de la validation. */
		if ( errors.isEmpty() ) {
			result = "Entered data are valid";
			uvmsConnection.setToken(duwsClient.login(uvmsConnection));
			if(uvmsConnection.getToken().equals("disconnected")) {
				result=result+" but "+duwsClient.getLastResponse()+ "("+duwsClient.getLastResult()+")";
				nextPage = "login.jsp";
				returnCode = duwsClient.getLastResult();
			}
		} else {
			result = "Bad input data. Please fix and retry";
			nextPage = "login.jsp";
			returnCode = 1;
		}

		JobRuns jobRuns = new JobRuns(request);

		if(!uvmsConnection.getToken().equals("disconnected")) {
			boolean ret;

			ret = jobRuns.getDUEnvironmentList(request, uvmsConnection);
			if(!ret) {
				request.setAttribute("error", "Failed to get list of nodes");
			} else {
				nextPage = "dashboard.jsp";
			}
		}

		/* Stockage du résultat et des messages d'erreur dans l'objet request */
		request.setAttribute( "errors", errors );
		if(!result.isEmpty()) {
			request.setAttribute("lastresult", result);
			request.setAttribute("returnCode", returnCode);
		} else {
			request.setAttribute("lastresult", duwsClient.getLastResponse());
			request.setAttribute("returnCode", duwsClient.getLastResult());
		}

		session.setAttribute("uvmsConnection", uvmsConnection);
		request.setAttribute("uvmsConnection", uvmsConnection);

		logger.info(this.getServletName()+"/doPost: received from Jsp="+ uvmsConnection.toString()+" => "+result);
		this.getServletContext().getRequestDispatcher("/WEB-INF/views/"+nextPage).forward(request, response);
	}

}
