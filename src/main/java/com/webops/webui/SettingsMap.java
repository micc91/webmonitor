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

    protected String name;

    protected SettingsMap() {
        fields.add("refresh");
        fields.add("sort");
        fields.add("order");
        fields.add("offset");
        fields.add("filter");

        name="SettingsMap";
    }

    public void init() {
        for(String field : fields) {
            items.put(field, "");
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<String, String> getItems() {
        return items;
    }

    public void setInRequest(HttpServletRequest request) {
        request.setAttribute(name, items);
    }

    public void setInSession(HttpSession session) {
        session.setAttribute(name, items);
    }

}
