
package com.example.duws.proxy;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for sessionNode complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="sessionNode">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="childKO" type="{http://duws.orsyp.com}sessionNode" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="childOK" type="{http://duws.orsyp.com}sessionNode" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="header" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="leaf" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="rankInSession" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="uprocName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "sessionNode", propOrder = {
    "childKO",
    "childOK",
    "header",
    "leaf",
    "rankInSession",
    "uprocName"
})
public class SessionNode {

    @XmlElement(namespace = "", nillable = true)
    protected List<SessionNode> childKO;
    @XmlElement(namespace = "", nillable = true)
    protected List<SessionNode> childOK;
    @XmlElement(namespace = "")
    protected boolean header;
    @XmlElement(namespace = "")
    protected boolean leaf;
    @XmlElement(namespace = "")
    protected int rankInSession;
    @XmlElement(namespace = "")
    protected String uprocName;

    /**
     * Gets the value of the childKO property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the childKO property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChildKO().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SessionNode }
     * 
     * 
     */
    public List<SessionNode> getChildKO() {
        if (childKO == null) {
            childKO = new ArrayList<SessionNode>();
        }
        return this.childKO;
    }

    /**
     * Gets the value of the childOK property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the childOK property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getChildOK().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SessionNode }
     * 
     * 
     */
    public List<SessionNode> getChildOK() {
        if (childOK == null) {
            childOK = new ArrayList<SessionNode>();
        }
        return this.childOK;
    }

    /**
     * Gets the value of the header property.
     * 
     */
    public boolean isHeader() {
        return header;
    }

    /**
     * Sets the value of the header property.
     * 
     */
    public void setHeader(boolean value) {
        this.header = value;
    }

    /**
     * Gets the value of the leaf property.
     * 
     */
    public boolean isLeaf() {
        return leaf;
    }

    /**
     * Sets the value of the leaf property.
     * 
     */
    public void setLeaf(boolean value) {
        this.leaf = value;
    }

    /**
     * Gets the value of the rankInSession property.
     * 
     */
    public int getRankInSession() {
        return rankInSession;
    }

    /**
     * Sets the value of the rankInSession property.
     * 
     */
    public void setRankInSession(int value) {
        this.rankInSession = value;
    }

    /**
     * Gets the value of the uprocName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUprocName() {
        return uprocName;
    }

    /**
     * Sets the value of the uprocName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUprocName(String value) {
        this.uprocName = value;
    }

}
