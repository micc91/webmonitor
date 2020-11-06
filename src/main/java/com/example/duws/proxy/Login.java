
package com.example.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for login complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="login">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="uvms" type="{http://duws.orsyp.com}uvmsContext" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "login", propOrder = {
    "uvms"
})
public class Login {

    protected UvmsContext uvms;

    /**
     * Gets the value of the uvms property.
     * 
     * @return
     *     possible object is
     *     {@link UvmsContext }
     *     
     */
    public UvmsContext getUvms() {
        return uvms;
    }

    /**
     * Sets the value of the uvms property.
     * 
     * @param value
     *     allowed object is
     *     {@link UvmsContext }
     *     
     */
    public void setUvms(UvmsContext value) {
        this.uvms = value;
    }

}
