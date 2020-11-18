
package com.webops.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for eventFilter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="eventFilter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="uproc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="session" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="mu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="uvmsConnection" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="creationDateMin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="creationDateMax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="creationHourMin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="creationHourMax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="updateDateMin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="updateDateMax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="updateHourMin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="updateHourMax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="processingDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="numlancMin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="numlancMax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="numsessMin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="numsessMax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="numprocMin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="numprocMax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "eventFilter", propOrder = {
    "uproc",
    "session",
    "mu",
    "status",
    "uvmsConnection",
    "creationDateMin",
    "creationDateMax",
    "creationHourMin",
    "creationHourMax",
    "updateDateMin",
    "updateDateMax",
    "updateHourMin",
    "updateHourMax",
    "processingDate",
    "numlancMin",
    "numlancMax",
    "numsessMin",
    "numsessMax",
    "numprocMin",
    "numprocMax"
})
public class EventFilter {

    protected String uproc;
    protected String session;
    protected String mu;
    protected String status;
    protected String uvmsConnection;
    protected String creationDateMin;
    protected String creationDateMax;
    protected String creationHourMin;
    protected String creationHourMax;
    protected String updateDateMin;
    protected String updateDateMax;
    protected String updateHourMin;
    protected String updateHourMax;
    protected String processingDate;
    protected String numlancMin;
    protected String numlancMax;
    protected String numsessMin;
    protected String numsessMax;
    protected String numprocMin;
    protected String numprocMax;

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
     * Gets the value of the creationDateMin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreationDateMin() {
        return creationDateMin;
    }

    /**
     * Sets the value of the creationDateMin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreationDateMin(String value) {
        this.creationDateMin = value;
    }

    /**
     * Gets the value of the creationDateMax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreationDateMax() {
        return creationDateMax;
    }

    /**
     * Sets the value of the creationDateMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreationDateMax(String value) {
        this.creationDateMax = value;
    }

    /**
     * Gets the value of the creationHourMin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreationHourMin() {
        return creationHourMin;
    }

    /**
     * Sets the value of the creationHourMin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreationHourMin(String value) {
        this.creationHourMin = value;
    }

    /**
     * Gets the value of the creationHourMax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreationHourMax() {
        return creationHourMax;
    }

    /**
     * Sets the value of the creationHourMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreationHourMax(String value) {
        this.creationHourMax = value;
    }

    /**
     * Gets the value of the updateDateMin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdateDateMin() {
        return updateDateMin;
    }

    /**
     * Sets the value of the updateDateMin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdateDateMin(String value) {
        this.updateDateMin = value;
    }

    /**
     * Gets the value of the updateDateMax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdateDateMax() {
        return updateDateMax;
    }

    /**
     * Sets the value of the updateDateMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdateDateMax(String value) {
        this.updateDateMax = value;
    }

    /**
     * Gets the value of the updateHourMin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdateHourMin() {
        return updateHourMin;
    }

    /**
     * Sets the value of the updateHourMin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdateHourMin(String value) {
        this.updateHourMin = value;
    }

    /**
     * Gets the value of the updateHourMax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUpdateHourMax() {
        return updateHourMax;
    }

    /**
     * Sets the value of the updateHourMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUpdateHourMax(String value) {
        this.updateHourMax = value;
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
     * Gets the value of the numlancMin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumlancMin() {
        return numlancMin;
    }

    /**
     * Sets the value of the numlancMin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumlancMin(String value) {
        this.numlancMin = value;
    }

    /**
     * Gets the value of the numlancMax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumlancMax() {
        return numlancMax;
    }

    /**
     * Sets the value of the numlancMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumlancMax(String value) {
        this.numlancMax = value;
    }

    /**
     * Gets the value of the numsessMin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumsessMin() {
        return numsessMin;
    }

    /**
     * Sets the value of the numsessMin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumsessMin(String value) {
        this.numsessMin = value;
    }

    /**
     * Gets the value of the numsessMax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumsessMax() {
        return numsessMax;
    }

    /**
     * Sets the value of the numsessMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumsessMax(String value) {
        this.numsessMax = value;
    }

    /**
     * Gets the value of the numprocMin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumprocMin() {
        return numprocMin;
    }

    /**
     * Sets the value of the numprocMin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumprocMin(String value) {
        this.numprocMin = value;
    }

    /**
     * Gets the value of the numprocMax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumprocMax() {
        return numprocMax;
    }

    /**
     * Sets the value of the numprocMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumprocMax(String value) {
        this.numprocMax = value;
    }

}
