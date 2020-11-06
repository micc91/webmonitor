
package com.example.duws.proxy;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for envirStatus.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="envirStatus">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="CONNECTING"/>
 *     &lt;enumeration value="CONNECTED"/>
 *     &lt;enumeration value="FAILED"/>
 *     &lt;enumeration value="BROKEN"/>
 *     &lt;enumeration value="STOPPED"/>
 *     &lt;enumeration value="UNREACHABLE"/>
 *     &lt;enumeration value="NODE_UNREACHABLE"/>
 *     &lt;enumeration value="IO_UNREACHABLE"/>
 *     &lt;enumeration value="CONNECTED_WARNING"/>
 *     &lt;enumeration value="UNKNOWN"/>
 *     &lt;enumeration value="NO_UPWARDS_MESSAGE"/>
 *     &lt;enumeration value="BEING_COMPUTED"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "envirStatus")
@XmlEnum
public enum EnvirStatus {

    CONNECTING,
    CONNECTED,
    FAILED,
    BROKEN,
    STOPPED,
    UNREACHABLE,
    NODE_UNREACHABLE,
    IO_UNREACHABLE,
    CONNECTED_WARNING,
    UNKNOWN,
    NO_UPWARDS_MESSAGE,
    BEING_COMPUTED;

    public String value() {
        return name();
    }

    public static EnvirStatus fromValue(String v) {
        return valueOf(v);
    }

}
