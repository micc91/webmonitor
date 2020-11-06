
package com.example.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for runNote complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="runNote">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="creationDate" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *         &lt;element name="numproc" type="{http://www.w3.org/2001/XMLSchema}int" form="qualified"/>
 *         &lt;element name="numlanc" type="{http://www.w3.org/2001/XMLSchema}int" form="qualified"/>
 *         &lt;element name="noteText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "runNote", propOrder = {
    "creationDate",
    "numproc",
    "numlanc",
    "noteText"
})
public class RunNote {

    protected String creationDate;
    protected int numproc;
    protected int numlanc;
    protected String noteText;

    /**
     * Gets the value of the creationDate property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCreationDate() {
        return creationDate;
    }

    /**
     * Sets the value of the creationDate property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCreationDate(String value) {
        this.creationDate = value;
    }

    /**
     * Gets the value of the numproc property.
     * 
     */
    public int getNumproc() {
        return numproc;
    }

    /**
     * Sets the value of the numproc property.
     * 
     */
    public void setNumproc(int value) {
        this.numproc = value;
    }

    /**
     * Gets the value of the numlanc property.
     * 
     */
    public int getNumlanc() {
        return numlanc;
    }

    /**
     * Sets the value of the numlanc property.
     * 
     */
    public void setNumlanc(int value) {
        this.numlanc = value;
    }

    /**
     * Gets the value of the noteText property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNoteText() {
        return noteText;
    }

    /**
     * Sets the value of the noteText property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNoteText(String value) {
        this.noteText = value;
    }

}
