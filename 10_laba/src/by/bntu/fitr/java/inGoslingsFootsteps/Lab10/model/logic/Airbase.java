package by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.logic;

import by.bntu.fitr.java.inGoslingsFootsteps.Lab10.model.entity.Plane;

import java.util.Arrays;

public class Airbase {

    private Plane[] planes;
    private int countPlanes;

    public Airbase() {
        this.planes = new Plane[0];
        this.countPlanes = 0;
    }

    public Airbase(Plane... planes) {
        this.planes = planes;
        this.countPlanes = planes.length;
    }

    public int size() {
        return countPlanes;
    }

    public void addPlane(Plane plane) {
        this.planes = Arrays.copyOf(planes, planes.length + 1);
        this.planes[countPlanes] = plane;
        countPlanes++;
    }

    public Plane getPlaneOfIndex(int index) {
        return planes[index];
    }

    @Override
    public String toString() {
        StringBuilder planesOfAirbase = new StringBuilder();

        for (Plane plane : planes) {
            planesOfAirbase.append(plane.toString());
        }
        return planesOfAirbase.toString();
    }

}
