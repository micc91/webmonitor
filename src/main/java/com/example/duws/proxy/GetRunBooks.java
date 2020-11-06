
package com.example.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getRunBooks complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getRunBooks">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="context" type="{http://duws.orsyp.com}contextHolder" minOccurs="0" form="qualified"/>
 *         &lt;element ref="{http://duws.orsyp.com}runBookFilter" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getRunBooks", propOrder = {
    "context",
    "runBookFilter"
})
public class GetRunBooks {

    protected ContextHolder context;
    protected RunBookFilter runBookFilter;

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
     * Gets the value of the runBookFilter property.
     * 
     * @return
     *     possible object is
     *     {@link RunBookFilter }
     *     
     */
    public RunBookFilter getRunBookFilter() {
        return runBookFilter;
    }

    /**
     * Sets the value of the runBookFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link RunBookFilter }
     *     
     */
    public void setRunBookFilter(RunBookFilter value) {
        this.runBookFilter = value;
    }

}
