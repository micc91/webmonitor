package com.webops.duas;

import com.webops.duws.proxy.Envir;
import com.webops.duws.proxy.Execution;
import com.webops.duws.proxy.Launch;
import com.webops.duws.proxy.Variable;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobInfo extends ObjectsList {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(JobInfo.class);

    private int varbegin;
    private int varend;

    public JobInfo() {
        super();

        fields.add("company");
        fields.add("node");
        fields.add("area");
        fields.add("task");
        fields.add("session");
        fields.add("uproc");
        fields.add("mu");
        fields.add("numproc");
        fields.add("numsess");
        fields.add("numlanc");
        fields.add("numentry");
        fields.add("status");
        fields.add("begin_date");
        fields.add("begin_time");
        fields.add("end_date");
        fields.add("end_time");
        fields.add("pdate");
        fields.add("information");
        fields.add("queue");
        fields.add("user");
        fields.add("step");
        fields.add("priority");
        fields.add("varname");
        fields.add("vartype");
        fields.add("varvalue");
        fields.add("varorigin");

        setSize(0);
        name = "jobInfo";
        varbegin = 0;
        varend = 0;
    }

    public void log() {
        String value;
        int ii=0;
        for (Map<String, String> item : items) {
            for (String entry : item.keySet()) {
                value = item.get(entry);
                if (value == null) {
                    value = "NULL";
                }
                logger.info(this.getClass().getName() + ": "+ii+"/" + entry + "=" + value);
            }
            ii++;
        }
    }

    public String getEntry(String key) {
        for (Map<String, String> item : items) {
            for (String entry : item.keySet()) {
                if (entry.equals(key)) {
                    return item.get(entry);
                }
            }
        }
        return "";
    }

    public void putEntry(String key, String value) {
        for (Map<String, String> item : items) {
            for (String entry : item.keySet()) {
                if (entry.equals(key)) {
                    item.put(entry, decodeUrl(value));
                }
            }
        }
    }

    public String decodeUrl(String input) {
        String output = "";
        if(input == null || input.isEmpty()) {
            output = "";
        } else {
            output = input.replaceAll("%20", " ");
        }
        return output;
    }

    // all entries (key,value) are inserted at index 0 in the items list.
    // This way, all job info is found at index 0 in the list
    // except variables that are appended in the items list (done in another method)
    public void addEntry(String field, String value) {
        Map<String, String> entry = null;
        if(items.size() == 0) {
            entry = new HashMap<>();
            entry.put(field,decodeUrl(value));
            items.add(entry);
        } else {
            entry = items.get(0);
            entry.put(field,decodeUrl(value));
            items.set(0,entry);
        }
        logger.info(this.getClass().getName()+"/addEntry "+field+"="+value+", total size="+items.size());
    }

    public void addItems(Envir node, Execution item) {
        addEntry("company",node.getCompany());
        addEntry("node",node.getNode());
        addEntry("area",node.getArea().getValue());
        addEntry("task",item.getData().getIdent().getTask());
        addEntry("session",item.getData().getIdent().getSession());
        addEntry("uproc",item.getData().getIdent().getUproc());
        addEntry("mu",item.getData().getIdent().getMu().getValue());
        addEntry("numlanc",item.getData().getIdent().getNumLanc());
        addEntry("numproc",item.getData().getIdent().getNumProc());
        addEntry("numsess",item.getData().getIdent().getNumSess());
        addEntry("status",item.getData().getStatus());
        addEntry("begin_date",item.getData().getBeginDate());
        addEntry("begin_time",item.getData().getBeginHour());
        addEntry("end_date",item.getData().getEndDate());
        addEntry("end_time",item.getData().getEndHour());
        addEntry("pdate",item.getData().getProcessingDate());
        addEntry("information",item.getData().getInfo());
        addEntry("queue",item.getData().getQueue());
        addEntry("priority",item.getData().getPriority());
        addEntry("numentry",item.getData().getNumEntry());
        addEntry("user",item.getData().getUser());
        addEntry("step", "");
        addEntry("severity", "");

        varbegin = items.size();
        varend = varbegin;
        for(Variable var : item.getVariables().getVariables()) {
            Map<String, String> entry = new HashMap<>();
            entry.put("varname", var.getName());
            entry.put("vartype", var.getType());
            entry.put("varvalue", var.getValue());
            entry.put("varorigin", var.getOrigin());
            items.add(entry);
            logger.info(this.getClass().getName()+"/ adding exec var "+items.get(items.size()-1).get("varname")+"="+items.get(items.size()-1).get("varvalue"));
            varend++;
        }
        setSize(getSize()+1);
        logger.info(this.getClass().getName()+"/ Added exec vars from index "+varbegin+" to "+varend);
    }

    public void addItems(Envir node, Launch item) {

        addEntry("company",node.getCompany());
        addEntry("node",node.getNode());
        addEntry("area",node.getArea().getValue());
        addEntry("task",item.getIdent().getTask());
        addEntry("session",item.getIdent().getSession());
        addEntry("uproc",item.getIdent().getUproc());
        addEntry("mu",item.getIdent().getMu());
        addEntry("numlanc",item.getIdent().getNumLanc());
        addEntry("numproc",item.getIdent().getNumProc());
        addEntry("numsess",item.getIdent().getNumSess());
        addEntry("numentry", "");
        addEntry("status",item.getStatus());
        addEntry("begin_date",item.getBeginDate());
        addEntry("begin_time",item.getBeginHour());
        addEntry("end_date",item.getEndDate());
        addEntry("end_time",item.getEndHour());
        addEntry("pdate",item.getProcessingDate());
        addEntry("information","");
        addEntry("queue",item.getQueue());
        addEntry("priority",item.getPriority());
        addEntry("step", item.getStep());
        addEntry("severity", String.valueOf(item.getSeverity()));


        varbegin = items.size();
        varend = varbegin;
        for(Variable var : item.getVariables().getVariables()) {
            Map<String, String> entry = new HashMap<>();
            entry.put("varname", var.getName());
            entry.put("vartype", var.getType());
            entry.put("varvalue", var.getValue());
            entry.put("varorigin", var.getOrigin());
            items.add(entry);
            logger.info(this.getClass().getName()+"/ adding launch var "+items.get(items.size()-1).get("varname")+"="+items.get(items.size()-1).get("varvalue"));
            varend++;
        }
        setSize(getSize()+1);
        logger.info(this.getClass().getName()+"/ Added launch vars from index "+varbegin+" to "+varend);

    }

    public List<String> getVariables() {
        List<String> varList = new ArrayList<>();
        Map<String, String> item;

        for(int ii = varbegin; ii < varend; ii++) {
            item = items.get(ii);
            logger.info(this.getClass().getName()+"/getVariables: adding "+item.get("varname")+";"+item.get("vartype")+';'+item.get("varvalue")+';'+item.get("varorigin"));
            varList.add(item.get("varname")+";"+item.get("vartype")+';'+item.get("varvalue")+';'+item.get("varorigin"));
        }
        return varList;
    }

    public String getItem(String field) {
        for(Map<String, String> item : items) {
            if(item.get(field) != null ) {
                return item.get(field);
            }
        }
        return "";
    }

    @Override
    public void setFromRequest(HttpServletRequest request) {
        logger.info(this.getClass().getName()+"/setFromRequest: entering....");
        if (request.getAttribute(name) != null) {
            logger.info(this.getClass().getName()+"/setFromRequest: get items from request attribute "+name);
            items = (List<Map<String, String>>) request.getAttribute(name);
        }else {
            logger.info(this.getClass().getName()+"/setFromRequest: request attribute "+name+"=NULL");
        }

        for(String field : fields) {
            if(request.getParameter(field) != null) {
                logger.info(this.getClass().getName()+"/setFromRequest: get "+field+" from request parameters");
                addEntry(field, request.getParameter(field));
            } else {
                logger.info(this.getClass().getName()+"/setFromRequest: parameter "+field+"=NULL");
            }
        }
        logger.info(this.getClass().getName()+"/setFromRequest: end");
    }

    @Override
    public void setInRequest(HttpServletRequest request) {
        logger.info(this.getClass().getName()+"/setInRequest: request attribute "+name+" assigned with "+items.size()+" items, "+items.get(0).size()+" entries at index 0");

        request.setAttribute(name, items);
//        request.setAttribute("variables", getVariables());
        //request.setAttribute("numentry", getItem("numentry"));
        request.setAttribute("varbegin", varbegin);
        request.setAttribute("varend", varend);
    }

    @Override
    public void setInSession(HttpSession session) {

        session.setAttribute(name, items);
//        session.setAttribute("variables", getVariables());
        //session.setAttribute("numentry", getItem("numentry"));
        session.setAttribute("varbegin", varbegin);
        session.setAttribute("varend", varend);
    }

}
