
package dtu.ws.travelgood.client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "TravelGoodService", targetNamespace = "http://j2ee.netbeans.org/wsdl/TravelGoodBEPL/src/TravelGood", wsdlLocation = "http://localhost:9080/service?wsdl")
public class TravelGoodService
    extends Service
{

    private final static URL TRAVELGOODSERVICE_WSDL_LOCATION;
    private final static WebServiceException TRAVELGOODSERVICE_EXCEPTION;
    private final static QName TRAVELGOODSERVICE_QNAME = new QName("http://j2ee.netbeans.org/wsdl/TravelGoodBEPL/src/TravelGood", "TravelGoodService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9080/service?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TRAVELGOODSERVICE_WSDL_LOCATION = url;
        TRAVELGOODSERVICE_EXCEPTION = e;
    }

    public TravelGoodService() {
        super(__getWsdlLocation(), TRAVELGOODSERVICE_QNAME);
    }

    public TravelGoodService(WebServiceFeature... features) {
        super(__getWsdlLocation(), TRAVELGOODSERVICE_QNAME, features);
    }

    public TravelGoodService(URL wsdlLocation) {
        super(wsdlLocation, TRAVELGOODSERVICE_QNAME);
    }

    public TravelGoodService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TRAVELGOODSERVICE_QNAME, features);
    }

    public TravelGoodService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TravelGoodService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ItineraryPortType
     */
    @WebEndpoint(name = "ItineraryPortTypeBindingPort")
    public ItineraryPortType getItineraryPortTypeBindingPort() {
        return super.getPort(new QName("http://j2ee.netbeans.org/wsdl/TravelGoodBEPL/src/TravelGood", "ItineraryPortTypeBindingPort"), ItineraryPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ItineraryPortType
     */
    @WebEndpoint(name = "ItineraryPortTypeBindingPort")
    public ItineraryPortType getItineraryPortTypeBindingPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://j2ee.netbeans.org/wsdl/TravelGoodBEPL/src/TravelGood", "ItineraryPortTypeBindingPort"), ItineraryPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TRAVELGOODSERVICE_EXCEPTION!= null) {
            throw TRAVELGOODSERVICE_EXCEPTION;
        }
        return TRAVELGOODSERVICE_WSDL_LOCATION;
    }

}
