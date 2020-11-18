
package com.webops.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getListEvent complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getListEvent">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="context" type="{http://duws.orsyp.com}contextHolder" minOccurs="0" form="qualified"/>
 *         &lt;element name="filter" type="{http://duws.orsyp.com}eventFilter" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getListEvent", propOrder = {
    "context",
    "filter"
})
public class GetListEvent {

    protected ContextHolder context;
    protected EventFilter filter;

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
     * Gets the value of the filter property.
     * 
     * @return
     *     possible object is
     *     {@link EventFilter }
     *     
     */
    public EventFilter getFilter() {
        return filter;
    }

    /**
     * Sets the value of the filter property.
     * 
     * @param value
     *     allowed object is
     *     {@link EventFilter }
     *     
     */
    public void setFilter(EventFilter value) {
        this.filter = value;
    }

}
