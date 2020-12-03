package com.webops.webui;

import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

public class SettingsMap {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(SettingsMap.class);

    protected Map<String, String> items = new HashMap<>();
    protected List<String> fields = new ArrayList<>();
    protected Map<String, List<String>> selectValues;
    protected List<String> selectedContext = new ArrayList<>();

    protected String name;

    public SettingsMap() {
        fields.add("offset"); // offset time to start date when requesting job runs (H - 5 min, ...)
        fields.add("timer"); // timer interval if automatic refresh of job runs

        fields.add("chart"); // display chart bar or pie or none (no display)
        fields.add("submissionAccount");
        fields.add("batchQueue");
        fields.add("launchWindowSize");

        selectValues = new HashMap<>();
        List<String> offsetValues = new ArrayList<>();
        List<String> timerValues = new ArrayList<>();
        List<String> chartValues = new ArrayList<>();
        offsetValues.add("none#Any_time");
        offsetValues.add("5#-5_minutes");
        offsetValues.add("60#-1_hour");
        offsetValues.add("360#-6_hours");
        offsetValues.add("720#-12_hours");
        offsetValues.add("1440#-1_day");
        offsetValues.add("2880#-2_days");
        selectValues.put("offset", offsetValues);
        timerValues.add("none#Manual");
        timerValues.add("30#30_seconds");
        timerValues.add("60#1_minute");
        timerValues.add("300#5_minutes");
        selectValues.put("timer", timerValues);
        chartValues.add("none");
        chartValues.add("bar");
        chartValues.add("pie");
        selectValues.put("chart", chartValues);

        name="settings";
    }

    public void init() {
        for(String field : fields) {
            items.put(field, "");
        }
        selectedContext.clear();
    }

    public void setFromCookies(HttpServletRequest request) {
        if(CookieHelper.getCookie(request,"offset") != null) {
            items.put("offset", CookieHelper.getCookie(request, "offset").getValue());
        }
        if(CookieHelper.getCookie(request,"chart") != null) {
            items.put("chart", CookieHelper.getCookie(request, "chart").getValue());
        }
        if(CookieHelper.getCookie(request,"timer") != null) {
            items.put("timer", CookieHelper.getCookie(request, "timer").getValue());
        }
        if(CookieHelper.getCookie(request,"batchQueue") != null) {
            items.put("batchQueue", CookieHelper.getCookie(request, "batchQueue").getValue());
        }
        if(CookieHelper.getCookie(request,"submissionAccount") != null) {
            items.put("submissionAccount", CookieHelper.getCookie(request, "submissionAccount").getValue());
        }
        if(CookieHelper.getCookie(request,"launchWindowSize") != null) {
            items.put("launchWindowSize", CookieHelper.getCookie(request, "launchWindowSize").getValue());
        }
    }

    public void setFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Map<String, String> settings = (Map<String, String>)session.getAttribute(name);
        String param;
        if(settings != null) {
            for (String field : fields) {
                param = (String) settings.get(field);
                logger.debug(this.getClass().getName() + "/setFromSession: reading " + name + "." + field + ", found " + param);
                if (param != null) {
                    if (!param.isEmpty()) {
                        logger.debug(this.getClass().getName() + "/setFromSession: " + name + "." + field + "=" + param);
                        items.put(field, param);
                    }
                }
            }
        }
        List<String> paramList = (List<String>) session.getAttribute("selectedContext");
        if(paramList != null) {
            if (!paramList.isEmpty()) {
                selectedContext.clear();
                selectedContext = paramList;
            }
        }
    }

    public void setFromRequest(HttpServletRequest request) {
        Map<String, String> settings = (Map<String, String>)request.getAttribute(name);
        String param;
        if(settings != null) {
            for (String field : fields) {
                param = settings.get(field);
                if (param != null) {
                    if (!param.isEmpty()) {
                        // if a value is not already present in map:
                        if (items.get(field) == null || items.get(field).isEmpty()) {
                            logger.debug(this.getClass().getName() + "setFromRequest: " + name + "." + field + "=" + param);
                            items.put(field, param);
                        }
                    }
                }
            }
        }
        List<String> paramList = (List<String>) request.getAttribute("selectedContext");
        if(paramList != null) {
            if (!paramList.isEmpty()) {
                selectedContext.clear();
                selectedContext = paramList;
            }
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addNode(String num) {
        if(! selectedContext.contains(num)) {
            selectedContext.add(num);
        }
    }

    public List<String> getSelectedContext() {
        return selectedContext;
    }

    public void resetSelectedContext() {
        selectedContext.clear();
    }

    public void setSelectedContext(String[] selectedNodes) {
        for(String idx : selectedNodes) {
            logger.debug(this.getClass().getName()+"/setSelectedContext(String[]): adding node# "+ idx);
            addNode(idx);
        }
    }

    public void setSelectedContext(List<String> selectedNodes) {
        if(selectedNodes != null) {
            for (String idx : selectedNodes) {
                addNode(idx);
            }
        }
    }

    public String getItem(String field) {
        if(fields.contains(field)) {
            String output = items.get(field);
            if(output != null) {
                return output;
            } else {
                return "";
            }
        } else {
            return "";
        }
    }

    public void setItem(String field, String value) {
        if(fields.contains(field)) {
            if(value != null) {
                items.put(field, value);
            } else {
                items.put(field, "");
            }
        }
    }

    // drop-down list in dashboard JSP sends back the integer value not the real complete value whose syntax is: value#label
    public void setItemFromSelectValue(String field, String selectValue) {
        if(fields.contains(field)) {
            if(selectValue != null) {
                for(String value : getSelectValues().get(field)) {
                    if(value.startsWith(selectValue)) {
                        items.put(field, value);
                    }
                }
            } else {
                items.put(field, "");
            }
        }
    }

    public Map<String, String> getItems() {
        return items;
    }

    public Set<String> getKeys() {
        return items.keySet();
    }

    public void setInRequest(HttpServletRequest request) {
        request.setAttribute(name, items);
        request.setAttribute("selectedContext", selectedContext);
    }

    public void setInSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        for(String field : fields) {
            logger.debug(this.getClass().getName()+"/setInSession: "+name+"."+field+"="+items.get(field));
        }
        session.setAttribute(name, items);
        session.setAttribute("selectedContext", selectedContext);
    }

    public Map<String, List<String>> getSelectValues() {
        return selectValues;
    }
}
