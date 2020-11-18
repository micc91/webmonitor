
package com.webops.duws.proxy;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getListLaunchResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getListLaunchResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="launchList" type="{http://duws.orsyp.com}launchItem" maxOccurs="unbounded" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getListLaunchResponse", propOrder = {
    "launchList"
})
public class GetListLaunchResponse {

    protected List<LaunchItem> launchList;

    /**
     * Gets the value of the launchList property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the launchList property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLaunchList().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link LaunchItem }
     * 
     * 
     */
    public List<LaunchItem> getLaunchList() {
        if (launchList == null) {
            launchList = new ArrayList<LaunchItem>();
        }
        return this.launchList;
    }

}
