
package lameduck;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;
import dk.dtu.imm.fastmoney.types.CreditCardInfoType;


/**
 * <p>Java class for bookFlight complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="bookFlight">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="bookingNumber" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="creditCard" type="{urn://types.fastmoney.imm.dtu.dk}creditCardInfoType" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "bookFlight", propOrder = {
    "bookingNumber",
    "creditCard"
})
public class BookFlight {

    protected int bookingNumber;
    protected CreditCardInfoType creditCard;

    /**
     * Gets the value of the bookingNumber property.
     * 
     */
    public int getBookingNumber() {
        return bookingNumber;
    }

    /**
     * Sets the value of the bookingNumber property.
     * 
     */
    public void setBookingNumber(int value) {
        this.bookingNumber = value;
    }

    /**
     * Gets the value of the creditCard property.
     * 
     * @return
     *     possible object is
     *     {@link CreditCardInfoType }
     *     
     */
    public CreditCardInfoType getCreditCard() {
        return creditCard;
    }

    /**
     * Sets the value of the creditCard property.
     * 
     * @param value
     *     allowed object is
     *     {@link CreditCardInfoType }
     *     
     */
    public void setCreditCard(CreditCardInfoType value) {
        this.creditCard = value;
    }

}
