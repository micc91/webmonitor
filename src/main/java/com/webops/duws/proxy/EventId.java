
package com.webops.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eventId complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="eventId">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="uproc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="session" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="mu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="processingDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="numProc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="numSess" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="uvmsConnection" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eventId", propOrder = {
    "uproc",
    "session",
    "mu",
    "processingDate",
    "numProc",
    "numSess",
    "uvmsConnection"
})
public class EventId {

    protected String uproc;
    protected String session;
    protected String mu;
    protected String processingDate;
    protected String numProc;
    protected String numSess;
    protected String uvmsConnection;

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

}
