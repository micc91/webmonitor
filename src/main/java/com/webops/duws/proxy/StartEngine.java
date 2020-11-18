
package com.webops.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for startEngine complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="startEngine">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="context" type="{http://duws.orsyp.com}contextHolder" minOccurs="0" form="qualified"/>
 *         &lt;element ref="{http://duws.orsyp.com}engine" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "startEngine", propOrder = {
    "context",
    "engine"
})
public class StartEngine {

    protected ContextHolder context;
    protected Engine engine;

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
     * Gets the value of the engine property.
     * 
     * @return
     *     possible object is
     *     {@link Engine }
     *     
     */
    public Engine getEngine() {
        return engine;
    }

    /**
     * Sets the value of the engine property.
     * 
     * @param value
     *     allowed object is
     *     {@link Engine }
     *     
     */
    public void setEngine(Engine value) {
        this.engine = value;
    }

}
