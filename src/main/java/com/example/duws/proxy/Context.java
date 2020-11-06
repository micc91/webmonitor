
package com.example.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for context complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="context">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="envir" type="{http://duws.orsyp.com}envir" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "context", propOrder = {
    "envir"
})
public class Context {

    @XmlElement(required = true)
    protected Envir envir;

    /**
     * Gets the value of the envir property.
     * 
     * @return
     *     possible object is
     *     {@link Envir }
     *     
     */
    public Envir getEnvir() {
        return envir;
    }

    /**
     * Sets the value of the envir property.
     * 
     * @param value
     *     allowed object is
     *     {@link Envir }
     *     
     */
    public void setEnvir(Envir value) {
        this.envir = value;
    }

}
