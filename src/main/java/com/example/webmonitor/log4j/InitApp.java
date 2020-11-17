package com.example.webmonitor.log4j;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.PropertyConfigurator;
import java.io.*;

public class InitApp extends HttpServlet {
    public void init() {

        String cheminWebApp = getServletContext().getRealPath("/");
        String cheminLogConfig = cheminWebApp + getInitParameter("log4j-config");
        String cheminLog = cheminWebApp + getInitParameter("log4j-log-path");

        File logPathDir = new File( cheminLog );
        System.setProperty( "log.chemin", cheminLog );

        PropertyConfigurator.configure(cheminLogConfig);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
