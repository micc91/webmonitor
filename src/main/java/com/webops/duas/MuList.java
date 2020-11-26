package com.webops.duas;

import com.webops.duws.proxy.Envir;
import com.webops.duws.proxy.MuItem;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class MuList extends ObjectsList {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(TaskList.class);

    public MuList() {
        super();

        fields.add("company");
        fields.add("node");
        fields.add("area");
        fields.add("mu");
        fields.add("label");
        fields.add("reference");

        name = "muList";
        setSize(0);
    }

    public boolean addItem(Envir node, MuItem item) {
        Map<String, String> entry = new HashMap<>();

        entry.put("company",node.getCompany());
        entry.put("node",node.getNode());
        entry.put("area",node.getArea().getValue());
        entry.put("mu", item.getIdent().getMu());
        entry.put("label", item.getLabel());
        entry.put("reference", item.getNode());

        setSize(getSize()+1);
        return items.add(entry);
    }
}
