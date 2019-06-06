package by.bntu.fitr.javalabs.ingosligsfootsteps.controller;

import by.bntu.fitr.javalabs.ingosligsfootsteps.model.entity.CarOffice;
import by.bntu.fitr.javalabs.ingosligsfootsteps.model.entity.initialization.PassengerCarsManufacture;
import by.bntu.fitr.javalabs.ingosligsfootsteps.model.entity.initialization.SportCarManufacture;
import by.bntu.fitr.javalabs.ingosligsfootsteps.model.entity.initialization.TruckCarsManufacture;
import by.bntu.fitr.javalabs.ingosligsfootsteps.util.UserInput;
import by.bntu.fitr.javalabs.ingosligsfootsteps.view.ConsolePrinter;
import by.bntu.fitr.javalabs.ingosligsfootsteps.view.FilePrinter;

public class Cars_Lab {
    public static void main(String[] args) {
        ConsolePrinter consolePrinter = new ConsolePrinter();
        FilePrinter filePrinter = new FilePrinter();
        CarOffice carOffice = new CarOffice();

        carOffice = new PassengerCarsManufacture().initCars(carOffice);
        carOffice = new SportCarManufacture().initCars(carOffice);
        carOffice = new TruckCarsManufacture().initCars(carOffice);

        filePrinter.print("All data are initializated");
        consolePrinter.print("Hello!");
        int type = UserInput.input("You can choice a type of car: \n1. Passenger \n2. SportCar \n3. Truck");
        filePrinter.print("Customer choose type of car");
        carOffice.setCountOfRowForPrint(type - 1);
        consolePrinter.print(carOffice.toString());
        int answer = UserInput.input("Choose a car");
        consolePrinter.print("You choose " + carOffice.getCarByIndex(type - 1, answer - 1));
        filePrinter.print("Customer choose a car");
    }
}
