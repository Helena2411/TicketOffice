package by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.entity;

public class Plane {

    final static int MIN_TIME = 60;
    final static int MIN_COUNT_OF_PEOPLE = 400;

    public static int planeAcount;
    private String airline;
    private int spaciousness;
    private int time;
    private String departurePoint;
    private String destination;
    private boolean isFlying;

    public Plane() {
        airline = "no name";
        spaciousness = MIN_COUNT_OF_PEOPLE;
        time = MIN_TIME;
        departurePoint = "no name";
        destination = "no name";
    }

    public Plane(String airline, int spaciousness, int time, String departurePoint, String destination, boolean isFlying) {
        this.airline = airline;
        this.departurePoint = departurePoint;
        this.destination = destination;
        this.spaciousness = spaciousness;
        this.time = time;
        this.isFlying = isFlying;
    }

    public Plane(Plane plane) {
        airline = plane.airline;
        departurePoint = plane.departurePoint;
        destination = plane.destination;
        spaciousness = plane.spaciousness;
        time = plane.time;
        isFlying = plane.isFlying;
    }

    public boolean isFlying() {
        return isFlying;
    }

    public void setFlying(boolean flying) {
        isFlying = flying;
    }

    public int getSpaciousness() {
        return spaciousness;
    }

    public void setSpaciousness(int spaciousness) {
        this.spaciousness = spaciousness;
    }

    public String getAirline() {
        return airline;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    public double getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
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

    public String toString() {
        return "The plane of " + airline + " go from [" + departurePoint + " to " + destination + "] for  " + time + " minutes " + " with spaciousness: " + spaciousness + " | is flying: " + isFlying + "\n";
    }
}
