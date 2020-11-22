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

    private void addEntry(String field, String value) {
        Map<String, String> entry = new HashMap<>();

        entry.put(field,value);
        items.add(entry);
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
        addEntry("step", "");

        Map<String, String> entry = new HashMap<>();

        varbegin = items.size();
        varend = varbegin;
        for(Variable var : item.getVariables().getVariables()) {
            entry.put("varname", var.getName());
            entry.put("vartype", var.getType());
            entry.put("varvalue", var.getValue());
            entry.put("varorigin", var.getOrigin());
            items.add(entry);
            logger.info(this.getClass().getName()+"/ adding exec var "+items.get(items.size()-1).get("varname")+"="+items.get(items.size()-1).get("varvalue"));
            varend++;
        }
        setSize(getSize()+1);
        logger.info(this.getClass().getName()+"/ Added vars from index "+varbegin+" to "+varend);
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

        Map<String, String> entry = new HashMap<>();

        varbegin = items.size();
        varend = varbegin;
        for(Variable var : item.getVariables().getVariables()) {
            entry.put("varname", var.getName());
            entry.put("vartype", var.getType());
            entry.put("varvalue", var.getValue());
            entry.put("varorigin", var.getOrigin());
            items.add(entry);
            logger.info(this.getClass().getName()+"/ adding launch var "+items.get(items.size()-1).get("varname")+"="+items.get(items.size()-1).get("varvalue"));
            varend++;
        }
        setSize(getSize()+1);

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
    public void setInRequest(HttpServletRequest request) {

        request.setAttribute(name, items);
//        request.setAttribute("variables", getVariables());
        request.setAttribute("numentry", getItem("numentry"));
        request.setAttribute("varbegin", varbegin);
        request.setAttribute("varend", varend);
    }

    @Override
    public void setInSession(HttpSession session) {

        session.setAttribute(name, items);
//        session.setAttribute("variables", getVariables());
        session.setAttribute("numentry", getItem("numentry"));
        session.setAttribute("varbegin", varbegin);
        session.setAttribute("varend", varend);
    }

}
