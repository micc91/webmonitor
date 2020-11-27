package com.webops.duas;

import com.webops.duws.proxy.Envir;
import com.webops.duws.proxy.UprocItem;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class UprocList extends ObjectsList {

    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(UprocList.class);

    public UprocList() {
        super();

        fields.add("company");
        fields.add("node");
        fields.add("area");
        fields.add("uproc");
        fields.add("label");
        fields.add("application");
        fields.add("domain");

        name = "uprocList";
        setSize(0);
    }

    public boolean addItem(Envir node, UprocItem item) {
        Map<String, String> entry = new HashMap<>();

        entry.put("company",node.getCompany());
        entry.put("node",node.getNode());
        entry.put("area",node.getArea().getValue());

        entry.put("uproc", item.getIdent().getUproc());
        entry.put("label", item.getLabel());
        entry.put("application", item.getApplication());
        entry.put("domain", item.getDomain());
        setSize(getSize()+1);
        return items.add(entry);
    }
}
