
package com.example.duws.proxy;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getListUprocResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getListUprocResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="uprocList" type="{http://duws.orsyp.com}uprocItem" maxOccurs="unbounded" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getListUprocResponse", propOrder = {
    "uprocList"
})
public class GetListUprocResponse {

    protected List<UprocItem> uprocList;

    /**
     * Gets the value of the uprocList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the uprocList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getUprocList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link UprocItem }
     * 
     * 
     */
    public List<UprocItem> getUprocList() {
        if (uprocList == null) {
            uprocList = new ArrayList<UprocItem>();
        }
        return this.uprocList;
    }

}
