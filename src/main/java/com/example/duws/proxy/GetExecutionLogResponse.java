
package com.example.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getExecutionLogResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getExecutionLogResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://duws.orsyp.com}executionLog" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getExecutionLogResponse", propOrder = {
    "executionLog"
})
public class GetExecutionLogResponse {

    protected ExecutionLog executionLog;

    /**
     * Gets the value of the executionLog property.
     * 
     * @return
     *     possible object is
     *     {@link ExecutionLog }
     *     
     */
    public ExecutionLog getExecutionLog() {
        return executionLog;
    }

    /**
     * Sets the value of the executionLog property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExecutionLog }
     *     
     */
    public void setExecutionLog(ExecutionLog value) {
        this.executionLog = value;
    }

}
