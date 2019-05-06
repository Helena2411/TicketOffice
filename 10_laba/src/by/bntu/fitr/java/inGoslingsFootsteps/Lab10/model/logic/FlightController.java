package by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.logic;

import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.entity.AirTicketOfficeContex;
import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.entity.Customer;
import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.entity.Flight;
import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.exception.BookingException;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class FlightController {
    private static AirTicketOfficeContex context;
    private static final Logger LOG;
    static{
        LOG = Logger.getLogger(by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.logic.FlightController.class);
    }

    public FlightController() throws FileNotFoundException {
        context = AirTicketOfficeContex.getContext();
    }

    public Flight[] GetAvailableFlight(Customer customer) throws BookingException {
        Flight[] availableFlight = new Flight[0];
        for (int i = 0; i < context.sizeOfFlight(); i++) {
            boolean isEmpty = true;
            String[] customersId = context.getFlightByIndex(i).getCustomersId();
            if(context.getFlightByIndex(i).getCustomersId().length == 0) {
                availableFlight = addFlightToArray(availableFlight, i);
                isEmpty = false;
            }
            for(int j =0; j < context.getFlightByIndex(i).getCustomersId().length; j++) {
                if (customer.getId().equals(customersId[j])) {
                    isEmpty = false;
                }
            }
            if(isEmpty){
                availableFlight = addFlightToArray(availableFlight,i);
            }
        }
        if (availableFlight.length == 0) {
            throw new BookingException("You haven't available flight. Sorry(");
        }
        LOG.info("Got list of available flights");
        return availableFlight;
    }

    public Flight[] GetFlightsBookedByCustomer(Customer customer) throws BookingException {
        Flight[] occupiedCars = new Flight[0];
        for (int i = 0; i < context.sizeOfFlight(); i++) {
            String[] customersId = context.getFlightByIndex(i).getCustomersId();
            if(context.getFlightByIndex(i).getCustomersId().length == 0)
                continue;
            for (int j = 0; j < context.getFlightByIndex(i).getCustomersId().length; j++) {
                if (customer.getId().equals(customersId[j])) {
                    occupiedCars = addFlightToArray(occupiedCars, i);
                    break;
                }
            }
        }
       if (occupiedCars.length == 0)
        {
            throw new BookingException("You haven't booked flight.");
        }
        LOG.info("Got list of booked by customer flights");
        return occupiedCars;
    }
    private Flight[] addFlightToArray(Flight[] flights, int index) {
        flights = Arrays.copyOf(flights, flights.length + 1);
        flights[flights.length - 1] = context.getFlightByIndex(index);
        return flights;
    }

    public void bookTicket(Flight flight, Customer customer) throws IOException {
        flight.addCustomersId(customer);
        LOG.info("Data saved");
        context.saveChanges();
    }

    public void returnTicket(Flight flight, Customer customer) throws IOException {
            String[] customersId = flight.getCustomersId();
            for(int i =0; i < customersId.length; i++) {
                if (customer.getId().equals(customersId[i])) {
                    flight.removeCustomerId(i);
                }
            }
        LOG.info("Data saved");
        context.saveChanges();
    }
}
