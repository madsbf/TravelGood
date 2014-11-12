 /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import model.BookingItem;
import model.BookingItem.BookingStatus;
import model.Flight;
import model.Hotel;
import model.Itinerary;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Rule;
import org.junit.rules.ExpectedException;
import ws.travelgood.ItineraryResource.BookingException;
import ws.travelgood.ItineraryResource.CancelException;

/**
 *
 * @author Mads
 */
public class TestItineraryResource {

    public TestItineraryResource() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testP1() {
        Client client = Client.create();

        String itineraryId = createItinerary(client);
        addRandomFlightToItinerary(client, itineraryId, "Copenhagen", "London", "27-12-2014");
        addRandomHotelToItinerary(client, itineraryId, "London", "27-12-2014", "29-12-2014");
        addRandomFlightToItinerary(client, itineraryId, "London", "Paris", "29-12-2014");
        addRandomFlightToItinerary(client, itineraryId, "Paris", "Copenhagen", "3-1-2015");
        addRandomHotelToItinerary(client, itineraryId, "Copenhagen", "3-1-2015", "8-1-2015");
        Itinerary itinerary = getItinerary(client, itineraryId);

        // Assert, that all flights are unconfirmed
        for (BookingItem bookingItem : itinerary.getFlights()) {
            assertEquals(bookingItem.getBookingStatus(), BookingStatus.UNCONFIRMED);
        }

        // Assert, that all hotels are unconfirmed
        for (BookingItem bookingItem : itinerary.getHotels()) {
            assertEquals(bookingItem.getBookingStatus(), BookingStatus.UNCONFIRMED);
        }
        
        // TODO: Add assertions for flight and hotel data
    }

    @Test
    public void testP2() throws CancelException {
        Client client = Client.create();

        String itineraryId = createItinerary(client);
        addRandomFlightToItinerary(client, itineraryId, "Copenhagen", "London", "27-12-2014");
        cancelItinerary(client, itineraryId);

        // TODO: Add assertions
    }
    
    @Test
    public void testB() {
        Client client = Client.create();

        String itineraryId = createItinerary(client);

        addRandomFlightToItinerary(client, itineraryId, "Copenhagen", "London", "27-12-2014");
        addRandomHotelToItinerary(client, itineraryId, "London", "27-12-2014", "29-12-2014");
        addRandomFlightToItinerary(client, itineraryId, "London", "Paris", "29-12-2014");

        Itinerary itinerary = getItinerary(client, itineraryId);

        // Assert, that all flights are unconfirmed
        for (BookingItem bookingItem : itinerary.getFlights()) {
            assertEquals(bookingItem.getBookingStatus(), BookingStatus.UNCONFIRMED);
        }

        // Assert, that all hotels are unconfirmed
        for (BookingItem bookingItem : itinerary.getHotels()) {
            assertEquals(bookingItem.getBookingStatus(), BookingStatus.UNCONFIRMED);
        }

        try {
            bookItinerary(client, itineraryId);
            fail("BookingException not thrown");
        } catch(BookingException exception) {
            itinerary = getItinerary(client, itineraryId);
            assertEquals(itinerary.getFlights()[0].getBookingStatus(), BookingStatus.CANCELLED);
            assertEquals(itinerary.getHotels()[0].getBookingStatus(), BookingStatus.UNCONFIRMED);
            assertEquals(itinerary.getFlights()[1].getBookingStatus(), BookingStatus.UNCONFIRMED);
        }
    }

    @Test
    public void testC1() throws BookingException, CancelException {
        Client client = Client.create();

        String itineraryId = createItinerary(client);
        addRandomFlightToItinerary(client, itineraryId, "Copenhagen", "London", "27-12-2014");
        addRandomHotelToItinerary(client, itineraryId, "London", "27-12-2014", "29-12-2014");
        addRandomFlightToItinerary(client, itineraryId, "London", "Paris", "29-12-2014");
        bookItinerary(client, itineraryId);
        Itinerary itinerary = getItinerary(client, itineraryId);

        // Assert, that all flights are confirmed
        for (BookingItem bookingItem : itinerary.getFlights()) {
            assertEquals(bookingItem.getBookingStatus(), BookingStatus.CONFIRMED);
        }

        // Assert, that all hotels are confirmed
        for (BookingItem bookingItem : itinerary.getHotels()) {
            assertEquals(bookingItem.getBookingStatus(), BookingStatus.CONFIRMED);
        }

        cancelItinerary(client, itineraryId);
        itinerary = getItinerary(client, itineraryId);

        // Assert, that all flights are cancelled
        for (BookingItem bookingItem : itinerary.getFlights()) {
            assertEquals(bookingItem.getBookingStatus(), BookingStatus.CANCELLED);
        }

        // Assert, that all hotels are cancelled
        for (BookingItem bookingItem : itinerary.getHotels()) {
            assertEquals(bookingItem.getBookingStatus(), BookingStatus.CANCELLED);
        }
    }

