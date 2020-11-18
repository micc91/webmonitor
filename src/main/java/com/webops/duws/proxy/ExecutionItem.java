
package com.webops.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for executionItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="executionItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ident" type="{http://duws.orsyp.com}executionId" minOccurs="0" form="qualified"/>
 *         &lt;element name="status" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="beginDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="beginHour" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="endHour" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="processingDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="uvmsConnection" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="relaunched" type="{http://www.w3.org/2001/XMLSchema}boolean" form="qualified"/>
 *         &lt;element name="node" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="queue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="priority" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="numEntry" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="info" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "executionItem", propOrder = {
    "ident",
    "status",
    "beginDate",
    "beginHour",
    "endDate",
    "endHour",
    "processingDate",
    "uvmsConnection",
    "relaunched",
    "node",
    "queue",
    "priority",
    "numEntry",
    "info"
})
public class ExecutionItem {

    protected ExecutionId ident;
    protected String status;
    protected String beginDate;
    protected String beginHour;
    protected String endDate;
    protected String endHour;
    protected String processingDate;
    protected String uvmsConnection;
    protected boolean relaunched;
    protected String node;
    protected String queue;
    protected String priority;
    protected String numEntry;
    @XmlElement(namespace = "")
    protected String info;

    /**
     * Gets the value of the ident property.
     * 
     * @return
     *     possible object is
     *     {@link ExecutionId }
     *     
     */
    public ExecutionId getIdent() {
        return ident;
    }

    /**
     * Sets the value of the ident property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExecutionId }
     *     
     */
    public void setIdent(ExecutionId value) {
        this.ident = value;
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
     * Gets the value of the relaunched property.
     * 
     */
    public boolean isRelaunched() {
        return relaunched;
    }

    /**
     * Sets the value of the relaunched property.
     * 
     */
    public void setRelaunched(boolean value) {
        this.relaunched = value;
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
     * Gets the value of the numEntry property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumEntry() {
        return numEntry;
    }

    /**
     * Sets the value of the numEntry property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumEntry(String value) {
        this.numEntry = value;
    }

    /**
     * Gets the value of the info property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInfo() {
        return info;
    }

    /**
     * Sets the value of the info property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInfo(String value) {
        this.info = value;
    }

}
