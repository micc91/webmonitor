package com.webops.webui;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.duws.Client;
import com.duws.JobRuns;
import com.webops.duas.UvmsConnection;
import org.apache.log4j.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

/**
 * Servlet implementation class Login
 */
@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(Login.class);
	private static final String ATTR_UVMSCONN = "uvmsConnection";
	private static final String PAGE_LOGIN = "/WEB-INF/views/login.jsp";
	private static final String PAGE_DASHBOARD = "/dashboard";
	private static final String ATTR_LASTRESULT = "lastResult";
	private static final String ATTR_INPUTLOGIN = "inputLogin";
	private static final String ATTR_INPUTUVMS = "inputUvms";
	private static final String ATTR_INPUTPORT = "inputPort";
	private static final String ATTR_RETURNCODE = "returnCode";
	private static final String ATTR_INPUTPWD = "inputPassword";
	private static final String ATTR_INPUTERRORS = "errors";

	// cookies names
	private static final String CK_LASTLOGIN = "lastLogin";
	private static final String CK_LASTUVMS = "lastUvms";
	private static final String CK_LASTPORT = "lastPort";
	private static final int COOKIE_DURATION = 365 * 86400;
	private static final String ATTR_REMEMBER_CONN = "remember-conn";

	/**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub

	}

	/**
	 * Method retrieving the value of a cookie given its name
	 * from the HTTP request
	 */
	private static String getCookieValue( HttpServletRequest request, String name ) {
		Cookie[] cookies = request.getCookies();
		if ( cookies != null ) {
			for ( Cookie cookie : cookies ) {
				if ( cookie != null && name.equals( cookie.getName() ) ) {
					logger.info("Get cookie "+name+"="+cookie.getValue());
					return cookie.getValue();
				}
			}
		}
		return null;
	}

	/*
	 * Method handling the creation of a cookie and its adding to HTTP response
	 */
	private static void setCookie( HttpServletResponse response, String name, String value, int maxAge ) {
		Cookie cookie = new Cookie( name, value );
		cookie.setMaxAge( maxAge );
		response.addCookie( cookie );
		logger.info("Set cookie "+cookie.getName()+"="+cookie.getValue());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		String lastLogin = getCookieValue(request, CK_LASTLOGIN);
		String lastUvms = getCookieValue(request, CK_LASTUVMS);;
		String lastPort = getCookieValue(request, CK_LASTPORT);

		HttpSession session = request.getSession();
		UvmsConnection uvmsConnection = (UvmsConnection) session.getAttribute(ATTR_UVMSCONN);
		if(uvmsConnection == null) {
			logger.info(this.getServletName() + "/doGet: no data stored yet in session");
			uvmsConnection = new UvmsConnection(lastLogin, lastUvms, lastPort);
		}
		else {
			logger.info(this.getServletName() + "/doGet: got from session=" + uvmsConnection.toString());
		}
		session.setAttribute(ATTR_UVMSCONN, uvmsConnection);

		this.getServletContext().getRequestDispatcher(PAGE_LOGIN).forward(request, response);
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
		String nextPage = PAGE_LOGIN;
		SettingsMap settings = new SettingsMap();
		settings.init();
		settings.setInSession(request);
		int returnCode = 0;

		UvmsConnection uvmsConnection = (UvmsConnection) session.getAttribute(ATTR_UVMSCONN);
		if(uvmsConnection == null) {
			logger.info(this.getServletName()+"/doPost: No user already stored in session");
			uvmsConnection = new UvmsConnection();
		}

		/* Validation du champ login. */
		try {
			uvmsConnection.setLogin( request.getParameter(ATTR_INPUTLOGIN));
		} catch ( Exception e ) {
			errors.put( ATTR_INPUTLOGIN, e.getMessage() );
		}
		uvmsConnection.setPassword( request.getParameter(ATTR_INPUTPWD));
		try {
			uvmsConnection.setUvmsHost(request.getParameter(ATTR_INPUTUVMS));
		} catch ( Exception e ) {
			errors.put( ATTR_INPUTUVMS, e.getMessage() );
		}
		try {
			uvmsConnection.setUvmsPort( request.getParameter(ATTR_INPUTPORT));
		} catch ( Exception e ) {
			errors.put( ATTR_INPUTPORT, e.getMessage() );
		}

		/* Initialisation du résultat global de la validation. */
		if ( errors.isEmpty() ) {
			result = "Entered data are valid";
			uvmsConnection.setToken(duwsClient.login(uvmsConnection));
			if(uvmsConnection.isDisconnected()) {
				result=result+" but "+duwsClient.getLastResponse()+ "("+duwsClient.getLastResult()+")";
				nextPage = PAGE_LOGIN;
				returnCode = duwsClient.getLastResult();
			} else {
				if(request.getParameter(ATTR_REMEMBER_CONN) != null) {
					//store fields in cookies
					setCookie( response, CK_LASTLOGIN, uvmsConnection.getLogin(), COOKIE_DURATION );
					setCookie( response, CK_LASTUVMS, uvmsConnection.getUvmsHost(), COOKIE_DURATION );
					setCookie( response, CK_LASTPORT, uvmsConnection.getUvmsPort(), COOKIE_DURATION );
				}
			}
		} else {
			result = "Bad input data. Please fix and retry";
			nextPage = PAGE_LOGIN;
			returnCode = 1;
		}

		JobRuns jobRuns = new JobRuns(request);

		if(!uvmsConnection.isDisconnected()) {
			boolean ret;

			ret = jobRuns.getDUEnvironmentList(request, uvmsConnection);
			if(!ret) {
				request.setAttribute(ATTR_LASTRESULT, "Failed to get list of nodes");
			} else {
				nextPage = PAGE_DASHBOARD;
			}
		}

		/* Stockage du résultat et des messages d'erreur dans l'objet request */
		request.setAttribute( ATTR_INPUTERRORS, errors );
		if(!result.isEmpty()) {
			request.setAttribute(ATTR_LASTRESULT, result);
			request.setAttribute(ATTR_RETURNCODE, returnCode);
		} else {
			request.setAttribute(ATTR_LASTRESULT, duwsClient.getLastResponse());
			request.setAttribute(ATTR_RETURNCODE, duwsClient.getLastResult());
		}

		session.setAttribute(ATTR_UVMSCONN, uvmsConnection);
		//request.setAttribute(ATTR_UVMSCONN, uvmsConnection);

		logger.info(this.getServletName()+"/doPost: received from Jsp="+ uvmsConnection.toString()+" => "+result);

		if(nextPage.equals(PAGE_LOGIN)) {
			this.getServletContext().getRequestDispatcher(nextPage).forward(request, response);
		} else {
			settings.setFromCookies(request);
			settings.setInSession(request);
			response.sendRedirect(request.getContextPath()+nextPage);
		}
	}

}
