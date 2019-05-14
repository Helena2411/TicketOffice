package by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.logic;

import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.entity.AirTicketOfficeContext;
import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.entity.Customer;
import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.entity.Flight;
import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.exception.BookingException;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class FlightController {
    private static final Logger LOG;

    private static AirTicketOfficeContext context;

    static{
        LOG = Logger.getLogger(by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.logic.FlightController.class);
    }

    public FlightController() throws FileNotFoundException {
        context = AirTicketOfficeContext.getContext();
    }

    public AirTicketOfficeContext getAvailableFlight(Customer customer) throws BookingException {
        AirTicketOfficeContext availableFlight = new AirTicketOfficeContext();

        for (int i = 0; i < context.sizeOfFlight(); i++) {
            boolean isEmpty = true;
            String[] customersId = context.getFlightByIndex(i).getCustomersId();
            if(context.getFlightByIndex(i).getCustomersId().length == 0) {
                availableFlight.setFlights(addFlightToArray(availableFlight, i).getFlights());
                isEmpty = false;
            }
            for(int j =0; j < context.getFlightByIndex(i).getCustomersId().length; j++) {
                if (customer.getId().equals(customersId[j])) {
                    isEmpty = false;
                }
            }
            if(isEmpty){
                availableFlight.setFlights(addFlightToArray(availableFlight, i).getFlights());
            }
        }
        if (availableFlight.getFlights().length == 0) {
            throw new BookingException("You haven't available flight. Sorry(");
        }
        LOG.info("Got list of available flights");
        return availableFlight;
    }

    public AirTicketOfficeContext getFlightsBookedByCustomer(Customer customer) throws BookingException {
        AirTicketOfficeContext occupiedCars = new AirTicketOfficeContext();
        for (int i = 0; i < context.sizeOfFlight(); i++) {
            String[] customersId = context.getFlightByIndex(i).getCustomersId();
            for (int j = 0; j < context.getFlightByIndex(i).getCustomersId().length; j++) {
                if (customer.getId().equals(customersId[j])) {
                    occupiedCars.setFlights(addFlightToArray(occupiedCars, i).getFlights());
                    break;
                }
            }
        }
        if (occupiedCars.getFlights().length == 0) {
            throw new BookingException("You haven't booked flight.");
        }
        LOG.info("Got list of booked by customer flights");
        return occupiedCars;
    }
    private AirTicketOfficeContext addFlightToArray(AirTicketOfficeContext airTicketOfficeContext, int index) {
        airTicketOfficeContext.setFlights(Arrays.copyOf(airTicketOfficeContext.getFlights(),
                airTicketOfficeContext.getFlights().length + 1));
        airTicketOfficeContext.getFlights()[airTicketOfficeContext.getFlights().length - 1] =
                context.getFlightByIndex(index);
        return airTicketOfficeContext;
    }

    public void bookTicket(Flight flight, Customer customer) throws IOException {
        flight.addCustomersId(customer);
        context.saveChanges();
        LOG.info("Data saved");
    }

    public void returnTicket(Flight flight, Customer customer) throws IOException {
            String[] customersId = flight.getCustomersId();
            for(int i =0; i < customersId.length; i++) {
                if (customer.getId().equals(customersId[i])) {
                    flight.removeCustomerId(i);
                }
            }
        context.saveChanges();
        LOG.info("Data saved");
    }
}
