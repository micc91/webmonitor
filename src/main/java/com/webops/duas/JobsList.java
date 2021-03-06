package com.webops.duas;

import com.webops.duws.proxy.Envir;
import com.webops.duws.proxy.ExecutionItem;
import com.webops.duws.proxy.LaunchItem;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JobsList extends ObjectsList {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = Logger.getLogger(JobsList.class);

    private Map<String,Integer> jobStats = new HashMap<>();
    private List<String> statusList = new ArrayList<>();
    private String xdata = "";
    private String ydata = "";

    public JobsList() {
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
        fields.add("urlparams");
        fields.add("hashcode");

        name = "jobsList";

        statusList.add("LAUNCH_WAIT");
        statusList.add("PENDING");
        statusList.add("RUNNING");
        statusList.add("EVENT_WAIT");
        statusList.add("WATCHING");
        statusList.add("DISABLED");
        statusList.add("COMPLETED");
        statusList.add("ABORTED");
        statusList.add("TIME_OVERRUN");
        statusList.add("REFUSED");

        resetStats();
    }

    private void resetStats() {
        for (String status : statusList) {
            jobStats.put(status, 0);
        }
        xdata = "";
        ydata = "";
    }

    @Override
    public void reset() {
        if( ! items.isEmpty()) {
            items.clear();
        }
        setSize(0);
        resetStats();
    }

    public boolean isCtl(String status) {
        return status.equals("RUNNING") || status.equals("COMPLETED") || status.equals("ABORTED");
    }

    public boolean isFla(String status) {
        return !isCtl(status);
    }

    public Map<String, String> getItem(int index) {
        if(index >= 0 && index < items.size()) {
            return(items.get(index));
        } else {
            return null;
        }
    }

    public String getItemField(int index, String field) {
        if(index >= 0 && index < items.size() && fields.contains(field)) {
            Map<String, String> item = items.get(index);
            return item.get(field);
        } else {
            return null;
        }
    }

    public void addItem(Envir node, ExecutionItem item) {
        Map<String, String> entry = new HashMap<>();

        //TODO: count number of jobs of each type
        // in a map
        int current = jobStats.get(item.getStatus());
        jobStats.put(item.getStatus(), current + 1);

        entry.put("company",node.getCompany());
        entry.put("node",node.getNode());
        entry.put("area",node.getArea().getValue());
        entry.put("task",item.getIdent().getTask());
        entry.put("session",item.getIdent().getSession());
        entry.put("uproc",item.getIdent().getUproc());
        entry.put("mu",item.getIdent().getMu().getValue());
        entry.put("numlanc",item.getIdent().getNumLanc());
        entry.put("numproc",item.getIdent().getNumProc());
        entry.put("numsess",item.getIdent().getNumSess());
        entry.put("status",item.getStatus());
        entry.put("begin_date",item.getBeginDate());
        entry.put("begin_time",item.getBeginHour());
        entry.put("end_date",item.getEndDate());
        entry.put("end_time",item.getEndHour());
        entry.put("pdate",item.getProcessingDate());
        entry.put("information",item.getInfo());
        entry.put("queue",item.getQueue());
        entry.put("user", item.getUser());
        entry.put("priority",item.getPriority());
        entry.put("step", "");

        entry.put("urlparams", encodeUrlParams(entry));
        entry.put("hashcode", String.valueOf(entry.hashCode()));

        items.add(entry);
        setSize(getSize()+1);

    }

    public void addItem(Envir node, LaunchItem item) {
        Map<String, String> entry = new HashMap<>();

        int current = jobStats.get(item.getStatus());
        jobStats.put(item.getStatus(), current + 1);

        entry.put("company",node.getCompany());
        entry.put("node",node.getNode());
        entry.put("area",node.getArea().getValue());
        entry.put("task",item.getIdent().getTask());
        entry.put("session",item.getIdent().getSession());
        entry.put("uproc",item.getIdent().getUproc());
        entry.put("mu",item.getIdent().getMu());
        entry.put("numlanc",item.getIdent().getNumLanc());
        entry.put("numproc",item.getIdent().getNumProc());
        entry.put("numsess",item.getIdent().getNumSess());
        entry.put("status",item.getStatus());
        entry.put("begin_date",item.getBeginDate());
        entry.put("begin_time",item.getBeginHour());
        entry.put("end_date",item.getEndDate());
        entry.put("end_time",item.getEndHour());
        entry.put("pdate",item.getProcessingDate());
        entry.put("information","");
        entry.put("queue",item.getQueue());
        entry.put("user", "");
        entry.put("priority",item.getPriority());
        entry.put("step", item.getStep());

        entry.put("urlparams", encodeUrlParams(entry));
        entry.put("hashcode", String.valueOf(entry.hashCode()));
        items.add(entry);
        setSize(getSize()+1);
    }

    private String encodeUrlParams(Map<String, String> entry) {
        String output = "";
        String encoded = "";
        String buffer = "";
        String value = "";
        for(String key : entry.keySet()) {
            value = entry.get(key);
//            buffer = value.replaceAll("%","%25");
//            value = buffer;
            buffer = value.replaceAll(" ","%20");
/*            value = buffer;
            buffer = value.replaceAll(";","%3B");
            value = buffer;
            buffer = value.replaceAll("\\?","%3F");
            value = buffer;
            buffer = value.replaceAll("/","%2F");
            value = buffer;
            buffer = value.replaceAll(":","%3A");
            value = buffer;
            buffer = value.replaceAll("#","%23");
            value = buffer;
            buffer = value.replaceAll("&","%26");
            value = buffer;
            buffer = value.replaceAll("=","%3D");
            value = buffer;
            buffer = value.replaceAll("\\+","%2B");
            value = buffer;
            buffer = value.replaceAll("\\$","%24");
            value = buffer;
            buffer = value.replaceAll(",","%2C");
            value = buffer;
            buffer = value.replaceAll("<","%3C");
            value = buffer;
            buffer = value.replaceAll(">","%3E");
            value = buffer;
            buffer = value.replaceAll("~","%7E");
 */
            encoded = buffer;
            if(!output.isEmpty()) { output = output+"&"; }
            output=output+key+"="+encoded;
        }

        return output;
    }

    @Override
    public void setInRequest(HttpServletRequest request) {

        request.setAttribute(name, items);
        String xdata;
        String ydata;
        String sep = "";
        StringBuilder xdataBuilder = new StringBuilder("[ ");
        StringBuilder ydataBuilder = new StringBuilder("[ ");
        for(String item : statusList) {
            xdataBuilder.append(sep).append("'").append(item).append("'");
            ydataBuilder.append(sep).append(jobStats.get(item));
            sep = ", ";
        }
        ydata = ydataBuilder.toString();
        xdata = xdataBuilder.toString();
        xdata = xdata + " ]";
        ydata = ydata + " ]";
        request.setAttribute("xdata", xdata);
        request.setAttribute("ydata", ydata);
    }

    @Override
    public void setInSession(HttpSession session) {

        session.setAttribute(name, items);
        String xdata;
        String ydata;
        String sep = "";
        StringBuilder xdataBuilder = new StringBuilder("[ ");
        StringBuilder ydataBuilder = new StringBuilder("[ ");
        for(String item : statusList) {
            xdataBuilder.append(sep).append("'").append(item).append("'");
            ydataBuilder.append(sep).append(jobStats.get(item));
            sep = ", ";
        }
        ydata = ydataBuilder.toString();
        xdata = xdataBuilder.toString();
        xdata = xdata + " ]";
        ydata = ydata + " ]";
        session.setAttribute("xdata", xdata);
        session.setAttribute("ydata", ydata);
    }

}
