package com.webops.duas;

import com.webops.duws.proxy.Envir;
import com.webops.duws.proxy.SessionItem;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class SessionList extends ObjectsList {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(SessionList.class);

    public SessionList() {
        super();

        fields.add("company");
        fields.add("node");
        fields.add("area");
        fields.add("session");
        fields.add("label");
        fields.add("uproc");

        name = "sessionList";
        setSize(0);
    }

    public boolean addItem(Envir node, SessionItem item) {
        Map<String, String> entry = new HashMap<>();

        entry.put("company",node.getCompany());
        entry.put("node",node.getNode());
        entry.put("area",node.getArea().getValue());

        entry.put("session", item.getIdent().getSession());
        entry.put("label", item.getLabel());
        entry.put("uproc", item.getHead());

        setSize(getSize()+1);
        return items.add(entry);
    }
}
