
package com.webops.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for deleteOutageWindow complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="deleteOutageWindow">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="context" type="{http://duws.orsyp.com}contextHolder" minOccurs="0" form="qualified"/>
 *         &lt;element name="outage" type="{http://duws.orsyp.com}outageWindow" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteOutageWindow", propOrder = {
    "context",
    "outage"
})
public class DeleteOutageWindow {

    protected ContextHolder context;
    protected OutageWindow outage;

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
     * Gets the value of the outage property.
     * 
     * @return
     *     possible object is
     *     {@link OutageWindow }
     *     
     */
    public OutageWindow getOutage() {
        return outage;
    }

    /**
     * Sets the value of the outage property.
     * 
     * @param value
     *     allowed object is
     *     {@link OutageWindow }
     *     
     */
    public void setOutage(OutageWindow value) {
        this.outage = value;
    }

}
