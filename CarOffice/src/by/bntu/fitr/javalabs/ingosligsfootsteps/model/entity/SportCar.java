package by.bntu.fitr.javalabs.ingosligsfootsteps.model.entity;

import by.bntu.fitr.javalabs.ingosligsfootsteps.model.enums.Body;
import by.bntu.fitr.javalabs.ingosligsfootsteps.model.enums.Brand;
import by.bntu.fitr.javalabs.ingosligsfootsteps.model.enums.Model;
import by.bntu.fitr.javalabs.ingosligsfootsteps.model.enums.Transmission;

public class SportCar extends PassengerCar {
    private static final int DEFAULT_MAX_SPEED = 200;

    private int maxSpeed;

    public SportCar(Brand brand, Model model, String capacity, int price, int yearOfCarManufacture, Transmission transmission, Body body,int maxSpeed) {
        super(brand, model, capacity, price, yearOfCarManufacture, transmission, body);
        this.maxSpeed = maxSpeed;
    }

    public SportCar(SportCar sportCar) {
        this(sportCar.getBrand(), sportCar.getModel(), sportCar.getEngineCapacity(), sportCar.getPrice(), sportCar.getYearOfCarManufacture(), sportCar.getTransmission(),sportCar.getBody(), sportCar.maxSpeed);
    }

    public SportCar() {

        super();
        this.maxSpeed = DEFAULT_MAX_SPEED;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return super.toString() +
                "maxSpeed = " + maxSpeed;
    }
}
