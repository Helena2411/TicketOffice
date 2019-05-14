package by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.logic;

import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.entity.AirTicketOfficeContext;
import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.entity.Customer;
import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.util.exception.InputException;
import org.apache.log4j.Logger;

import java.io.FileNotFoundException;

public class CustomerController {
    private static AirTicketOfficeContext context;
    private static final Logger LOG;
    static{
        LOG = Logger.getLogger(by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.logic.CustomerController.class);
    }

    public CustomerController() throws FileNotFoundException {
        context = AirTicketOfficeContext.getContext();
    }

    public Customer addNewCustomerOrGetExisting(String name, String email) throws InputException {
        if(email.equals("") || name.equals(""))
            throw new InputException("You entered incorrect data");
        Customer customer;
        for (int i = 0; i < context.sizeOfCustomers(); i++) {
            if (email.equals(context.getCustomerByIndex(i).getEmail())) {
                customer = context.getCustomerByIndex(i);
                LOG.info("Got existing customer");
                return customer;
            }
        }
        customer = new Customer(name, email);
        context.addCustomer(customer);
        LOG.info("Added new customer in json");
        return customer;
    }
}
