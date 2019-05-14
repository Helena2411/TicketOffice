package by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.logic;

import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.entity.AirTicketOfficeContext;
import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.entity.Customer;
import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.exception.BookingException;
import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.util.exception.InputException;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class FlightControllerTest {

    @Test
    public void getAvailableFlightOfNewCustomerByLength() throws FileNotFoundException, BookingException {
        Customer customer = new Customer("Ivan","ivan_ivanov");
        FlightController flightController = new FlightController();
        AirTicketOfficeContext context = AirTicketOfficeContext.getContext();
        AirTicketOfficeContext availableFlight = flightController.getAvailableFlight(customer);
        assertEquals(availableFlight.getFlights().length, context.sizeOfFlight());
    }

    @Test
    public void getAvailableFlightOfExistingCustomerByLength() throws FileNotFoundException, BookingException, InputException {
        CustomerController customerController = new CustomerController();
        int isActual = 1;
        Customer customer = customerController.addNewCustomerOrGetExisting("Matvey","matvey_anisovich");
        FlightController flightController = new FlightController();
        AirTicketOfficeContext availableFlight = flightController.getAvailableFlight(customer);
        assertEquals(availableFlight.getFlights().length, isActual);
    }

    @Test(expected = BookingException.class)
    public void notAvailableFlight() throws FileNotFoundException, BookingException, InputException {
        CustomerController customerController = new CustomerController();
        Customer customer = customerController.addNewCustomerOrGetExisting("Helena","lenka_bokshic");
        FlightController flightController = new FlightController();
        flightController.getAvailableFlight(customer);
    }

    @Test(expected = BookingException.class)
    public void notTicketBookedByCustomer() throws FileNotFoundException, BookingException, InputException {
        Customer customer = new Customer("Ivan","ivan_ivanov");
        FlightController flightController = new FlightController();
        flightController.getFlightsBookedByCustomer(customer);
    }

    @Test
    public void getTicketsBookedExistingCustomerByLength() throws FileNotFoundException, BookingException, InputException {
        CustomerController customerController = new CustomerController();
        int isActual = 2;
        Customer customer = customerController.addNewCustomerOrGetExisting("Helena","lenka_bokshic");
        FlightController flightController = new FlightController();
        AirTicketOfficeContext availableFlight = flightController.getFlightsBookedByCustomer(customer);
        assertEquals(availableFlight.getFlights().length, isActual);
    }
}