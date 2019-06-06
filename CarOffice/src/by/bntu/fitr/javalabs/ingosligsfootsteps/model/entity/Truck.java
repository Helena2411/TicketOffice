package by.bntu.fitr.javalabs.ingosligsfootsteps.model.entity;

import by.bntu.fitr.javalabs.ingosligsfootsteps.model.enums.Brand;
import by.bntu.fitr.javalabs.ingosligsfootsteps.model.enums.Model;
import by.bntu.fitr.javalabs.ingosligsfootsteps.model.enums.Transmission;

public class Truck extends Car {
    private static final int DEFAULT_SPACIOUNESS = 8;

    private int spaciousness;

    public Truck(Brand brand, Model model, String capacity, int price, int yearOfCarManufacture, Transmission transmission, int spaciousness) {
        super(brand, model, capacity, price, yearOfCarManufacture, transmission);
        this.spaciousness = spaciousness;
    }

    public Truck(Truck truck) {
        this(truck.getBrand(),truck.getModel(),truck.getEngineCapacity(), truck.getPrice(), truck.getYearOfCarManufacture(), truck.getTransmission(), truck.spaciousness);
    }

    public Truck() {
        super();
        this.spaciousness = DEFAULT_SPACIOUNESS;
    }

    public int getSpaciousness() {
        return spaciousness;
    }

    public void setSpaciousness(int spaciousness) {
        this.spaciousness = spaciousness;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Spaciousness = " + spaciousness;
    }
}
