package by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.entity;

import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.logic.JsonToArrayObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class AirTicketOfficeContex {
    private static AirTicketOfficeContex context;

    private Flight[] flights;
    private Customer[] customers;

    public AirTicketOfficeContex() {
        this.flights = new Flight[0];
        this.customers = new Customer[0];
    }

    public AirTicketOfficeContex(Flight[] flights, Customer[] customers) {
        this.flights = flights;
        this.customers = customers;
    }

    public AirTicketOfficeContex(AirTicketOfficeContex airTicketOfficeContex) {
        this(airTicketOfficeContex.flights, airTicketOfficeContex.customers);
    }

    public static AirTicketOfficeContex getContext() throws FileNotFoundException {
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

    public void saveChanges() throws IOException {
        JsonToArrayObject.SerializeeJson(context);
    }
    @Override
    public String toString() {
        StringBuilder planesOfAirbase = new StringBuilder();

        for (Flight flight : flights) {
            planesOfAirbase.append(flight.toString());
        }
        return planesOfAirbase.toString();
    }
}
