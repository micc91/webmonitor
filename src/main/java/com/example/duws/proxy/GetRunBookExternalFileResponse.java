
package com.example.duws.proxy;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getRunBookExternalFileResponse complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getRunBookExternalFileResponse">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fileDataHandler" type="{http://www.w3.org/2001/XMLSchema}base64Binary" minOccurs="0" form="qualified"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getRunBookExternalFileResponse", propOrder = {
    "fileDataHandler"
})
public class GetRunBookExternalFileResponse {

    protected byte[] fileDataHandler;

    /**
     * Gets the value of the fileDataHandler property.
     * 
     * @return
     *     possible object is
     *     byte[]
     */
    public byte[] getFileDataHandler() {
        return fileDataHandler;
    }

    /**
     * Sets the value of the fileDataHandler property.
     * 
     * @param value
     *     allowed object is
     *     byte[]
     */
    public void setFileDataHandler(byte[] value) {
        this.fileDataHandler = value;
    }

}
