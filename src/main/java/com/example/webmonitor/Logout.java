package com.example.webmonitor;

import com.duws.Client;
import com.example.duas.UvmsConnection;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Logout extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Logout.class);

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
        UvmsConnection uvmsConnection = (UvmsConnection) session.getAttribute("uvmsConnection");
        if(uvmsConnection == null) {
            logger.info(this.getServletName()+"/doGet: No user stored yet in session");
            uvmsConnection = new UvmsConnection();
        }
        logger.info(this.getServletName()+"/doGet: got from session="+ uvmsConnection.toString());
        request.setAttribute("uvmsConnection", uvmsConnection);

        this.getServletContext().getRequestDispatcher("/WEB-INF/views/logout.jsp").forward(request, response);

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        String result;
        HttpSession session = request.getSession();
        Client duwsClient = new Client();
        String nextPage = "login.jsp";
        boolean ret = true;

        UvmsConnection uvmsConnection = (UvmsConnection) session.getAttribute("uvmsConnection");
        if(uvmsConnection == null) {
            logger.info(this.getServletName()+"/doPost: No user already stored in session");
            uvmsConnection = new UvmsConnection();
        }

        nextPage = "logout.jsp";

        /* Initialisation du résultat global de la validation. */
        if ( uvmsConnection.getToken().equals("disconnected") ) {
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
                uvmsConnection.setToken("disconnected");
            }
        }

        /* Stockage du résultat dans l'objet request */
        request.setAttribute( "result", result );

        session.setAttribute("uvmsConnection", uvmsConnection);
        request.setAttribute("uvmsConnection", uvmsConnection);

        logger.info(this.getServletName()+"/doPost: received from Jsp="+ uvmsConnection.toString()+" => "+result);
        this.getServletContext().getRequestDispatcher("/WEB-INF/views/"+nextPage).forward(request, response);
    }
}
