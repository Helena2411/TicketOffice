package by.bntu.fitr.java.inGoslingsFootsteps.Lab10.controller;

import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.entity.AirTicketOfficeContext;
import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.entity.Customer;
import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.exception.BookingException;
import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.logic.FlightController;
import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.util.UserInput;
import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.util.exception.InputException;
import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.view.Printer;
import org.apache.log4j.Logger;

import java.io.IOException;

public class CustomerAction {
    private static final Logger LOG;
    static{
        LOG = Logger.getLogger(by.bntu.fitr.java.inGoslingsFootsteps.Lab10.controller.CustomerAction.class);
    }

    public static  void choicebyCustomer(FlightController flightController, Customer customer, int action) throws IOException {
        try {
            if (action == 1) {
                AirTicketOfficeContext availableFlight = flightController.getAvailableFlight(customer);
                Printer.print(availableFlight.toString());
                int index = UserInput.inputInt("Choose flight");
                flightController.bookTicket(availableFlight.getFlights()[index - 1], customer);
                LOG.info("Ticket is booked");
            }
            else if (action == 2) {
                AirTicketOfficeContext occupiedCars = flightController.getFlightsBookedByCustomer(customer);
                Printer.print(occupiedCars.toString());
                int index = UserInput.inputInt("Choose flight");
                flightController.returnTicket(occupiedCars.getFlights()[index - 1], customer);
                LOG.info("Ticket is returned");
            }
            else{
                throw new InputException("You should enter 1 or 2");}
        }catch (BookingException | InputException ex) {
            Printer.print(ex.getMessage());
            LOG.error(ex.getMessage());
        }
    }
}