    @Test
    public void testC2() throws BookingException {
        Client client = Client.create();

        String itineraryId = createItinerary(client);
        addRandomFlightToItinerary(client, itineraryId, "Copenhagen", "London", "27-12-2014");
        addRandomHotelToItinerary(client, itineraryId, "London", "27-12-2014", "29-12-2014");
        addRandomFlightToItinerary(client, itineraryId, "London", "Paris", "29-12-2014");
        bookItinerary(client, itineraryId);
        Itinerary itinerary = getItinerary(client, itineraryId);

        // Assert, that all flights are confirmed
        for (BookingItem bookingItem : itinerary.getFlights()) {
            assertEquals(bookingItem.getBookingStatus(), BookingStatus.CONFIRMED);
        }

        // Assert, that all hotels are confirmed
        for (BookingItem bookingItem : itinerary.getHotels()) {
            assertEquals(bookingItem.getBookingStatus(), BookingStatus.CONFIRMED);
        }

        try {
            cancelItinerary(client, itineraryId);
            fail("CancelException not thrown");
        } catch(CancelException e) {
            itinerary = getItinerary(client, itineraryId);
            
            assertEquals(itinerary.getFlights()[0].getBookingStatus(), BookingStatus.CANCELLED);
            assertEquals(itinerary.getHotels()[0].getBookingStatus(), BookingStatus.CONFIRMED);
            assertEquals(itinerary.getFlights()[1].getBookingStatus(), BookingStatus.CANCELLED);
        }
    }

    private void bookItinerary(Client client, String itineraryId) throws BookingException {
        WebResource resourceBookItinerary = client.resource("http://localhost:8080/TravelGoodTestRest/webresources/itineraries/"
                + itineraryId
                + "/book");
        resourceBookItinerary.post();
    }

    private void cancelItinerary(Client client, String itineraryId) throws CancelException {
        WebResource resourceCancelItinerary = client.resource("http://localhost:8080/TravelGoodTestRest/webresources/itineraries/"
                + itineraryId);
        resourceCancelItinerary.delete();
    }

    private String createItinerary(Client client) {
        WebResource resourceCreateItinerary = client.resource("http://localhost:8080/TravelGoodTestRest/webresources/itineraries/");
        return resourceCreateItinerary.post(String.class);
    }

    private Itinerary getItinerary(Client client, String itineraryId) {
        WebResource resourceGetItinerary = client.resource("http://localhost:8080/TravelGoodTestRest/webresources/itineraries/"
                + itineraryId);
        return resourceGetItinerary.get(Itinerary.class);
    }

    private void addRandomFlightToItinerary(Client client, String itineraryId, String origin, String destination, String departureDate) {
        Flight[] flights = getFlights(client, origin, destination, departureDate);

        // Randomly picks a flight from the array, and adds it to the itinerary
        int randomIndex = new Random().nextInt(flights.length);
        addFlightToItinerary(client, itineraryId, flights[randomIndex]);
    }

    private Flight[] getFlights(Client client, String origin, String destination, String departureDate) {
        WebResource resourceFlights = client.resource("http://localhost:8080/TravelGoodTestRest/webresources/flights/"
                + "?departureLocation=" + origin
                + "&arrivalLocation=" + destination
                + "&departureDate=" + departureDate);
        return resourceFlights.get(Flight[].class);
    }

    private void addFlightToItinerary(Client client, String itineraryId, Flight flight) {
        WebResource addFlightResource = client.resource("http://localhost:8080/TravelGoodTestRest/webresources/itineraries/"
                + itineraryId
                + "/flights");
        addFlightResource.put(flight.getBookingId());
    }

    private void addRandomHotelToItinerary(Client client, String itineraryId, String location, String arrivalDate, String departureDate) {
        Hotel[] hotels = getHotels(client, itineraryId, location, arrivalDate, departureDate);

        // Randomly picks a hotel from the array, and adds it to the itinerary
        int randomIndex = new Random().nextInt(hotels.length);
        addHotelToItinerary(client, itineraryId, hotels[randomIndex]);
    }

    private Hotel[] getHotels(Client client, String itineraryId, String location, String arrivalDate, String departureDate) {
        WebResource resourceFlights = client.resource("http://localhost:8080/TravelGoodTestRest/webresources/hotels/"
                + "?location=" + location
                + "&arrivalDate=" + arrivalDate
                + "&departureDate=" + departureDate);
        return resourceFlights.get(Hotel[].class);
    }

    private void addHotelToItinerary(Client client, String itineraryId, Hotel hotel) {
        WebResource addFlightResource = client.resource("http://localhost:8080/TravelGoodTestRest/webresources/itineraries/"
                + itineraryId
                + "/hotels");
        addFlightResource.put(hotel.getBookingId());
    }
}