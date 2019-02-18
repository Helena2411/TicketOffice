package by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.logic;

public class Dispatcher {

    final static String RESULT_GOOD = "Done! Ticket booked:)";
    final static String RESULT_BAD = "There is no such flight:)";

    public static String bookTicket(Airbase list, int count) {
        String result = RESULT_BAD;
        for (int i = 0; i < list.size(); i++) {
            if (list.getPlaneOfIndex(i).getSpaciousness() == count) {
                result = RESULT_GOOD;
            }
        }
        return result;
    }

    public static int countPlaneInAirbase(Airbase list) {
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            if (!list.getPlaneOfIndex(i).isFlying()) {
                count++;
            }
        }
        return count;
    }


    public static String getAvailableFlight(Airbase list, String capital, int time) {

        StringBuilder planes = new StringBuilder();

        for (int i = 0; i < list.size(); i++) {
            if (list.getPlaneOfIndex(i).getTime() < time && list.getPlaneOfIndex(i).getDestination().equals(capital)) {
                planes.append(list.getPlaneOfIndex(i).toString());
            }
        }
        return planes.toString();
    }
}
