package by.bntu.fitr.javalabs.ingosligsfootsteps.model.entity;

import java.util.Arrays;

public class CarOffice {

    private static final int MAX_SIZE = 3;
    private static final int MIN_SIZE = 0;

    private Car[][] cars;

    private int countOfRowForPrint;

    public CarOffice() {
        this.cars = new Car[MAX_SIZE][MIN_SIZE];
        countOfRowForPrint = MIN_SIZE;
    }

    public void addCar(Car car, int index) {
        this.cars[index] = Arrays.copyOf(cars[index], cars[index].length + 1);
        this.cars[index][cars[index].length - 1] = car;
    }

    public Car getCarByIndex(int row, int col) {
        return cars[row][col];
    }

    public Car[] getRowByIndex(int row) {
        return cars[row];
    }

    public int getCountOfRowForPrint() {
        return countOfRowForPrint;
    }

    public void setCountOfRowForPrint(int countOfRowForPrint) {
        this.countOfRowForPrint = countOfRowForPrint;
    }

    @Override
    public String toString() {
        StringBuilder listOfCars = new StringBuilder();
        int n = 1;
        for (int j = 0; j < cars[countOfRowForPrint].length; j++) {
            listOfCars.append(n).append(". ").append(cars[countOfRowForPrint][j].toString()).append("\n");
            n++;
        }
        return listOfCars.toString();
    }
}
