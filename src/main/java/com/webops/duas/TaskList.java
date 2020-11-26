package com.webops.duas;

import com.webops.duws.proxy.Envir;
import com.webops.duws.proxy.TaskItem;
import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

public class TaskList extends ObjectsList {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(TaskList.class);

    public TaskList() {
        super();

        fields.add("company");
        fields.add("node");
        fields.add("area");
        fields.add("task");
        fields.add("label");
        fields.add("session");
        fields.add("uproc");
        fields.add("mu");
        fields.add("authorcode");
        fields.add("queue");
        fields.add("type");

        name = "taskList";
        setSize(0);
    }

    public boolean addItem(Envir node, TaskItem item) {
        Map<String, String> entry = new HashMap<>();

        if(item.getIdent().isTemplate()) {
            // this type of task is ignored
            return true;
        }

        entry.put("company",node.getCompany());
        entry.put("node",node.getNode());
        entry.put("area",node.getArea().getValue());

        entry.put("task",item.getIdent().getTask());
        entry.put("session",item.getIdent().getSession());
        entry.put("uproc",item.getIdent().getUproc());
        entry.put("mu",item.getIdent().getMu());
        entry.put("authorcode",item.getAuthorCode());
        entry.put("user",item.getAuthorCode());
        entry.put("queue",item.getQueue());
        entry.put("type",item.getType());

        setSize(getSize()+1);
        return items.add(entry);
    }
}
