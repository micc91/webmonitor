package com.duws;

import com.example.duas.UvmsConnection;
import com.example.webmonitor.Login;
import com.example.duws.proxy.*;
import org.apache.log4j.Logger;

import java.net.URL;
import java.util.List;

public class Client {
    private static final Logger logger = Logger.getLogger(Login.class);
    private String errorMessage;
    private int errorCode;

    public String getLastResponse() {
        return errorMessage;
    }

    public int getLastResult() {
        return errorCode;
    }

    public String login(UvmsConnection connection) throws Exception {
        URL duwsUrl = new URL("http://localhost:8080/du_web_services_6.10.51_all_os/DuwsSEI?wsdl");
        DuWebService_Service ss = new DuWebService_Service();//duwsUrl);
        DuWebService service = ss.getDuWebServicePort();
        UvmsContext uvmsContext = new UvmsContext();
        String token = "disconnected";
        errorMessage = "Successful";
        errorCode = 0;

        uvmsContext.setUvmsHost(connection.getUvmsHost());
        uvmsContext.setUvmsPort(Integer.parseInt(connection.getUvmsPort()));
        uvmsContext.setUvmsUser(connection.getLogin());
        uvmsContext.setUvmsPassword(connection.getPassword());

        logger.info("Trying to log in "+uvmsContext.getUvmsUser()+" to "+uvmsContext.getUvmsHost()+":"+uvmsContext.getUvmsPort());

// Invoking authentication...
        try {
            token = service.login(uvmsContext);
        } catch (DuwsException_Exception duwse) {
            errorCode = duwse.getFaultInfo().getErrorCode();
            errorMessage = duwse.getFaultInfo().getMessage();
            logger.error("Login failed: "+errorMessage+" ("+errorCode+")");
//            logger.error("Exception: ",duwse);
        }

        return(token);
    }

    public List<Envir> getDUEnvironmentList(UvmsConnection connection) throws Exception {
        URL duwsUrl = new URL("http://localhost:8080/du_web_services_6.10.51_all_os/DuwsSEI?wsdl");
        DuWebService_Service ss = new DuWebService_Service();//duwsUrl);
        DuWebService service = ss.getDuWebServicePort();

        String token = connection.getToken();
        errorMessage = "Successful";
        errorCode = 0;

        // Setting up the context
        ContextHolder ctxHolder = new ContextHolder();
        ctxHolder.setToken(connection.getToken());
        List<Envir> duEnvironmentList = service.getDUEnvironmentList(token,new UvmsNodeFilter());
        return duEnvironmentList;
    }

    public boolean getListExecution() throws Exception {
        return false;
    }

    public boolean logout(UvmsConnection connection) throws Exception {
        URL duwsUrl = new URL("http://localhost:8080/du_web_services_6.10.51_all_os/DuwsSEI?wsdl");
        DuWebService_Service ss = new DuWebService_Service();//duwsUrl);
        DuWebService service = ss.getDuWebServicePort();
        errorMessage = "Successful";
        errorCode = 0;
        boolean ret = true;

        try {
            service.logout(connection.getToken());
        } catch (DuwsException_Exception duwse) {
            errorCode = duwse.getFaultInfo().getErrorCode();
            errorMessage = duwse.getFaultInfo().getMessage();
            logger.error("Login failed: "+errorMessage+" ("+errorCode+")");
//            logger.error("Exception: ",duwse);
            ret = false;
        }

        return ret;
    }
}
