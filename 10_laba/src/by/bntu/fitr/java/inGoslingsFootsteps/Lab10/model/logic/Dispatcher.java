package by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.logic;

import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.entity.Plane;

import java.util.ArrayList;

public class Dispatcher {
    final static String RESULT_GOOD = "Done! Ticket booked:)";
    final static String RESULT_BAD = "There is no such flight:)";

    public static String bookTicket(ArrayList<Plane> list, int count) {
        String result = RESULT_BAD;
            for (Plane item : list) {
                if (item.getSpaciousness() == count) {
                    item.setFlying(true);
                    result = RESULT_GOOD;
                }
            }
        return result;
    }

    public static int countPlaneInAirbase(ArrayList<Plane> list) {
        int count = 0;
        for (Plane item : list) {
            if (!item.isFlying()) {
                count++;
            }
        }
        return count;
    }


    public static String getAvailableFlight(ArrayList<Plane> list, String capital, int time) {
        String planes = "";
        for (Plane item : list) {
            if (item.getTime() < time && item.getDestination().equals(capital)) {
                planes += item.toString();
            }
        }
        return planes;
    }
}
