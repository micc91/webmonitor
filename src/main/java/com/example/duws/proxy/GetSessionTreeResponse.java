
package com.example.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getSessionTreeResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getSessionTreeResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://duws.orsyp.com}sessionTree" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getSessionTreeResponse", propOrder = {
    "sessionTree"
})
public class GetSessionTreeResponse {

    protected SessionTree sessionTree;

    /**
     * Gets the value of the sessionTree property.
     * 
     * @return
     *     possible object is
     *     {@link SessionTree }
     *     
     */
    public SessionTree getSessionTree() {
        return sessionTree;
    }

    /**
     * Sets the value of the sessionTree property.
     * 
     * @param value
     *     allowed object is
     *     {@link SessionTree }
     *     
     */
    public void setSessionTree(SessionTree value) {
        this.sessionTree = value;
    }

}
