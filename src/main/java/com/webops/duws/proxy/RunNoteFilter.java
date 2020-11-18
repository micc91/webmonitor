
package com.webops.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for runNoteFilter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="runNoteFilter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="session" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="sessionVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="uproc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="uprocVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="task" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="taskVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="mu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="numnote" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="numlanc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="numsess" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "runNoteFilter", propOrder = {
    "session",
    "sessionVersion",
    "uproc",
    "uprocVersion",
    "task",
    "taskVersion",
    "mu",
    "numnote",
    "numlanc",
    "numsess"
})
public class RunNoteFilter {

    protected String session;
    protected String sessionVersion;
    protected String uproc;
    protected String uprocVersion;
    protected String task;
    protected String taskVersion;
    protected String mu;
    protected String numnote;
    protected String numlanc;
    protected String numsess;

    /**
     * Gets the value of the session property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSession() {
        return session;
    }

    /**
     * Sets the value of the session property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSession(String value) {
        this.session = value;
    }

    /**
     * Gets the value of the sessionVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionVersion() {
        return sessionVersion;
    }

    /**
     * Sets the value of the sessionVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionVersion(String value) {
        this.sessionVersion = value;
    }

    /**
     * Gets the value of the uproc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUproc() {
        return uproc;
    }

    /**
     * Sets the value of the uproc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUproc(String value) {
        this.uproc = value;
    }

    /**
     * Gets the value of the uprocVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUprocVersion() {
        return uprocVersion;
    }

    /**
     * Sets the value of the uprocVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUprocVersion(String value) {
        this.uprocVersion = value;
    }

    /**
     * Gets the value of the task property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTask() {
        return task;
    }

    /**
     * Sets the value of the task property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTask(String value) {
        this.task = value;
    }

    /**
     * Gets the value of the taskVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTaskVersion() {
        return taskVersion;
    }

    /**
     * Sets the value of the taskVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTaskVersion(String value) {
        this.taskVersion = value;
    }

    /**
     * Gets the value of the mu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMu() {
        return mu;
    }

    /**
     * Sets the value of the mu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMu(String value) {
        this.mu = value;
    }

    /**
     * Gets the value of the numnote property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumnote() {
        return numnote;
    }

    /**
     * Sets the value of the numnote property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumnote(String value) {
        this.numnote = value;
    }

    /**
     * Gets the value of the numlanc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumlanc() {
        return numlanc;
    }

    /**
     * Sets the value of the numlanc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumlanc(String value) {
        this.numlanc = value;
    }

    /**
     * Gets the value of the numsess property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumsess() {
        return numsess;
    }

    /**
     * Sets the value of the numsess property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumsess(String value) {
        this.numsess = value;
    }

}
