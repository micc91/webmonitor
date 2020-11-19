package com.webops.duas;

import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobLogs extends ObjectsList {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(NodesList.class);

    public JobLogs() {
        super();
        fields.add("type"); // can be: joblog, trace, sessionlabel, uproclabel, mulabel
        fields.add("value");

        name="jobLogs";
    }

    public List<String> getJobLog() {
        List<String> output = new ArrayList<>();

        for(Map<String, String> item : items) {
            if(item.get("type").equals("joblog")) {
                output.add(item.get("value"));
            }
        }

        return output;
    }

    public List<String> getHistoryTrace() {
        List<String> output = new ArrayList<>();

        for(Map<String, String> item : items) {
            if(item.get("type").equals("trace")) {
                output.add(item.get("value"));
            }
        }

        return output;
    }

    public boolean addItem(String type, String value) {
        Map<String, String> entry = new HashMap<>();

        entry.put("type",type);
        entry.put("value",value);
        return items.add(entry);
    }
}
