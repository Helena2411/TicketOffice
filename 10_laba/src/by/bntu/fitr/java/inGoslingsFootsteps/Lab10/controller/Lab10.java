package by.bntu.fitr.java.inGoslingsFootsteps.Lab10.controller;

import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.entity.Customer;
import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.logic.CustomerController;
import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.logic.FlightController;
import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.util.UserInput;
import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.util.exception.InputException;
import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.view.Printer;
import org.apache.log4j.Logger;

import java.io.IOException;

public class Lab10 {
    private static final Logger LOG;
    static{
        LOG = Logger.getLogger(by.bntu.fitr.java.inGoslingsFootsteps.Lab10.controller.Lab10.class);
    }

    public static void main(String[] args) throws IOException{

        try {
            String name = UserInput.inputString("Hi! What is your name?");
            String email = UserInput.inputString("What is your email?");

            CustomerController customerController = new CustomerController();
            Customer customer = customerController.AddNewCustomerOrGetExisting(email, name);
            FlightController flightController = new FlightController();

            int action = UserInput.inputInt("What do you want: 1)book or 2)return ticket?");
            CustomerAction.choicebyCustomer(flightController, customer, action);
        }catch (InputException ex){
            Printer.print(ex.getMessage());
            LOG.error(ex.getMessage());
        }
    }
}
