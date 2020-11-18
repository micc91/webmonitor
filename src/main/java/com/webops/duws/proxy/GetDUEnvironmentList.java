
package com.webops.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getDUEnvironmentList complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getDUEnvironmentList">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="nodeFilter" type="{http://duws.orsyp.com}uvmsNodeFilter" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDUEnvironmentList", propOrder = {
    "token",
    "nodeFilter"
})
public class GetDUEnvironmentList {

    protected String token;
    protected UvmsNodeFilter nodeFilter;

    /**
     * Gets the value of the token property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * Gets the value of the nodeFilter property.
     * 
     * @return
     *     possible object is
     *     {@link UvmsNodeFilter }
     *     
     */
    public UvmsNodeFilter getNodeFilter() {
        return nodeFilter;
    }

    /**
     * Sets the value of the nodeFilter property.
     * 
     * @param value
     *     allowed object is
     *     {@link UvmsNodeFilter }
     *     
     */
    public void setNodeFilter(UvmsNodeFilter value) {
        this.nodeFilter = value;
    }

}
