
package com.webops.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getHistoryTraceResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getHistoryTraceResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://duws.orsyp.com}historyTrace" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getHistoryTraceResponse", propOrder = {
    "historyTrace"
})
public class GetHistoryTraceResponse {

    protected HistoryTrace historyTrace;

    /**
     * Gets the value of the historyTrace property.
     * 
     * @return
     *     possible object is
     *     {@link HistoryTrace }
     *     
     */
    public HistoryTrace getHistoryTrace() {
        return historyTrace;
    }

    /**
     * Sets the value of the historyTrace property.
     * 
     * @param value
     *     allowed object is
     *     {@link HistoryTrace }
     *     
     */
    public void setHistoryTrace(HistoryTrace value) {
        this.historyTrace = value;
    }

}
