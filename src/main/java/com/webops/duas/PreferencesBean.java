package com.webops.duas;

import com.webops.webui.CookieHelper;
import com.webops.webui.SettingsMap;
import org.apache.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PreferencesBean implements Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(SettingsMap.class);
    private static final int CK_DURATION = 365 * 86400;
    private SettingsMap settings;
    private int returnCode;
    private String lastResult;

    public PreferencesBean() {
        settings = new SettingsMap();
        returnCode = 0;
        lastResult = "";

        settings.setItem("timer", "none#Manual");
        settings.setItem("offset", "none#Any_time");
        settings.setItem("chart", "none");
        settings.setItem("launchWindowSize", "10");
        settings.setItem("submissionAccount", "administrator");
        settings.setItem("batchQueue", "SYS_BATCH");


    }

    public SettingsMap getSettings() {
        return settings;
    }

    public String getTimer() {
        return settings.getItem("timer");
    }

    public Map<String, List<String>> getSelectValues() {
        return settings.getSelectValues();
    }

    public void setTimer(String value) {
        returnCode = 0;
        lastResult = "Successful";
        if(value == null) {
            settings.setItem("timer", "none#Manual");
        }
        else {
            if(getSelectValues().get("timer").contains(value)) {
                settings.setItem("timer", value);
            } else {
                returnCode = 1;
                lastResult = "Bad value for timer: "+value;
            }
        }
    }

    public String getOffset() {
        return settings.getItem("offset");
    }

    public void setOffset(String value) {
        returnCode = 0;
        lastResult = "Successful";
        if(value == null) {
            settings.setItem("offset", "none#Any_time");
        } else {
            if(getSelectValues().get("offset").contains(value)) {
                settings.setItem("offset", value);
            } else {
                returnCode = 1;
                lastResult = "Bad value for offset: "+value;
            }
        }
    }

    public String getChart() {
        return settings.getItem("chart");
    }

    public void setChart(String value) {
        returnCode = 0;
        lastResult = "Successful";
        if(value == null) {
            settings.setItem("chart", "none");
        } else {
            if(getSelectValues().get("chart").contains(value)) {
                settings.setItem("chart", value);
            } else {
                returnCode = 1;
                lastResult = "Bad value for chart: "+value;
            }
        }
    }

    public String getLaunchWindowSize() {
        return settings.getItem("launchWindowSize");
    }

    public void setLaunchWindowSize(String value) {
        returnCode = 0;
        lastResult = "Successful";
        if(value == null) {
            settings.setItem("launchWindowSize", "10");
        } else {
            try {
                int number = Integer.parseInt(value);
                if(number > 0 && number <= 1440) {
                    settings.setItem("launchWindowSize", value);
                } else {
                    returnCode = 3;
                    lastResult = "launch window size out of range (0-1440 minutes)";
                }
            } catch (NumberFormatException e) {
                logger.error("Launch Window Size: bad value "+value);
                returnCode = 2;
                lastResult = "Bad value for launch window size";
            }
        }
    }

    public String getSubmissionAccount() {
        return settings.getItem("submissionAccount");
    }

    public void setSubmissionAccount(String submissionAccount) {
        returnCode = 0;
        lastResult = "Successful";
        if(submissionAccount == null) {
            settings.setItem("submissionAccount", "administrator");
        } else {
            settings.setItem("submissionAccount", submissionAccount);
        }
    }

    public String getBatchQueue() {
        return settings.getItem("batchQueue");
    }

    public void setBatchQueue(String batchQueue) {
        returnCode = 0;
        lastResult = "Successful";
        if(batchQueue == null) {
            settings.setItem("batchQueue", "SYS_BATCH");
        } else {
            settings.setItem("batchQueue", batchQueue);
        }
    }

    public int getReturnCode() {
        return returnCode;
    }

    public String getLastResult() {
        return lastResult;
    }


    public void updateFromSession(HttpServletRequest request) {
        returnCode = 0;
        lastResult = "Successful";
        settings.setFromSession(request);
    }

    public void updateFromCookies(HttpServletRequest request) {
        returnCode = 0;
        lastResult = "Successful";
        if(CookieHelper.getCookie(request,"offset") != null) {
            setOffset(CookieHelper.getCookie(request, "offset").getValue());
        } else {
            returnCode = 4;
            lastResult = "Cookie offset not found";
        }
        if(CookieHelper.getCookie(request,"chart") != null) {
            setChart(CookieHelper.getCookie(request, "chart").getValue());
        } else {
            returnCode = 4;
            lastResult = "Cookie offset not found";
        }
        if(CookieHelper.getCookie(request,"timer") != null) {
            setTimer(CookieHelper.getCookie(request, "timer").getValue());
        } else {
            returnCode = 4;
            lastResult = "Cookie timer not found";
        }
        if(CookieHelper.getCookie(request,"batchQueue") != null) {
            setBatchQueue(CookieHelper.getCookie(request, "batchQueue").getValue());
        } else {
            returnCode = 4;
            lastResult = "Cookie batchQueue not found";
        }
        if(CookieHelper.getCookie(request,"submissionAccount") != null) {
            setSubmissionAccount(CookieHelper.getCookie(request, "submissionAccount").getValue());
        } else {
            returnCode = 4;
            lastResult = "Cookie submissionAccount not found";
        }
        if(CookieHelper.getCookie(request,"launchWindowSize") != null) {
            setLaunchWindowSize(CookieHelper.getCookie(request, "launchWindowSize").getValue());
        } else {
            returnCode = 4;
            lastResult = "Cookie launchWindowSize not found";
        }
    }

    public void updateCookies(HttpServletRequest request, HttpServletResponse response) {
        returnCode = 0;
        lastResult = "Successful";
        CookieHelper.setCookie(request, response,"offset", getOffset(), CK_DURATION);
        CookieHelper.setCookie(request, response,"timer", getTimer(), CK_DURATION);
        CookieHelper.setCookie(request, response,"chart", getChart(), CK_DURATION);
        CookieHelper.setCookie(request, response,"batchQueue", getBatchQueue(), CK_DURATION);
        CookieHelper.setCookie(request, response,"submissionAccount", getSubmissionAccount(), CK_DURATION);
        CookieHelper.setCookie(request, response,"launchWindowSize", getLaunchWindowSize(), CK_DURATION);
    }
}
