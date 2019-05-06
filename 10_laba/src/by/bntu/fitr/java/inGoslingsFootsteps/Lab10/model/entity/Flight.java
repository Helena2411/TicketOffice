package by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.entity;

import java.util.Arrays;

public class Flight {
    private final static int MIN_COUNT_OF_TICKETS = 400;
    private final static int MIN_PRICE= 100;

    private String departurePoint;
    private String destination;
    private String departureDate;
    private String departureTime;
    private int countOfTicket;
    private int price;
    private String[] customersId;

    public Flight() {
        departurePoint = "no name";
        destination = "no name";
        departureDate = "no name ";
        departureTime = "no name";
        countOfTicket = MIN_COUNT_OF_TICKETS;
        price = MIN_PRICE;
    }

    public Flight(String departurePoint,String destination, String departureDate, String departureTime, int countOfTicket, int price) {
        this.departurePoint = departurePoint;
        this.destination = destination;
        this.departureDate = departureDate;
        this.departureTime = departureTime;
        this.countOfTicket = countOfTicket;
        this.price = price;
    }

    public Flight(Flight flight) {
        this(flight.departurePoint, flight.destination, flight.departureDate, flight.departureTime, flight.countOfTicket, flight.price);
    }

    public String getDeparturePoint() {
        return departurePoint;
    }

    public void setDeparturePoint(String departurePoint) {
        this.departurePoint = departurePoint;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDepartureDate() {
        return departureDate;
    }

    public void setDepartureDate(String departureDate) {
        this.departureDate = departureDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getCountOfTicket() {
        return countOfTicket;
    }

    public void setCountOfTicket(int countOfTicket) {
        this.countOfTicket = countOfTicket;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String[] getCustomersId() {
        return customersId;
    }

    public void setCustomersId(String[] customersId) {
        this.customersId = customersId;
    }

    public void addCustomersId(Customer customer) {
        this.customersId = Arrays.copyOf(this.customersId, this.customersId.length + 1);
        this.customersId[this.customersId.length - 1] = customer.getId();
    }

    public void  removeCustomerId(int index) {
        int size = this.customersId.length;
        String[] newCustomerId = new String[size - 1];
        System.arraycopy(this.customersId, 0, newCustomerId, 0, index);
        System.arraycopy(this.customersId, index + 1, newCustomerId, index,
                size - index - 1);
        this.customersId = new String[newCustomerId.length];
        System.arraycopy(newCustomerId, 0, this.customersId, 0, newCustomerId.length);
    }

    @Override
    public String toString() {
        return departurePoint  + " ---> " + destination + ", Date - " + departureDate + ", Time - " + departureTime
                + ", Price - " + price;
    }
}
