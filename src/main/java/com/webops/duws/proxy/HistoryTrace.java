
package com.webops.duws.proxy;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for historyTrace complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="historyTrace">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ident" type="{http://duws.orsyp.com}executionId" minOccurs="0" form="qualified"/>
 *         &lt;element name="uprocLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="sessionLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="muLabel" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="trace" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "historyTrace", propOrder = {
    "ident",
    "uprocLabel",
    "sessionLabel",
    "muLabel",
    "trace"
})
public class HistoryTrace {

    protected ExecutionId ident;
    protected String uprocLabel;
    protected String sessionLabel;
    protected String muLabel;
    protected List<String> trace;

    /**
     * Gets the value of the ident property.
     * 
     * @return
     *     possible object is
     *     {@link ExecutionId }
     *     
     */
    public ExecutionId getIdent() {
        return ident;
    }

    /**
     * Sets the value of the ident property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExecutionId }
     *     
     */
    public void setIdent(ExecutionId value) {
        this.ident = value;
    }

    /**
     * Gets the value of the uprocLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUprocLabel() {
        return uprocLabel;
    }

    /**
     * Sets the value of the uprocLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUprocLabel(String value) {
        this.uprocLabel = value;
    }

    /**
     * Gets the value of the sessionLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSessionLabel() {
        return sessionLabel;
    }

    /**
     * Sets the value of the sessionLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSessionLabel(String value) {
        this.sessionLabel = value;
    }

    /**
     * Gets the value of the muLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMuLabel() {
        return muLabel;
    }

    /**
     * Sets the value of the muLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMuLabel(String value) {
        this.muLabel = value;
    }

    /**
     * Gets the value of the trace property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the trace property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTrace().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getTrace() {
        if (trace == null) {
            trace = new ArrayList<String>();
        }
        return this.trace;
    }

}
