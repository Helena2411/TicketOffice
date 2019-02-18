package by.bntu.fitr.java.inGoslingsFootsteps.Lab10.controller;

import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.logic.Airbase;
import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.logic.Dispatcher;
import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.logic.ManufacturerPlanes;
import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.util.UserInput;
import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.view.Printer;

public class Lab10 {
    public static void main(String[] args) {
        int count = UserInput.inputInt("Enter the count of planes in airbase:");

        Airbase listOfPlanes = new Airbase();

        for (int i = 0; i < count; i++) {
            listOfPlanes.addPlane(ManufacturerPlanes.createRandomPlane());
        }

        int countPlaneInAirbase = Dispatcher.countPlaneInAirbase(listOfPlanes);
        Printer.print("Now in airbase:" + countPlaneInAirbase + " planes");
        String listPlanes = listOfPlanes.toString();
        Printer.print(listPlanes);
        String capital = UserInput.inputString("Where do you want to go");
        int time = UserInput.inputInt("What time do you want to fly?");
        String availableList = Dispatcher.getAvailableFlight(listOfPlanes, capital, time);
        Printer.print(availableList);
        int countPeople = UserInput.inputInt("Select available flight by spaciousness of departmentPoint:");
        Printer.print(Dispatcher.bookTicket(listOfPlanes, countPeople));
    }
}
