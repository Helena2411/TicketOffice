package by.bntu.fitr.javalabs.ingosligsfootsteps.model.entity.initialization;

import by.bntu.fitr.javalabs.ingosligsfootsteps.model.entity.CarOffice;
import by.bntu.fitr.javalabs.ingosligsfootsteps.model.entity.PassengerCar;
import by.bntu.fitr.javalabs.ingosligsfootsteps.model.enums.Body;
import by.bntu.fitr.javalabs.ingosligsfootsteps.model.enums.Brand;
import by.bntu.fitr.javalabs.ingosligsfootsteps.model.enums.Model;
import by.bntu.fitr.javalabs.ingosligsfootsteps.model.enums.Transmission;

public class PassengerCarsManufacture extends CarsManufacture {
    private static final int DEFAULT_INDEX_FOR_PASSENGER_CARS = 0;

    @Override
    public CarOffice initCars(CarOffice carOffice) {
        carOffice.addCar(new PassengerCar(Brand.VOLVO, Model.S60, "2.2", 9700,
                2002, Transmission.AUTOMATED_MANUAL, Body.SEDAN), DEFAULT_INDEX_FOR_PASSENGER_CARS);
        carOffice.addCar(new PassengerCar(Brand.OPEL, Model.VECTRA, "2.0", 5700,
                2001, Transmission.MANUAL,Body.SEDAN), DEFAULT_INDEX_FOR_PASSENGER_CARS);
        carOffice.addCar(new PassengerCar(Brand.CHEVROLET, Model.CRUZE, "1.8", 7700,
                1998, Transmission.MANUAL,Body.HATCHBACK), DEFAULT_INDEX_FOR_PASSENGER_CARS);
        carOffice.addCar(new PassengerCar(Brand.NISSAN, Model.SENTRA, "2.0", 4700,
                2004, Transmission.MANUAL,Body.SEDAN), DEFAULT_INDEX_FOR_PASSENGER_CARS);
        carOffice.addCar(new PassengerCar(Brand.VOLKSWAGEN, Model.PASSAT_B6, "2.2", 10700,
                2009, Transmission.AUTOMATIC,Body.WAGON), DEFAULT_INDEX_FOR_PASSENGER_CARS);
        carOffice.addCar(new PassengerCar(Brand.SKODA, Model.OCTAVIA, "2.0", 8700,
                2005, Transmission.MANUAL,Body.SEDAN), DEFAULT_INDEX_FOR_PASSENGER_CARS);
        return carOffice;
    }
}
