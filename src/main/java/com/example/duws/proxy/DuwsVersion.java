
package com.example.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for duwsVersion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="duwsVersion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="version" type="{http://www.w3.org/2001/XMLSchema}int" form="qualified"/>
 *         &lt;element name="build" type="{http://www.w3.org/2001/XMLSchema}int" form="qualified"/>
 *         &lt;element name="fullVersion" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "duwsVersion", propOrder = {
    "version",
    "build",
    "fullVersion"
})
public class DuwsVersion {

    protected int version;
    protected int build;
    protected String fullVersion;

    /**
     * Gets the value of the version property.
     * 
     */
    public int getVersion() {
        return version;
    }

    /**
     * Sets the value of the version property.
     * 
     */
    public void setVersion(int value) {
        this.version = value;
    }

    /**
     * Gets the value of the build property.
     * 
     */
    public int getBuild() {
        return build;
    }

    /**
     * Sets the value of the build property.
     * 
     */
    public void setBuild(int value) {
        this.build = value;
    }

    /**
     * Gets the value of the fullVersion property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFullVersion() {
        return fullVersion;
    }

    /**
     * Sets the value of the fullVersion property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFullVersion(String value) {
        this.fullVersion = value;
    }

}
