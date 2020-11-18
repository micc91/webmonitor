
package com.webops.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getHistoryTrace complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getHistoryTrace">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="context" type="{http://duws.orsyp.com}contextHolder" minOccurs="0" form="qualified"/>
 *         &lt;element name="executionId" type="{http://duws.orsyp.com}executionId" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getHistoryTrace", propOrder = {
    "context",
    "executionId"
})
public class GetHistoryTrace {

    protected ContextHolder context;
    protected ExecutionId executionId;

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

}
