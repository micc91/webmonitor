
package com.webops.duws.proxy;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for execution complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="execution">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="data" type="{http://duws.orsyp.com}executionItem" minOccurs="0" form="qualified"/>
 *         &lt;element name="variables" minOccurs="0" form="qualified">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="variables" type="{http://duws.orsyp.com}variable" maxOccurs="unbounded" minOccurs="0" form="qualified"/>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "execution", propOrder = {
    "data",
    "variables"
})
public class Execution {

    protected ExecutionItem data;
    protected Execution.Variables variables;

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link ExecutionItem }
     *     
     */
    public ExecutionItem getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link ExecutionItem }
     *     
     */
    public void setData(ExecutionItem value) {
        this.data = value;
    }

    /**
     * Gets the value of the variables property.
     * 
     * @return
     *     possible object is
     *     {@link Execution.Variables }
     *     
     */
    public Execution.Variables getVariables() {
        return variables;
    }

    /**
     * Sets the value of the variables property.
     * 
     * @param value
     *     allowed object is
     *     {@link Execution.Variables }
     *     
     */
    public void setVariables(Execution.Variables value) {
        this.variables = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="variables" type="{http://duws.orsyp.com}variable" maxOccurs="unbounded" minOccurs="0" form="qualified"/>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "variables"
    })
    public static class Variables {

        protected List<Variable> variables;

        /**
         * Gets the value of the variables property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the variables property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getVariables().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link Variable }
         * 
         * 
         */
        public List<Variable> getVariables() {
            if (variables == null) {
                variables = new ArrayList<Variable>();
            }
            return this.variables;
        }

    }

}
