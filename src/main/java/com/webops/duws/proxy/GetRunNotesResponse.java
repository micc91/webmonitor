
package com.webops.duws.proxy;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getRunNotesResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getRunNotesResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="runNotes" type="{http://duws.orsyp.com}runNote" maxOccurs="unbounded" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getRunNotesResponse", propOrder = {
    "runNotes"
})
public class GetRunNotesResponse {

    protected List<RunNote> runNotes;

    /**
     * Gets the value of the runNotes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the runNotes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRunNotes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RunNote }
     * 
     * 
     */
    public List<RunNote> getRunNotes() {
        if (runNotes == null) {
            runNotes = new ArrayList<RunNote>();
        }
        return this.runNotes;
    }

}
