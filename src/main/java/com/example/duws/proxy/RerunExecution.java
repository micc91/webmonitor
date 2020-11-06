
package com.example.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for rerunExecution complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="rerunExecution">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="context" type="{http://duws.orsyp.com}contextHolder" minOccurs="0" form="qualified"/>
 *         &lt;element name="executionId" type="{http://duws.orsyp.com}executionId" minOccurs="0" form="qualified"/>
 *         &lt;element name="startDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="endDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="batchQueue" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="uvmsConnection" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="step" type="{http://www.w3.org/2001/XMLSchema}int" form="qualified"/>
 *         &lt;element name="byPassCheck" type="{http://www.w3.org/2001/XMLSchema}boolean" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rerunExecution", propOrder = {
    "context",
    "executionId",
    "startDate",
    "endDate",
    "batchQueue",
    "uvmsConnection",
    "step",
    "byPassCheck"
})
public class RerunExecution {

    protected ContextHolder context;
    protected ExecutionId executionId;
    protected String startDate;
    protected String endDate;
    protected String batchQueue;
    protected String uvmsConnection;
    protected int step;
    protected boolean byPassCheck;

    /**
     * Gets the value of the context property.
     * 
     * @return
     *     possible object is
     *     {@link ContextHolder }
     *     
     */
    public ContextHolder getContext() {
        return context;
    }

    /**
     * Sets the value of the context property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContextHolder }
     *     
     */
    public void setContext(ContextHolder value) {
        this.context = value;
    }

    /**
     * Gets the value of the executionId property.
     * 
     * @return
     *     possible object is
     *     {@link ExecutionId }
     *     
     */
    public ExecutionId getExecutionId() {
        return executionId;
    }

    /**
     * Sets the value of the executionId property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExecutionId }
     *     
     */
    public void setExecutionId(ExecutionId value) {
        this.executionId = value;
    }

    /**
     * Gets the value of the startDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * Sets the value of the startDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setStartDate(String value) {
        this.startDate = value;
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
     * Gets the value of the batchQueue property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getBatchQueue() {
        return batchQueue;
    }

    /**
     * Sets the value of the batchQueue property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setBatchQueue(String value) {
        this.batchQueue = value;
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
     */
    public int getStep() {
        return step;
    }

    /**
     * Sets the value of the step property.
     * 
     */
    public void setStep(int value) {
        this.step = value;
    }

    /**
     * Gets the value of the byPassCheck property.
     * 
     */
    public boolean isByPassCheck() {
        return byPassCheck;
    }

    /**
     * Sets the value of the byPassCheck property.
     * 
     */
    public void setByPassCheck(boolean value) {
        this.byPassCheck = value;
    }

}
