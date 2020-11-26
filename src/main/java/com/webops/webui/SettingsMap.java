package com.webops.webui;

import com.webops.duas.NodesList;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SettingsMap {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(SettingsMap.class);

    protected Map<String, String> items = new HashMap<>();
    protected List<String> fields = new ArrayList<>();
    protected List<String> selectedContext = new ArrayList<>();

    protected String name;

    protected SettingsMap() {
        fields.add("refresh");
        fields.add("sort");
        fields.add("order");
        fields.add("offset");
        fields.add("filter");
        fields.add("timer");

        name="settings";
    }

    public void init() {
        for(String field : fields) {
            items.put(field, "");
        }
        selectedContext.clear();
    }

    public void setFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String param;
        for(String field : fields) {
            param = (String) session.getAttribute(field);
            if(param != null) {
                if (!param.isEmpty()) {
                    items.put(field, param);
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
        String param;
        for(String field : fields) {
            param = request.getParameter(field);
            if(param != null) {
                if (!param.isEmpty()) {
                    items.put(field, param);
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

    public void setSelectedContext(String[] selectedNodes) {
        for(String idx : selectedNodes) {
            addNode(idx);
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

    public Map<String, String> getItems() {
        return items;
    }

    public void setInRequest(HttpServletRequest request) {
        request.setAttribute(name, items);
        request.setAttribute("selectedContext", selectedContext);
    }

    public void setInSession(HttpSession session) {
        session.setAttribute(name, items);
        session.setAttribute("selectedContext", selectedContext);
    }

}
