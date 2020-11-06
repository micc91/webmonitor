
package com.example.duws.proxy;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for executionId complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="executionId">
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
 *         &lt;element name="numProc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="numSess" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="tempfilePath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "executionId", propOrder = {
    "task",
    "session",
    "sessionVersion",
    "uproc",
    "uprocVersion",
    "mu",
    "numLanc",
    "numProc",
    "numSess",
    "tempfilePath"
})
public class ExecutionId {

    protected String task;
    protected String session;
    @XmlElementRef(name = "sessionVersion", namespace = "http://duws.orsyp.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> sessionVersion;
    protected String uproc;
    protected String uprocVersion;
    @XmlElementRef(name = "mu", namespace = "http://duws.orsyp.com", type = JAXBElement.class, required = false)
    protected JAXBElement<String> mu;
    protected String numLanc;
    protected String numProc;
    protected String numSess;
    protected String tempfilePath;

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
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getSessionVersion() {
        return sessionVersion;
    }

    /**
     * Sets the value of the sessionVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setSessionVersion(JAXBElement<String> value) {
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
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public JAXBElement<String> getMu() {
        return mu;
    }

    /**
     * Sets the value of the mu property.
     * 
     * @param value
     *     allowed object is
     *     {@link JAXBElement }{@code <}{@link String }{@code >}
     *     
     */
    public void setMu(JAXBElement<String> value) {
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
     * Gets the value of the tempfilePath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTempfilePath() {
        return tempfilePath;
    }

    /**
     * Sets the value of the tempfilePath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTempfilePath(String value) {
        this.tempfilePath = value;
    }

}
