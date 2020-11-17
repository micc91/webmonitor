package com.example.webmonitor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import com.example.duas.UvmsConnection;
import org.apache.log4j.Logger;

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
        if(uvmsConnection == null) {
            logger.info(this.getServletName()+"/doGet: No user stored yet in session");
            uvmsConnection = new UvmsConnection();
        }
        logger.info(this.getServletName()+"/doGet: got from session="+ uvmsConnection.toString());
        request.setAttribute("uvmsConnection", uvmsConnection);

        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());

        this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
    }
}
