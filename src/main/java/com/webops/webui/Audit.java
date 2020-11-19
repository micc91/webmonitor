package com.webops.webui;

import com.webops.duas.ObjectsList;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class Audit extends ObjectsList {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(Audit.class);

    private int maxSize = 20;
    private int cursor = 0;

    public Audit() {
        super();

        fields.add("result");
        fields.add("message");
        fields.add("action");
        fields.add("object");
        fields.add("parameters");
        name = "audit";
    }

    public int getMaxSize() {
        return maxSize;
    }

    public void addItem(String result, String message, String action, String object, String parameters) {
        Map<String, String> entry = new HashMap<>();

        entry.put("result", result);
        entry.put("message", message);
        entry.put("action", action);
        entry.put("object", object);
        entry.put("parameters", parameters);

        if(items.size() < getMaxSize()) {
            items.add(entry);
            cursor++;
        } else {
            cursor = 0;
            items.set(cursor, entry);
        }
    }

}
