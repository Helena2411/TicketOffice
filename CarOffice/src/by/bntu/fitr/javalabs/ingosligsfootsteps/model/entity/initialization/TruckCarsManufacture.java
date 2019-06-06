package by.bntu.fitr.javalabs.ingosligsfootsteps.model.entity.initialization;

import by.bntu.fitr.javalabs.ingosligsfootsteps.model.entity.CarOffice;
import by.bntu.fitr.javalabs.ingosligsfootsteps.model.entity.Truck;
import by.bntu.fitr.javalabs.ingosligsfootsteps.model.enums.Brand;
import by.bntu.fitr.javalabs.ingosligsfootsteps.model.enums.Model;
import by.bntu.fitr.javalabs.ingosligsfootsteps.model.enums.Transmission;

public class TruckCarsManufacture extends CarsManufacture {
    private static final int DEFAULT_INDEX_FOR_TRUCK_CARS = 2;

    @Override
    public CarOffice initCars(CarOffice carOffice) {
        carOffice.addCar(new Truck(Brand.MERCEDES_BENZ, Model.SPRINTER, "6.0", 16700,
                2005, Transmission.AUTOMATIC, 12), DEFAULT_INDEX_FOR_TRUCK_CARS);
        carOffice.addCar(new Truck(Brand.FORD, Model.TRANSIT, "5.5", 13200,
                1999,Transmission.MANUAL, 9), DEFAULT_INDEX_FOR_TRUCK_CARS);
        carOffice.addCar(new Truck(Brand.RENAULT, Model.MASTER, "5.0", 15600,
                2010, Transmission.MANUAL,21), DEFAULT_INDEX_FOR_TRUCK_CARS);
        return carOffice;
    }
}
