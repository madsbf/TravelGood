
package niceview;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "NiceViewFault", targetNamespace = "http://niceView/")
public class NiceViewFault_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private NiceViewFault faultInfo;

    /**
     * 
     * @param message
     * @param faultInfo
     */
    public NiceViewFault_Exception(String message, NiceViewFault faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param message
     * @param faultInfo
     * @param cause
     */
    public NiceViewFault_Exception(String message, NiceViewFault faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: niceview.NiceViewFault
     */
    public NiceViewFault getFaultInfo() {
        return faultInfo;
    }

}
