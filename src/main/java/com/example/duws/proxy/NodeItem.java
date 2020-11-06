
package com.example.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for nodeItem complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="nodeItem">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ident" type="{http://duws.orsyp.com}nodeId" minOccurs="0" form="qualified"/>
 *         &lt;element name="label" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="development" type="{http://www.w3.org/2001/XMLSchema}boolean" form="qualified"/>
 *         &lt;element name="production" type="{http://www.w3.org/2001/XMLSchema}boolean" form="qualified"/>
 *         &lt;element name="centralControl" type="{http://www.w3.org/2001/XMLSchema}boolean" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "nodeItem", propOrder = {
    "ident",
    "label",
    "development",
    "production",
    "centralControl"
})
public class NodeItem {

    protected NodeId ident;
    protected String label;
    protected boolean development;
    protected boolean production;
    protected boolean centralControl;

    /**
     * Gets the value of the ident property.
     * 
     * @return
     *     possible object is
     *     {@link NodeId }
     *     
     */
    public NodeId getIdent() {
        return ident;
    }

    /**
     * Sets the value of the ident property.
     * 
     * @param value
     *     allowed object is
     *     {@link NodeId }
     *     
     */
    public void setIdent(NodeId value) {
        this.ident = value;
    }

    /**
     * Gets the value of the label property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLabel() {
        return label;
    }

    /**
     * Sets the value of the label property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLabel(String value) {
        this.label = value;
    }

    /**
     * Gets the value of the development property.
     * 
     */
    public boolean isDevelopment() {
        return development;
    }

    /**
     * Sets the value of the development property.
     * 
     */
    public void setDevelopment(boolean value) {
        this.development = value;
    }

    /**
     * Gets the value of the production property.
     * 
     */
    public boolean isProduction() {
        return production;
    }

    /**
     * Sets the value of the production property.
     * 
     */
    public void setProduction(boolean value) {
        this.production = value;
    }

    /**
     * Gets the value of the centralControl property.
     * 
     */
    public boolean isCentralControl() {
        return centralControl;
    }

    /**
     * Sets the value of the centralControl property.
     * 
     */
    public void setCentralControl(boolean value) {
        this.centralControl = value;
    }

}
