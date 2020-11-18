
package com.webops.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for deleteLaunch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="deleteLaunch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="context" type="{http://duws.orsyp.com}contextHolder" minOccurs="0" form="qualified"/>
 *         &lt;element ref="{http://duws.orsyp.com}launchId" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "deleteLaunch", propOrder = {
    "context",
    "launchId"
})
public class DeleteLaunch {

    protected ContextHolder context;
    protected LaunchId launchId;

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
     * Gets the value of the launchId property.
     * 
     * @return
     *     possible object is
     *     {@link LaunchId }
     *     
     */
    public LaunchId getLaunchId() {
        return launchId;
    }

    /**
     * Sets the value of the launchId property.
     * 
     * @param value
     *     allowed object is
     *     {@link LaunchId }
     *     
     */
    public void setLaunchId(LaunchId value) {
        this.launchId = value;
    }

}
