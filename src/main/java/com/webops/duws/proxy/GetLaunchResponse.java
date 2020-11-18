
package com.webops.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getLaunchResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getLaunchResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://duws.orsyp.com}launch" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getLaunchResponse", propOrder = {
    "launch"
})
public class GetLaunchResponse {

    protected Launch launch;

    /**
     * Gets the value of the launch property.
     * 
     * @return
     *     possible object is
     *     {@link Launch }
     *     
     */
    public Launch getLaunch() {
        return launch;
    }

    /**
     * Sets the value of the launch property.
     * 
     * @param value
     *     allowed object is
     *     {@link Launch }
     *     
     */
    public void setLaunch(Launch value) {
        this.launch = value;
    }

}
