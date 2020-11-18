
package com.webops.duws.proxy;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getRunBooksResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getRunBooksResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="runbooks" type="{http://duws.orsyp.com}runBook" maxOccurs="unbounded" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getRunBooksResponse", propOrder = {
    "runbooks"
})
public class GetRunBooksResponse {

    protected List<RunBook> runbooks;

    /**
     * Gets the value of the runbooks property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the runbooks property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRunbooks().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RunBook }
     * 
     * 
     */
    public List<RunBook> getRunbooks() {
        if (runbooks == null) {
            runbooks = new ArrayList<RunBook>();
        }
        return this.runbooks;
    }

}
