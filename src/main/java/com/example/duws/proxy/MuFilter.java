
package com.example.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for muFilter complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="muFilter">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="mu" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "muFilter", propOrder = {
    "mu"
})
public class MuFilter {

    protected String mu;

    /**
     * Gets the value of the mu property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMu() {
        return mu;
    }

    /**
     * Sets the value of the mu property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMu(String value) {
        this.mu = value;
    }

}
