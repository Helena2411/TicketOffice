package by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.logic;

import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.entity.Plane;

import java.util.ArrayList;
import java.util.Random;

public class Airbase {

    final static int MIN_TIME = 60;
    final static int BORDER_TIME = 300;
    final static int MIN_COUNT_OF_PEOPLE = 400;
    final static int BORDER_COUNT_OF_PEOPLE = 600;

    public static ArrayList create(int count) {
        Random random = new Random();
        ArrayList<Plane> listOfPlanes = new ArrayList<Plane>();
        String airlines[] = {"Belavia", "Transaviaexport", "Northrop", "Aerostar", "Malawia", "Renus Logistic"};
        String departurePoints[] = {"Minsk", "Moscow", "Warsaw", "Paris", "London", "Rom"};
        String destinations[] = {"Baku", "Sofia", "Brasilia", "Budapest", "Berlin", "Madrid"};
        for (int i = 0; i < count; i++) {
            int position = random.nextInt(airlines.length);
            String airline = airlines[position];
            int countPeople = random.nextInt(BORDER_COUNT_OF_PEOPLE) + MIN_COUNT_OF_PEOPLE;
            int time = random.nextInt(BORDER_TIME) + MIN_TIME;
            String departurePoint = departurePoints[position];
            String destination = destinations[position];
            boolean isFlying = random.nextBoolean();
            Plane plane = new Plane(airline, countPeople, time, departurePoint, destination, isFlying);
            listOfPlanes.add(plane);
        }
        return listOfPlanes;
    }
    public static String toStringArray(ArrayList<Plane> listOfPlanes){
        listOfPlanes.toArray();
        String planes = "";
        for(Plane item : listOfPlanes){
            planes += item.toString();
        }
        return planes;
    }

}
