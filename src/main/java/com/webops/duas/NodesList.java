package com.webops.duas;

import com.webops.duws.proxy.Envir;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class NodesList extends ObjectsList {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(NodesList.class);

    public NodesList() {
        super();

        fields.add("company");
        fields.add("node");
        fields.add("area");
        fields.add("status");
        fields.add("version");

        name = "nodesList";
        setSize(0);
    }

    public boolean addItem(Envir item) {
        Map<String, String> entry = new HashMap<>();

        entry.put("company",item.getCompany());
        entry.put("node",item.getNode());
        entry.put("area",item.getArea().getValue());
        entry.put("version",item.getVersion().getValue());
        entry.put("status",item.getStatus().getValue().toString());
        setSize(getSize()+1);
        return items.add(entry);
    }
}
