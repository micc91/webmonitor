package com.webops.webui;

import org.apache.log4j.Logger;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieHelper {
    private static final Logger logger = Logger.getLogger(SettingsMap.class);

    public static void setCookie(HttpServletRequest request, HttpServletResponse response, String name, String value, int expiry) {
        Cookie cookie = null;

        Cookie[] userCookies = request.getCookies();
        if (userCookies != null && userCookies.length > 0 ) {
            for (int i = 0; i < userCookies.length; i++) {
                if (userCookies[i].getName().equals(name)) {
                    cookie = userCookies[i];
                    break;
                }
            }
        }

        if (cookie != null) {
            logger.info("Updating cookie "+name+"="+value);
            cookie.setValue(value);
        } else {
            logger.info("Creating new cookie "+name+"="+value);
            cookie = new Cookie(name, value);
            cookie.setPath(request.getContextPath());
        }

        cookie.setMaxAge(expiry);

        response.addCookie(cookie);
    }

    public static Cookie getCookie(HttpServletRequest request, String name) {
        Cookie cookie = null;

        Cookie[] userCookies = request.getCookies();
        if (userCookies != null && userCookies.length > 0 ) {
            for (int i = 0; i < userCookies.length; i++) {
                if (userCookies[i].getName().equals(name)) {
                    cookie = userCookies[i];
                    return cookie;
                }
            }
        }

        return null;
    }

    public static String getCookieValue( HttpServletRequest request, String name ) {
        Cookie cookie = getCookie(request, name);
        if(cookie != null) {
            return cookie.getValue();
        }
        return null;
    }
}
