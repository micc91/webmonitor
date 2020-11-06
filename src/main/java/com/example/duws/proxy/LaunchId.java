
package com.example.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for launchId complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="launchId">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="task" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="session" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="sessionVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="uproc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="uprocVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="mu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="numLanc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="numSess" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="numProc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "launchId", propOrder = {
    "task",
    "session",
    "sessionVersion",
    "uproc",
    "uprocVersion",
    "mu",
    "numLanc",
    "numSess",
    "numProc"
})
public class LaunchId {

    protected String task;
    protected String session;
    protected String sessionVersion;
    protected String uproc;
    protected String uprocVersion;
    protected String mu;
    protected String numLanc;
    protected String numSess;
    protected String numProc;

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
     * Gets the value of the numLanc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumLanc() {
        return numLanc;
    }

    /**
     * Sets the value of the numLanc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumLanc(String value) {
        this.numLanc = value;
    }

    /**
     * Gets the value of the numSess property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumSess() {
        return numSess;
    }

    /**
     * Sets the value of the numSess property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumSess(String value) {
        this.numSess = value;
    }

    /**
     * Gets the value of the numProc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumProc() {
        return numProc;
    }

    /**
     * Sets the value of the numProc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumProc(String value) {
        this.numProc = value;
    }

}
