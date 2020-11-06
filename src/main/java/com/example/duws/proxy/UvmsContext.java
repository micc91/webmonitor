
package com.example.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for uvmsContext complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="uvmsContext">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="uvmsHost" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="uvmsPort" type="{http://www.w3.org/2001/XMLSchema}int" form="qualified"/>
 *         &lt;element name="uvmsUser" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="uvmsPassword" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "uvmsContext", propOrder = {
    "uvmsHost",
    "uvmsPort",
    "uvmsUser",
    "uvmsPassword"
})
public class UvmsContext {

    protected String uvmsHost;
    protected int uvmsPort;
    protected String uvmsUser;
    protected String uvmsPassword;

    /**
     * Gets the value of the uvmsHost property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUvmsHost() {
        return uvmsHost;
    }

    /**
     * Sets the value of the uvmsHost property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUvmsHost(String value) {
        this.uvmsHost = value;
    }

    /**
     * Gets the value of the uvmsPort property.
     * 
     */
    public int getUvmsPort() {
        return uvmsPort;
    }

    /**
     * Sets the value of the uvmsPort property.
     * 
     */
    public void setUvmsPort(int value) {
        this.uvmsPort = value;
    }

    /**
     * Gets the value of the uvmsUser property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUvmsUser() {
        return uvmsUser;
    }

    /**
     * Sets the value of the uvmsUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUvmsUser(String value) {
        this.uvmsUser = value;
    }

    /**
     * Gets the value of the uvmsPassword property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUvmsPassword() {
        return uvmsPassword;
    }

    /**
     * Sets the value of the uvmsPassword property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUvmsPassword(String value) {
        this.uvmsPassword = value;
    }

}
