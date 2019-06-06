package by.bntu.fitr.javalabs.ingosligsfootsteps.model.entity.initialization;

import by.bntu.fitr.javalabs.ingosligsfootsteps.model.entity.CarOffice;
import by.bntu.fitr.javalabs.ingosligsfootsteps.model.entity.SportCar;
import by.bntu.fitr.javalabs.ingosligsfootsteps.model.enums.Body;
import by.bntu.fitr.javalabs.ingosligsfootsteps.model.enums.Brand;
import by.bntu.fitr.javalabs.ingosligsfootsteps.model.enums.Model;
import by.bntu.fitr.javalabs.ingosligsfootsteps.model.enums.Transmission;

public class SportCarManufacture extends CarsManufacture {
    private static final int DEFAULT_INDEX_FOR_SPORT_CARS = 1;

    @Override
    public CarOffice initCars(CarOffice carOffice) {
        carOffice.addCar(new SportCar(Brand.ACURA, Model.MDX, "2.4", 18700,
                2007, Transmission.AUTOMATED_MANUAL,  Body.SEDAN,240), DEFAULT_INDEX_FOR_SPORT_CARS);
        carOffice.addCar(new SportCar(Brand.AUDI, Model.A6, "2.2", 21400,
                2008, Transmission.AUTOMATIC, Body.SEDAN, 260), DEFAULT_INDEX_FOR_SPORT_CARS);
        carOffice.addCar(new SportCar(Brand.BENTLEY, Model.CONTINENTAL_GT, "5.0", 30600,
                2010, Transmission.AUTOMATIC,  Body.SUV, 250), DEFAULT_INDEX_FOR_SPORT_CARS);
        carOffice.addCar(new SportCar(Brand.BMW, Model.M16, "2.2", 16700,
                2012, Transmission.MANUAL,  Body.SEDAN, 260), DEFAULT_INDEX_FOR_SPORT_CARS);
        carOffice.addCar(new SportCar(Brand.HONDA, Model.CIVIC, "2.0", 14700,
                2008, Transmission.MANUAL,  Body.WAGON, 250), DEFAULT_INDEX_FOR_SPORT_CARS);

        return carOffice;
    }
}
