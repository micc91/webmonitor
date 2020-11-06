
package com.example.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for createOutageWindowResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="createOutageWindowResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
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
@XmlType(name = "createOutageWindowResponse", propOrder = {
    "outage"
})
public class CreateOutageWindowResponse {

    protected OutageWindow outage;

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
