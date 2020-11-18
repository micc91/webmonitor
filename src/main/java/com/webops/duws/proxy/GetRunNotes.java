
package com.webops.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getRunNotes complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getRunNotes">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="context" type="{http://duws.orsyp.com}contextHolder" minOccurs="0" form="qualified"/>
 *         &lt;element name="noteFilter" type="{http://duws.orsyp.com}runNoteFilter" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getRunNotes", propOrder = {
    "context",
    "noteFilter"
})
public class GetRunNotes {

    protected ContextHolder context;
    protected RunNoteFilter noteFilter;

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
     * Gets the value of the noteFilter property.
     * 
     * @return
     *     possible object is
     *     {@link RunNoteFilter }
     *     
     */
    public RunNoteFilter getNoteFilter() {
        return noteFilter;
    }

    /**
     * Sets the value of the noteFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link RunNoteFilter }
     *     
     */
    public void setNoteFilter(RunNoteFilter value) {
        this.noteFilter = value;
    }

}
