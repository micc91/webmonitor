package com.example.webmonitor;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.*;

import com.duws.Client;
import com.example.duas.UvmsConnection;
import com.example.duws.proxy.Envir;
import org.apache.log4j.Logger;

public class Dashboard extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Info.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Dashboard() {
        super();
        // TODO Auto-generated constructor stub

    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        UvmsConnection uvmsConnection = (UvmsConnection) session.getAttribute("uvmsConnection");
        Client duwsClient = new Client();
        List<Envir> duasList = null;
        List<String> companyList = new ArrayList<String>();
        List<String> nodeList = new ArrayList<String>();
        List<String> areaList = new ArrayList<String>();
        List<String> versionList = new ArrayList<String>();
        List<String> statusList = new ArrayList<String>();

        if(uvmsConnection == null) {
            logger.info(this.getServletName()+"/doGet: No user stored yet in session");
            uvmsConnection = new UvmsConnection();
        } else {
            try {
                duasList = duwsClient.getDUEnvironmentList(uvmsConnection);
            } catch (Exception e) {
                logger.error(this.getServletName()+"/doGet: "+duwsClient.getLastResponse()+ "("+duwsClient.getLastResult()+")");
                logger.error("Exception: ",e);
                e.printStackTrace();
            }
            Integer idx=0;
            for(Envir item : duasList) {
                companyList.add(item.getCompany());
                nodeList.add(item.getNode());
                areaList.add(item.getArea().getValue());
                versionList.add(item.getVersion().getValue());
                statusList.add(item.getStatus().getValue().toString());
                idx++;
                logger.info(this.getServletName()+"/doGet: [Adding "+idx.toString()+"] "+item.getNode()+":"+item.getCompany()+":"+item.getArea().getValue()+":"+item.getVersion().getValue()+":"+item.getStatus().getValue().toString()+".");
            }
            request.setAttribute("duasList", duasList);
            request.setAttribute("companyList", companyList);
            request.setAttribute("nodeList", nodeList);
            request.setAttribute("areaList", areaList);
            request.setAttribute("versionList", versionList);
            request.setAttribute("statusList", statusList);
        }
        logger.info(this.getServletName()+"/doGet: got from session="+ uvmsConnection.toString());
        request.setAttribute("uvmsConnection", uvmsConnection);

        this.getServletContext().getRequestDispatcher("/WEB-INF/views/dashboard.jsp").forward(request, response);
    }
}
