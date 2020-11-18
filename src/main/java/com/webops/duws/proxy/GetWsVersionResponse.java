
package com.webops.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getWsVersionResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getWsVersionResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="version" type="{http://duws.orsyp.com}duwsVersion" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getWsVersionResponse", propOrder = {
    "version"
})
public class GetWsVersionResponse {

    protected DuwsVersion version;

    /**
     * Gets the value of the version property.
     * 
     * @return
     *     possible object is
     *     {@link DuwsVersion }
     *     
     */
    public DuwsVersion getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     * @param value
     *     allowed object is
     *     {@link DuwsVersion }
     *     
     */
    public void setVersion(DuwsVersion value) {
        this.version = value;
    }

}
