
package com.webops.duws.proxy;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for runBookNature.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="runBookNature">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="INTERNAL"/>
 *     &lt;enumeration value="EXTERNAL_ASCII"/>
 *     &lt;enumeration value="EXTERNAL_BINARY"/>
 *     &lt;enumeration value="HYPERTEXT_LINK"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "runBookNature")
@XmlEnum
public enum RunBookNature {

    INTERNAL,
    EXTERNAL_ASCII,
    EXTERNAL_BINARY,
    HYPERTEXT_LINK;

    public String value() {
        return name();
    }

    public static RunBookNature fromValue(String v) {
        return valueOf(v);
    }

}
