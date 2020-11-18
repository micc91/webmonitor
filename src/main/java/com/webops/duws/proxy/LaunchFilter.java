
package com.webops.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for launchFilter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="launchFilter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="task" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="session" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="uproc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="mu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="uvmsConnection" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="beginDateMin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="beginDateMax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="beginHourMin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="beginHourMax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="endDateMin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="endDateMax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="endHourMin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="endHourMax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="processingDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="numlancMin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="numlancMax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="numsessMin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="numsessMax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="numprocMin" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="numprocMax" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="orderByFields" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="order" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="maximumResults" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "launchFilter", propOrder = {
    "task",
    "session",
    "uproc",
    "mu",
    "status",
    "uvmsConnection",
    "beginDateMin",
    "beginDateMax",
    "beginHourMin",
    "beginHourMax",
    "endDateMin",
    "endDateMax",
    "endHourMin",
    "endHourMax",
    "processingDate",
    "numlancMin",
    "numlancMax",
    "numsessMin",
    "numsessMax",
    "numprocMin",
    "numprocMax",
    "orderByFields",
    "order",
    "maximumResults"
})
public class LaunchFilter {

    protected String task;
    protected String session;
    protected String uproc;
    protected String mu;
    protected String status;
    protected String uvmsConnection;
    protected String beginDateMin;
    protected String beginDateMax;
    protected String beginHourMin;
    protected String beginHourMax;
    protected String endDateMin;
    protected String endDateMax;
    protected String endHourMin;
    protected String endHourMax;
    protected String processingDate;
    protected String numlancMin;
    protected String numlancMax;
    protected String numsessMin;
    protected String numsessMax;
    protected String numprocMin;
    protected String numprocMax;
    protected String orderByFields;
    protected String order;
    protected String maximumResults;

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
     * Gets the value of the beginDateMin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeginDateMin() {
        return beginDateMin;
    }

    /**
     * Sets the value of the beginDateMin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeginDateMin(String value) {
        this.beginDateMin = value;
    }

    /**
     * Gets the value of the beginDateMax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeginDateMax() {
        return beginDateMax;
    }

    /**
     * Sets the value of the beginDateMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeginDateMax(String value) {
        this.beginDateMax = value;
    }

    /**
     * Gets the value of the beginHourMin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeginHourMin() {
        return beginHourMin;
    }

    /**
     * Sets the value of the beginHourMin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeginHourMin(String value) {
        this.beginHourMin = value;
    }

    /**
     * Gets the value of the beginHourMax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBeginHourMax() {
        return beginHourMax;
    }

    /**
     * Sets the value of the beginHourMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBeginHourMax(String value) {
        this.beginHourMax = value;
    }

    /**
     * Gets the value of the endDateMin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDateMin() {
        return endDateMin;
    }

    /**
     * Sets the value of the endDateMin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDateMin(String value) {
        this.endDateMin = value;
    }

    /**
     * Gets the value of the endDateMax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndDateMax() {
        return endDateMax;
    }

    /**
     * Sets the value of the endDateMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndDateMax(String value) {
        this.endDateMax = value;
    }

    /**
     * Gets the value of the endHourMin property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndHourMin() {
        return endHourMin;
    }

    /**
     * Sets the value of the endHourMin property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndHourMin(String value) {
        this.endHourMin = value;
    }

    /**
     * Gets the value of the endHourMax property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getEndHourMax() {
        return endHourMax;
    }

    /**
     * Sets the value of the endHourMax property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setEndHourMax(String value) {
        this.endHourMax = value;
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

    /**
     * Gets the value of the orderByFields property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrderByFields() {
        return orderByFields;
    }

    /**
     * Sets the value of the orderByFields property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrderByFields(String value) {
        this.orderByFields = value;
    }

    /**
     * Gets the value of the order property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getOrder() {
        return order;
    }

    /**
     * Sets the value of the order property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setOrder(String value) {
        this.order = value;
    }

    /**
     * Gets the value of the maximumResults property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMaximumResults() {
        return maximumResults;
    }

    /**
     * Sets the value of the maximumResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMaximumResults(String value) {
        this.maximumResults = value;
    }

}
