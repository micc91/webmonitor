
package com.example.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getRunBookExternalFile complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getRunBookExternalFile">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="context" type="{http://duws.orsyp.com}contextHolder" minOccurs="0" form="qualified"/>
 *         &lt;element ref="{http://duws.orsyp.com}runBook" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getRunBookExternalFile", propOrder = {
    "context",
    "runBook"
})
public class GetRunBookExternalFile {

    protected ContextHolder context;
    protected RunBook runBook;

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
     * Gets the value of the runBook property.
     * 
     * @return
     *     possible object is
     *     {@link RunBook }
     *     
     */
    public RunBook getRunBook() {
        return runBook;
    }

    /**
     * Sets the value of the runBook property.
     * 
     * @param value
     *     allowed object is
     *     {@link RunBook }
     *     
     */
    public void setRunBook(RunBook value) {
        this.runBook = value;
    }

}
