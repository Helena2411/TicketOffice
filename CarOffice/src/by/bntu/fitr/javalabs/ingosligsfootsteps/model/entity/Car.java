package by.bntu.fitr.javalabs.ingosligsfootsteps.model.entity;

import by.bntu.fitr.javalabs.ingosligsfootsteps.model.enums.Brand;
import by.bntu.fitr.javalabs.ingosligsfootsteps.model.enums.Model;
import by.bntu.fitr.javalabs.ingosligsfootsteps.model.enums.Transmission;

public class Car {
    private static final String DEFAULT_CAPACITY = "2.0";
    private static final int DEFAULT_PRICE = 2000;
    private static final int DEFAULT_YEAROFCARMANUFACTURE = 2000;
    private static final Brand DEFAULT_BRAND = Brand.OPEL;
    private static final Model DEFAULT_MODEL = Model.VECTRA;
    private static final Transmission DEFAULT_TRANSMISSION = Transmission.MANUAL;

    private Brand brand;
    private Model model;
    private int yearOfCarManufacture;
    private String engineCapacity;
    private int price;
    private Transmission transmission;

    public Car(Brand brand, Model model, String capacity, int price, int yearOfCarManufacture,Transmission transmission) {
        this.brand = brand;
        this.model = model;
        this.engineCapacity = capacity;
        this.price = price;
        this.yearOfCarManufacture = yearOfCarManufacture;
        this.transmission = transmission;
    }

    public Car(Car car) {
        this(car.brand, car.model, car.engineCapacity, car.price, car.yearOfCarManufacture, car.transmission);
    }

    public Car() {
        this.brand = DEFAULT_BRAND;
        this.model = DEFAULT_MODEL;
        this.engineCapacity = DEFAULT_CAPACITY;
        this.price = DEFAULT_PRICE;
        this.yearOfCarManufacture = DEFAULT_YEAROFCARMANUFACTURE;
        this.transmission = DEFAULT_TRANSMISSION;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Model getModel() {
        return model;
    }

    public void setModel(Model model) {
        this.model = model;
    }

    public String getEngineCapacity() {
        return engineCapacity;
    }

    public void setEngineCapacity(String engineCapacity) {
        this.engineCapacity = engineCapacity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getYearOfCarManufacture() {
        return yearOfCarManufacture;
    }

    public void setYearOfCarManufacture(int yearOfCarManufacture) {
        this.yearOfCarManufacture = yearOfCarManufacture;
    }

    public Transmission getTransmission() {
        return transmission;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    @Override
    public String toString() {
        return "Brand = " + brand +
                ", Model = " + model +
                ", YearOfCarManufacture = " + yearOfCarManufacture +
                ", EngineCapacity = " + engineCapacity +
                ", Transmission = " + transmission +
                ", Price = " + price + "$ ";
    }
}
