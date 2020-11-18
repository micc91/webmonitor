
package com.webops.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for holdLaunch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="holdLaunch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="context" type="{http://duws.orsyp.com}contextHolder" minOccurs="0" form="qualified"/>
 *         &lt;element name="launch" type="{http://duws.orsyp.com}launchId" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "holdLaunch", propOrder = {
    "context",
    "launch"
})
public class HoldLaunch {

    protected ContextHolder context;
    protected LaunchId launch;

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
     * Gets the value of the launch property.
     * 
     * @return
     *     possible object is
     *     {@link LaunchId }
     *     
     */
    public LaunchId getLaunch() {
        return launch;
    }

    /**
     * Sets the value of the launch property.
     * 
     * @param value
     *     allowed object is
     *     {@link LaunchId }
     *     
     */
    public void setLaunch(LaunchId value) {
        this.launch = value;
    }

}
