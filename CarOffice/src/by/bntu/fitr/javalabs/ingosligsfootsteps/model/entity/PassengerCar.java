package by.bntu.fitr.javalabs.ingosligsfootsteps.model.entity;

import by.bntu.fitr.javalabs.ingosligsfootsteps.model.enums.Body;
import by.bntu.fitr.javalabs.ingosligsfootsteps.model.enums.Brand;
import by.bntu.fitr.javalabs.ingosligsfootsteps.model.enums.Model;
import by.bntu.fitr.javalabs.ingosligsfootsteps.model.enums.Transmission;

public class PassengerCar extends Car {
    private static final Body DEFAULT_BODY = Body.SEDAN;

    private Body body;

    public PassengerCar(Brand brand, Model model, String capacity, int price, int yearOfCarManufacture, Transmission transmission, Body body) {
        super(brand, model, capacity, price, yearOfCarManufacture,transmission);
        this.body = body;
    }

    public PassengerCar(PassengerCar passengerCar) {
        this(passengerCar.getBrand(), passengerCar.getModel(), passengerCar.getEngineCapacity(), passengerCar.getPrice(),passengerCar.getYearOfCarManufacture(), passengerCar.getTransmission(), passengerCar.body);
    }

    public PassengerCar() {
        super();
        this.body = DEFAULT_BODY;
    }

    public Body getBody() {
        return body;
    }

    public void setBody(Body body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Body = " + body;
    }
}
