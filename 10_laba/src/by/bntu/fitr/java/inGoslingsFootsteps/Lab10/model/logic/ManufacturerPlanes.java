package by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.logic;

import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.entity.Plane;
import java.util.Random;

public class ManufacturerPlanes {

    public final static int MIN_TIME = 60;
    public final static int BORDER_TIME = 300;
    public final static int MIN_COUNT_OF_PEOPLE = 400;
    public final static int BORDER_COUNT_OF_PEOPLE = 600;

    public static final String airlinesName[] = {"Belavia", "Transaviaexport", "Northrop", "Aerostar", "Malawia",
            "Renus Logistic"};
    public static final String departurePoints[] = {"Minsk", "Moscow", "Warsaw", "Paris", "London", "Rom"};
    public static final String destinations[] = {"Baku", "Sofia", "Brasilia", "Budapest", "Berlin", "Madrid"};

    
    public static Plane createRandomPlane() {

        Random random = new Random();
        
        int position = random.nextInt(airlinesName.length);
        String airline = airlinesName[position];
        int countPeople = random.nextInt(BORDER_COUNT_OF_PEOPLE) + MIN_COUNT_OF_PEOPLE;
        int time = random.nextInt(BORDER_TIME) + MIN_TIME;

        String departurePoint = departurePoints[position];
        String destination = destinations[position];
        boolean isFlying = random.nextBoolean();
        
        return new Plane(airline, countPeople, time, departurePoint, destination, isFlying);
    }

}
