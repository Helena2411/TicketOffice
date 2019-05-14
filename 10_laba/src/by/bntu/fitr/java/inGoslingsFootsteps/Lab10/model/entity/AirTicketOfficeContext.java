package by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.entity;

import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.logic.JsonToArrayObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class AirTicketOfficeContext {
    private static AirTicketOfficeContext context;

    private Flight[] flights;
    private Customer[] customers;

    public AirTicketOfficeContext() {
        this.flights = new Flight[0];
        this.customers = new Customer[0];
    }

    public AirTicketOfficeContext(Flight[] flights, Customer[] customers) {
        this.flights = flights;
        this.customers = customers;
    }

    public AirTicketOfficeContext(AirTicketOfficeContext airTicketOfficeContext) {
        this(airTicketOfficeContext.flights, airTicketOfficeContext.customers);
    }

    public static AirTicketOfficeContext getContext() throws FileNotFoundException {
    if(context == null)
        context = JsonToArrayObject.DeserializeJson();
    return context;
    }

    public int sizeOfFlight() {
        return flights.length;
    }

    public int sizeOfCustomers() {
        return customers.length;
    }

    public void addCustomer(Customer customer) {
        this.customers = Arrays.copyOf(customers, customers.length + 1);
        this.customers[customers.length - 1] = customer;
    }

    public Customer getCustomerByIndex(int index) {
        return customers[index];
    }

    public void setCustomerByIndex(int index, Customer customer) {
        customers[index] = customer;
    }

    public void setFlightByIndex(int index, Flight flight) {
        flights[index] = flight;
    }

    public Flight getFlightByIndex(int index) {
        return flights[index];
    }

    public Flight[] getFlights() {
        return flights;
    }

    public void setFlights(Flight[] flights) {
        this.flights = flights;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public void saveChanges() throws IOException {
        JsonToArrayObject.SerializeJson(context);
    }
    @Override
    public String toString() {
        StringBuilder planesOfAirbase = new StringBuilder();
        int n = 1;
        for (Flight flight : flights) {
            planesOfAirbase.append(n).append(". ").append(flight.toString()).append("\n");
            n++;
        }
        return planesOfAirbase.toString();
    }
}
