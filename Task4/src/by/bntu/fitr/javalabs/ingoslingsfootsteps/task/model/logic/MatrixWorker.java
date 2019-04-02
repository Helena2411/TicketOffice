package by.bntu.fitr.javalabs.ingoslingsfootsteps.task.model.logic;

import by.bntu.fitr.javalabs.ingoslingsfootsteps.task.model.entity.Matrix;

import java.util.Arrays;
import java.util.Random;

public class MatrixWorker {
    public final static int MIN_SIZE = 0;

    public static boolean isAllElementsOfColEven(Matrix matrix, int indexOfCol) {
        boolean isAllEven = true;
        for (int i = 0; i < matrix.getCountOfRow(); i++) {
            if (!(matrix.getValueOfIndex(i, indexOfCol) % 2 == 0)){
                isAllEven = false;
                break;
            }
        }
        return isAllEven;
    }

    public static boolean isElementOfMainDiagonalNegative(Matrix matrix, int indexOfCol) {
        boolean isNegativeElement = false;
        for (int i = 0; i < matrix.getCountOfRow(); i++)
                if (i == indexOfCol && matrix.getValueOfIndex(i, indexOfCol) < 0) {
                    isNegativeElement = true;
                    break;
                }
        return isNegativeElement;
    }
    public static int[] numberOfColWithEvenElements(Matrix matrix) {
        int[] numbers = new int[MIN_SIZE];
        for (int j = 0; j < matrix.getCountOfCol(); j++) {
            if(isAllElementsOfColEven(matrix, j)){
                numbers = Arrays.copyOf(numbers, numbers.length + 1);
                numbers[numbers.length - 1] = j;
            }
        }
        return numbers;
    }

    public static int[] numberOfColWithNegativeElementsOnTheMainDiagonal(Matrix matrix) {
        int[] numbers = new int[MIN_SIZE];
        for (int j = 0; j < matrix.getCountOfCol(); j++) {
            if(isElementOfMainDiagonalNegative(matrix, j)){
                numbers = Arrays.copyOf(numbers, numbers.length + 1);
                numbers[numbers.length - 1] = j;
            }
        }
        return numbers;
    }

    public static int[] sumOfElementsColWithNegativeElementOnTheMainDiagonal(Matrix matrix, int[] numbers) {
        int sum = 0;
        int[] sumOfElementsOfCol = new int[MIN_SIZE];
        for (int i = 0; i < numbers.length; i++){
            for (int j = 0; j < matrix.getCountOfRow(); j++) {
                sum += matrix.getValueOfIndex(j, numbers[i]);
            }
        sumOfElementsOfCol = Arrays.copyOf(sumOfElementsOfCol, sumOfElementsOfCol.length + 1);
        sumOfElementsOfCol[sumOfElementsOfCol.length - 1] = sum;
        sum = 0;
        }
        return sumOfElementsOfCol;
    }

    public static void fillRandom(Matrix matrix) {
        Random random = new Random();
        for (int i = 0; i < matrix.getCountOfRow(); i++) {
            for (int j = 0; j < matrix.getCountOfCol(); j++) {
                int value = random.nextInt(60) - 30;
                matrix.setValueOfIndex(value, i, j);
            }
        }
    }
}
