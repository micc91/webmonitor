package com.webops.webui;

import com.duws.Client;
import com.webops.duas.PreferencesBean;
import com.webops.duas.UvmsConnection;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(urlPatterns = "/preferences")
public class Preferences extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Login.class);

    private static final String ATTR_UVMSCONN = "uvmsConnection";
    private static final String PAGE_PREFS = "/WEB-INF/views/preferences.jsp";
    private static final String PAGE_LOGIN = "/WEB-INF/views/login.jsp";
    private static final String ATTR_LASTRESULT = "lastResult";
    private static final String ATTR_RETURNCODE = "returnCode";
    private static final String ATTR_INPUTOFFSET = "inputOffset";
    private static final String ATTR_INPUTTIMER = "inputTimer";
    private static final String ATTR_INPUTCHART = "inputChart";
    private static final String ATTR_INPUTLWSIZE = "inputLwSize";
    private static final String ATTR_INPUTACCOUNT = "inputAccount";
    private static final String ATTR_INPUTQUEUE = "inputQueue";
    private static final String ATTR_INPUTERRORS = "errors";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UvmsConnection uvmsConnection = (UvmsConnection) session.getAttribute(ATTR_UVMSCONN);
        Map<String, String> errors = new HashMap<>();
        PreferencesBean prefs = new PreferencesBean();
        String result;
        int returnCode = 0;

        prefs.updateFromCookies(request);
        prefs.updateFromSession(request);

        if(uvmsConnection == null || uvmsConnection.isDisconnected()) {
            logger.info(this.getServletName()+"/doGet: No user stored in session");
            session.setAttribute(ATTR_UVMSCONN, uvmsConnection);
            request.setAttribute(ATTR_UVMSCONN, uvmsConnection);
            this.getServletContext().getRequestDispatcher(PAGE_LOGIN).forward(request, response);
        }

        try {
            prefs.setOffset( request.getParameter(ATTR_INPUTOFFSET));
            if(prefs.getReturnCode() != 0) {
                errors.put(ATTR_INPUTOFFSET, prefs.getLastResult());
            }
        } catch ( Exception e ) {
            errors.put( ATTR_INPUTOFFSET, e.getMessage() );
        }
        try {
            prefs.setTimer( request.getParameter(ATTR_INPUTTIMER));
            if(prefs.getReturnCode() != 0) {
                errors.put(ATTR_INPUTTIMER, prefs.getLastResult());
            }
        } catch ( Exception e ) {
            errors.put( ATTR_INPUTTIMER, e.getMessage() );
        }
        try {
            prefs.setChart( request.getParameter(ATTR_INPUTCHART));
            if(prefs.getReturnCode() != 0) {
                errors.put(ATTR_INPUTCHART, prefs.getLastResult());
            }
        } catch ( Exception e ) {
            errors.put( ATTR_INPUTCHART, e.getMessage() );
        }
        try {
            prefs.setLaunchWindowSize( request.getParameter(ATTR_INPUTLWSIZE));
            if(prefs.getReturnCode() != 0) {
                errors.put(ATTR_INPUTLWSIZE, prefs.getLastResult());
            }
        } catch ( Exception e ) {
            errors.put( ATTR_INPUTLWSIZE, e.getMessage() );
        }
        try {
            prefs.setSubmissionAccount( request.getParameter(ATTR_INPUTACCOUNT));
            if(prefs.getReturnCode() != 0) {
                errors.put(ATTR_INPUTACCOUNT, prefs.getLastResult());
            }
        } catch ( Exception e ) {
            errors.put( ATTR_INPUTACCOUNT, e.getMessage() );
        }
        try {
            prefs.setBatchQueue( request.getParameter(ATTR_INPUTQUEUE));
            if(prefs.getReturnCode() != 0) {
                errors.put(ATTR_INPUTQUEUE, prefs.getLastResult());
            }
        } catch ( Exception e ) {
            errors.put( ATTR_INPUTQUEUE, e.getMessage() );
        }

        if ( errors.isEmpty() ) {
            returnCode = 0;
            result = "Entered data are valid";
            prefs.updateCookies(request, response);
            session.setAttribute("preferences", prefs);
            session.setAttribute("settings", prefs.getSettings().getItems());
        } else {
            result = "Bad input data. Please fix and retry";
            returnCode = 1;
        }

        request.setAttribute(ATTR_INPUTERRORS, errors);
        request.setAttribute(ATTR_RETURNCODE, returnCode);
        request.setAttribute(ATTR_LASTRESULT, result);
        this.getServletContext().getRequestDispatcher(PAGE_PREFS).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        PreferencesBean prefs = new PreferencesBean();
        Map<String, String> errors = new HashMap<>();

        prefs.updateFromCookies(request);
        prefs.updateFromSession(request);
        session.setAttribute("preferences", prefs);

        request.setAttribute(ATTR_INPUTERRORS, errors);
        request.setAttribute(ATTR_RETURNCODE, 0);
        request.setAttribute(ATTR_LASTRESULT, "");
        this.getServletContext().getRequestDispatcher(PAGE_PREFS).forward(request, response);
    }
}
