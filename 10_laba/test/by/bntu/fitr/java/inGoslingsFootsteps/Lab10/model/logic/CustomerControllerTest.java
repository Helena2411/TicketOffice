package by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.logic;

import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.entity.Customer;
import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.util.exception.InputException;
import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

public class CustomerControllerTest {

    @Test(expected = InputException.class)
    public void addNewCustomerOrGetExisting() throws FileNotFoundException, InputException {
        CustomerController customerController = new CustomerController();
        customerController.addNewCustomerOrGetExisting("","");
    }

    @Test
    public void getExistingCustomerByEmail() throws FileNotFoundException, InputException {
        Customer isActual = new Customer("Helena", "lenka_bokshic");
        CustomerController customerController = new CustomerController();
        Customer expected = customerController.addNewCustomerOrGetExisting(isActual.getName(), isActual.getEmail());
        assertEquals(expected.getEmail(), isActual.getEmail());
    }

    @Test
    public void getExistingCustomerByName() throws FileNotFoundException, InputException {
        Customer isActual = new Customer("Helena", "lenka_bokshic");
        CustomerController customerController = new CustomerController();
        Customer expected = customerController.addNewCustomerOrGetExisting(isActual.getName(), isActual.getEmail());
        assertEquals(expected.getName(), isActual.getName());
    }

    @Test
    public void addNewCustomer() throws FileNotFoundException, InputException {
        Customer isActual = new Customer("Ivan", "Ivanov");
        CustomerController customerController = new CustomerController();
        Customer expected = customerController.addNewCustomerOrGetExisting(isActual.getName(), isActual.getEmail());
        assertEquals(expected.getName(), isActual.getName());
    }
}