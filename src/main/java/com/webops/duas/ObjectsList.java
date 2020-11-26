package com.webops.duas;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class ObjectsList {
    protected List<Map<String, String>> items = new ArrayList<>();
    protected List<String> fields = new ArrayList<>();

    protected String name;
    protected int size;

    protected ObjectsList() {

    }

    public void init() {
        Map<String, String> empty = new HashMap<>();
        for(String field : fields) {
            empty.put(field, "");
        }

        if(items.isEmpty()) {
            items.add(empty);
        }
        size = 0;
    }

    public void reset() {
        if( ! items.isEmpty()) {
            items.clear();
        }
    }

    public int getSize() {
        return size;
    }
    protected void setSize(int size) {
        this.size = size;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Map<String, String>> getItems() {
        return items;
    }

    public void setInRequest(HttpServletRequest request) {
        request.setAttribute(name, items);
    }
    public void setFromRequest(HttpServletRequest request) {
        if(request.getAttribute(name) != null) {
            items = (List<Map<String, String>>) request.getAttribute(name);
        }
    }

    public void setFromSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if(session.getAttribute(name) != null) {
            items = (List<Map<String, String>>) session.getAttribute(name);
        }
    }

    public void setInSession(HttpSession session) {
        session.setAttribute(name, items);
    }

}
