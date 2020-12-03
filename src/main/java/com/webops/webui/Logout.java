package com.webops.webui;

import com.duws.Client;
import com.webops.duas.UvmsConnection;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/logout")
public class Logout extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Logout.class);
    private static final String PAGE_LOGOUT = "/WEB-INF/views/logout.jsp";
    private static final String ATTR_UVMSCONN = "uvmsConnection";
    private static final String ATTR_LASTRESULT = "lastResult";
//    private static final String ATTR_RETURNCODE = "returnCode";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Logout() {
        super();
        // TODO Auto-generated constructor stub

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        UvmsConnection uvmsConnection = (UvmsConnection) session.getAttribute(ATTR_UVMSCONN);
        if(uvmsConnection == null) {
            logger.info(this.getServletName()+"/doGet: No user stored yet in session");
            uvmsConnection = new UvmsConnection();
        }
        logger.info(this.getServletName()+"/doGet: got from session="+ uvmsConnection.toString());
        request.setAttribute(ATTR_UVMSCONN, uvmsConnection);

        this.getServletContext().getRequestDispatcher(PAGE_LOGOUT).forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String result;
        HttpSession session = request.getSession();
        Client duwsClient = new Client();
        String nextPage;
        boolean ret = true;

        UvmsConnection uvmsConnection = (UvmsConnection) session.getAttribute(ATTR_UVMSCONN);
        if(uvmsConnection == null) {
            logger.info(this.getServletName()+"/doPost: No user already stored in session");
            uvmsConnection = new UvmsConnection();
        }

        nextPage = PAGE_LOGOUT;

        /* Initialisation du résultat global de la validation. */
        if ( uvmsConnection.isDisconnected() ) {
            result = "You are already logged out!";
        } else {
            result = "";
            try {
                ret = duwsClient.logout(uvmsConnection);
            } catch (Exception e) {
                logger.error("Exception: ",e);
                result="Logout failed";
            }
            if(ret) {
                uvmsConnection.setDisconnected();
                session.setAttribute(ATTR_UVMSCONN, uvmsConnection);
                session.invalidate();
            }
        }

        /* Stockage du résultat dans l'objet request */
        request.setAttribute( ATTR_LASTRESULT, result );
        request.setAttribute(ATTR_UVMSCONN, uvmsConnection);

        logger.info(this.getServletName()+"/doPost: received from Jsp="+ uvmsConnection.toString()+" => "+result);
        this.getServletContext().getRequestDispatcher(nextPage).forward(request, response);
    }
}
