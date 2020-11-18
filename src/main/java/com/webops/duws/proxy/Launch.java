
package com.webops.duws.proxy;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for launch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="launch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ident" type="{http://duws.orsyp.com}launchId" minOccurs="0" form="qualified"/>
 *         &lt;element name="variables" minOccurs="0" form="qualified">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="variables" type="{http://duws.orsyp.com}variable" maxOccurs="unbounded" minOccurs="0" form="qualified"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *         &lt;element name="autoRestart" type="{http://www.w3.org/2001/XMLSchema}boolean" form="qualified"/>
 *         &lt;element name="centralControl" type="{http://www.w3.org/2001/XMLSchema}boolean" form="qualified"/>
 *         &lt;element name="forcedExecution" type="{http://www.w3.org/2001/XMLSchema}boolean" form="qualified"/>
 *         &lt;element name="bypassCondCheck" type="{http://www.w3.org/2001/XMLSchema}boolean" form="qualified"/>
 *         &lt;element name="exclusionFrom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="exclusionTo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="beginDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="beginHour" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="endHour" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="processingDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="uvmsConnection" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="step" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="node" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="queue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="priority" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="information" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="severity" type="{http://www.w3.org/2001/XMLSchema}int" form="qualified"/>
 *         &lt;element name="rankInSession" type="{http://www.w3.org/2001/XMLSchema}int" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "launch", propOrder = {
    "ident",
    "variables",
    "autoRestart",
    "centralControl",
    "forcedExecution",
    "bypassCondCheck",
    "exclusionFrom",
    "exclusionTo",
    "status",
    "beginDate",
    "beginHour",
    "endDate",
    "endHour",
    "processingDate",
    "uvmsConnection",
    "step",
    "node",
    "queue",
    "priority",
    "information",
    "severity",
    "rankInSession"
})
public class Launch {

    protected LaunchId ident;
    protected Launch.Variables variables;
    protected boolean autoRestart;
    protected boolean centralControl;
    protected boolean forcedExecution;
    protected boolean bypassCondCheck;
    protected String exclusionFrom;
    protected String exclusionTo;
    protected String status;
    protected String beginDate;
    protected String beginHour;
    protected String endDate;
    protected String endHour;
    protected String processingDate;
    protected String uvmsConnection;
    protected String step;
    protected String node;
    protected String queue;
    protected String priority;
    protected String information;
    protected int severity;
    protected int rankInSession;

    /**
     * Gets the value of the ident property.
     * 
     * @return
     *     possible object is
     *     {@link LaunchId }
     *     
     */
    public LaunchId getIdent() {
        return ident;
    }

    /**
     * Sets the value of the ident property.
     * 
     * @param value
     *     allowed object is
     *     {@link LaunchId }
     *     
     */
    public void setIdent(LaunchId value) {
        this.ident = value;
    }

    /**
     * Gets the value of the variables property.
     * 
     * @return
     *     possible object is
     *     {@link Launch.Variables }
     *     
     */
    public Launch.Variables getVariables() {
        return variables;
    }

    /**
     * Sets the value of the variables property.
     * 
     * @param value
     *     allowed object is
     *     {@link Launch.Variables }
     *     
     */
    public void setVariables(Launch.Variables value) {
        this.variables = value;
    }

    /**
     * Gets the value of the autoRestart property.
     * 
     */
    public boolean isAutoRestart() {
        return autoRestart;
    }

    /**
     * Sets the value of the autoRestart property.
     * 
     */
    public void setAutoRestart(boolean value) {
        this.autoRestart = value;
    }

    /**
     * Gets the value of the centralControl property.
     * 
     */
    public boolean isCentralControl() {
        return centralControl;
    }

    /**
     * Sets the value of the centralControl property.
     * 
     */
    public void setCentralControl(boolean value) {
        this.centralControl = value;
    }

    /**
     * Gets the value of the forcedExecution property.
     * 
     */
    public boolean isForcedExecution() {
        return forcedExecution;
    }

