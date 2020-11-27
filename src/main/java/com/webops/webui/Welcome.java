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
        UvmsConnection uvmsConnection = (UvmsConnection) session.getAttribute("uvmsConnection");
        Client client = new Client();
        Map<String, String> duwsInfo = new HashMap<>();
        duwsInfo.put("status", "unchecked");
        duwsInfo.put("version", "unknown");

        if(session.getAttribute("duwsStatus") != null) {
            duwsInfo.put("status", (String) session.getAttribute("duwsStatus"));
        }
        if(session.getAttribute("duwsVersion") != null) {
            duwsInfo.put("version", (String) session.getAttribute("duwsVersion"));
        }

        if(uvmsConnection == null) {
            logger.info(this.getServletName()+"/doGet: No user stored yet in session");
            uvmsConnection = new UvmsConnection();
        }

        String check = request.getParameter("check");
        if(check != null) {
            if(check.equals("true")) {
                duwsInfo = client.getDuwsVersion();
            }
        }

        logger.info(this.getServletName()+"/doGet: got from session="+ uvmsConnection.toString());
        request.setAttribute("uvmsConnection", uvmsConnection);
        session.setAttribute("duwsStatus", duwsInfo.get("status"));
        session.setAttribute("duwsVersion", duwsInfo.get("version"));

        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());

        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
