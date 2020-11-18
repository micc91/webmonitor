
package com.webops.duws.proxy;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getDUEnvironmentListResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getDUEnvironmentListResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="envList" type="{http://duws.orsyp.com}envir" maxOccurs="unbounded" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDUEnvironmentListResponse", propOrder = {
    "envList"
})
public class GetDUEnvironmentListResponse {

    protected List<Envir> envList;

    /**
     * Gets the value of the envList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the envList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getEnvList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Envir }
     * 
     * 
     */
    public List<Envir> getEnvList() {
        if (envList == null) {
            envList = new ArrayList<Envir>();
        }
        return this.envList;
    }

}
