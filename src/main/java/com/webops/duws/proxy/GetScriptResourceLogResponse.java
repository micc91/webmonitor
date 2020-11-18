
package com.webops.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getScriptResourceLogResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getScriptResourceLogResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://duws.orsyp.com}resourceLog" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getScriptResourceLogResponse", propOrder = {
    "resourceLog"
})
public class GetScriptResourceLogResponse {

    protected ResourceLog resourceLog;

    /**
     * Gets the value of the resourceLog property.
     * 
     * @return
     *     possible object is
     *     {@link ResourceLog }
     *     
     */
    public ResourceLog getResourceLog() {
        return resourceLog;
    }

    /**
     * Sets the value of the resourceLog property.
     * 
     * @param value
     *     allowed object is
     *     {@link ResourceLog }
     *     
     */
    public void setResourceLog(ResourceLog value) {
        this.resourceLog = value;
    }

}