    /**
     * Sets the value of the forcedExecution property.
     * 
     */
    public void setForcedExecution(boolean value) {
        this.forcedExecution = value;
    }

    /**
     * Gets the value of the bypassCondCheck property.
     * 
     */
    public boolean isBypassCondCheck() {
        return bypassCondCheck;
    }

    /**
     * Sets the value of the bypassCondCheck property.
     * 
     */
    public void setBypassCondCheck(boolean value) {
        this.bypassCondCheck = value;
    }

    /**
     * Gets the value of the exclusionFrom property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExclusionFrom() {
        return exclusionFrom;
    }

    /**
     * Sets the value of the exclusionFrom property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExclusionFrom(String value) {
        this.exclusionFrom = value;
    }

    /**
     * Gets the value of the exclusionTo property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getExclusionTo() {
        return exclusionTo;
    }

    /**
     * Sets the value of the exclusionTo property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setExclusionTo(String value) {
        this.exclusionTo = value;
    }

    /**
     * Gets the value of the status property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStatus() {
        return status;
    }

    /**
     * Sets the value of the status property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStatus(String value) {
        this.status = value;
    }

    /**
     * Gets the value of the beginDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeginDate() {
        return beginDate;
    }

    /**
     * Sets the value of the beginDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeginDate(String value) {
        this.beginDate = value;
    }

    /**
     * Gets the value of the beginHour property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeginHour() {
        return beginHour;
    }

    /**
     * Sets the value of the beginHour property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeginHour(String value) {
        this.beginHour = value;
    }

    /**
     * Gets the value of the endDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the value of the endDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDate(String value) {
        this.endDate = value;
    }

    /**
     * Gets the value of the endHour property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndHour() {
        return endHour;
    }

    /**
     * Sets the value of the endHour property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndHour(String value) {
        this.endHour = value;
    }

    /**
     * Gets the value of the processingDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getProcessingDate() {
        return processingDate;
    }

    /**
     * Sets the value of the processingDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setProcessingDate(String value) {
        this.processingDate = value;
    }

    /**
     * Gets the value of the uvmsConnection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUvmsConnection() {
        return uvmsConnection;
    }

    /**
     * Sets the value of the uvmsConnection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUvmsConnection(String value) {
        this.uvmsConnection = value;
    }

    /**
     * Gets the value of the step property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStep() {
        return step;
    }

    /**
     * Sets the value of the step property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStep(String value) {
        this.step = value;
    }

    /**
     * Gets the value of the node property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNode() {
        return node;
    }

    /**
     * Sets the value of the node property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNode(String value) {
        this.node = value;
    }

    /**
     * Gets the value of the queue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getQueue() {
        return queue;
    }

    /**
     * Sets the value of the queue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setQueue(String value) {
        this.queue = value;
    }

    /**
     * Gets the value of the priority property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPriority() {
        return priority;
    }

    /**
     * Sets the value of the priority property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPriority(String value) {
        this.priority = value;
    }

    /**
     * Gets the value of the information property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInformation() {
        return information;
    }

    /**
     * Sets the value of the information property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInformation(String value) {
        this.information = value;
    }

    /**
     * Gets the value of the severity property.
     * 
     */
    public int getSeverity() {
        return severity;
    }

    /**
     * Sets the value of the severity property.
     * 
     */
    public void setSeverity(int value) {
        this.severity = value;
    }

    /**
     * Gets the value of the rankInSession property.
     * 
     */
    public int getRankInSession() {
        return rankInSession;
    }

    /**
     * Sets the value of the rankInSession property.
     * 
     */
    public void setRankInSession(int value) {
        this.rankInSession = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="variables" type="{http://duws.orsyp.com}variable" maxOccurs="unbounded" minOccurs="0" form="qualified"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "variables"
    })
    public static class Variables {

        protected List<Variable> variables;

        /**
         * Gets the value of the variables property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the variables property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getVariables().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Variable }
         * 
         * 
         */
        public List<Variable> getVariables() {
            if (variables == null) {
                variables = new ArrayList<Variable>();
            }
            return this.variables;
        }

    }

}
