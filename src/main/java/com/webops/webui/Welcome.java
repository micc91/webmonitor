package com.webops.webui;

import com.duws.Client;
import com.webops.duas.UvmsConnection;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Welcome extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Welcome.class);

    private static final String ATTR_UVMSCONN = "uvmsConnection";
//    private static final String ATTR_LASTRESULT = "lastResult";
    private static final String ATTR_DUWS_STATUS = "duwsStatus";
    private static final String ATTR_DUWS_VERSION = "duwsVersion";
    private static final String PAGE_WELCOME = "/index.jsp";
    private static final String ATTR_ACTION_CHECK = "check";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Welcome() {
        super();
        // TODO Auto-generated constructor stub

    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UvmsConnection uvmsConnection = (UvmsConnection) session.getAttribute(ATTR_UVMSCONN);
        Client client = new Client();
        Map<String, String> duwsInfo = new HashMap<>();
        duwsInfo.put("status", "unchecked");
        duwsInfo.put("version", "unknown");

        if(session.getAttribute(ATTR_DUWS_STATUS) != null) {
            duwsInfo.put("status", (String) session.getAttribute(ATTR_DUWS_STATUS));
        }
        if(session.getAttribute(ATTR_DUWS_VERSION) != null) {
            duwsInfo.put("version", (String) session.getAttribute(ATTR_DUWS_VERSION));
        }

        if(uvmsConnection == null) {
            logger.info(this.getServletName()+"/doGet: No user stored yet in session");
            uvmsConnection = new UvmsConnection();
        }

        String check = request.getParameter(ATTR_ACTION_CHECK);
        if(check != null) {
            if(check.equals("true")) {
                duwsInfo = client.getDuwsVersion();
            }
        }

        logger.info(this.getServletName()+"/doGet: got from session="+ uvmsConnection.toString());
        request.setAttribute(ATTR_UVMSCONN, uvmsConnection);
        session.setAttribute(ATTR_DUWS_STATUS, duwsInfo.get("status"));
        session.setAttribute(ATTR_DUWS_VERSION, duwsInfo.get("version"));

        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());

        this.getServletContext().getRequestDispatcher(PAGE_WELCOME).forward(request, response);
    }
}
