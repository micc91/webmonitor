
package com.example.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for previousLaunch complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="previousLaunch">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="uproc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="numProc" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="launchDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="launchHour" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="type" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "previousLaunch", propOrder = {
    "uproc",
    "numProc",
    "launchDate",
    "launchHour",
    "type"
})
public class PreviousLaunch {

    protected String uproc;
    protected String numProc;
    protected String launchDate;
    protected String launchHour;
    protected String type;

    /**
     * Gets the value of the uproc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUproc() {
        return uproc;
    }

    /**
     * Sets the value of the uproc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUproc(String value) {
        this.uproc = value;
    }

    /**
     * Gets the value of the numProc property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumProc() {
        return numProc;
    }

    /**
     * Sets the value of the numProc property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumProc(String value) {
        this.numProc = value;
    }

    /**
     * Gets the value of the launchDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLaunchDate() {
        return launchDate;
    }

    /**
     * Sets the value of the launchDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLaunchDate(String value) {
        this.launchDate = value;
    }

    /**
     * Gets the value of the launchHour property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getLaunchHour() {
        return launchHour;
    }

    /**
     * Sets the value of the launchHour property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setLaunchHour(String value) {
        this.launchHour = value;
    }

    /**
     * Gets the value of the type property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setType(String value) {
        this.type = value;
    }

}
