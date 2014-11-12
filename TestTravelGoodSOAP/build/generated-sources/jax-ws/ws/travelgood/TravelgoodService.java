
package ws.travelgood;

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
@WebServiceClient(name = "travelgoodService", targetNamespace = "http://travelgood.ws", wsdlLocation = "http://localhost:9070/travelgoodService/travelgoodPort?wsdl")
public class TravelgoodService
    extends Service
{

    private final static URL TRAVELGOODSERVICE_WSDL_LOCATION;
    private final static WebServiceException TRAVELGOODSERVICE_EXCEPTION;
    private final static QName TRAVELGOODSERVICE_QNAME = new QName("http://travelgood.ws", "travelgoodService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:9070/travelgoodService/travelgoodPort?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        TRAVELGOODSERVICE_WSDL_LOCATION = url;
        TRAVELGOODSERVICE_EXCEPTION = e;
    }

    public TravelgoodService() {
        super(__getWsdlLocation(), TRAVELGOODSERVICE_QNAME);
    }

    public TravelgoodService(WebServiceFeature... features) {
        super(__getWsdlLocation(), TRAVELGOODSERVICE_QNAME, features);
    }

    public TravelgoodService(URL wsdlLocation) {
        super(wsdlLocation, TRAVELGOODSERVICE_QNAME);
    }

    public TravelgoodService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, TRAVELGOODSERVICE_QNAME, features);
    }

    public TravelgoodService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public TravelgoodService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns ItineraryPortType
     */
    @WebEndpoint(name = "itineraryPortTypeBindingPort")
    public ItineraryPortType getItineraryPortTypeBindingPort() {
        return super.getPort(new QName("http://travelgood.ws", "itineraryPortTypeBindingPort"), ItineraryPortType.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns ItineraryPortType
     */
    @WebEndpoint(name = "itineraryPortTypeBindingPort")
    public ItineraryPortType getItineraryPortTypeBindingPort(WebServiceFeature... features) {
        return super.getPort(new QName("http://travelgood.ws", "itineraryPortTypeBindingPort"), ItineraryPortType.class, features);
    }

    private static URL __getWsdlLocation() {
        if (TRAVELGOODSERVICE_EXCEPTION!= null) {
            throw TRAVELGOODSERVICE_EXCEPTION;
        }
        return TRAVELGOODSERVICE_WSDL_LOCATION;
    }

}
