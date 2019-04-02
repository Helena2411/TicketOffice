package by.bntu.fitr.javalabs.ingoslingsfootsteps.task.model.logic;

import by.bntu.fitr.javalabs.ingoslingsfootsteps.task.model.entity.Matrix;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MatrixWorkerTest {

    @Test
    public void testSimpleMatrix() {
        Matrix matrix = new Matrix(new int[][]{
                {1, 2, 3},
                {1, 2, 3}});
        int[] numbers = new int[] {1};
        int[] expected = MatrixWorker.numberOfColWithEvenElements(matrix);
        assertArrayEquals(expected, numbers);
    }

    @Test
    public void testZeroMatrix() {
        Matrix matrix = new Matrix(new int[][]{
                {0, 0, 0},
                {0, 0, 0}});
        int[] numbers = new int[] {0,1,2};
        int[] expected = MatrixWorker.numberOfColWithEvenElements(matrix);
        assertArrayEquals(expected, numbers);
    }
    @Test
    public void testMatrixWithoutEvenNumbers() {
        Matrix matrix = new Matrix(new int[][]{
                {1, 1, 3},
                {3, 2, 4}});
        int[] numbers = new int[] {};
        int[] expected = MatrixWorker.numberOfColWithEvenElements(matrix);
        assertArrayEquals(expected, numbers);
    }

    @Test
    public void isElementOfMainDiagonalNegative() {
        Matrix matrix = new Matrix(new int[][]{
                {-1, 2, 3},
                {1, 2, 3}});
        boolean isActual = true;
        boolean expected = MatrixWorker.isElementOfMainDiagonalNegative(matrix,0);
        assertEquals(expected, isActual);
    }

    @Test
    public void isNotElementOfMainDiagonalNegative() {
        Matrix matrix = new Matrix(new int[][]{
                {2, 2, 3},
                {1, 2, 3}});
        boolean isActual = false;
        boolean expected = MatrixWorker.isElementOfMainDiagonalNegative(matrix,0);
        assertEquals(expected, isActual);
    }
    @Test
    public void isAllElementsOfColEven() {
        Matrix matrix = new Matrix(new int[][]{
                {2, 2, 3},
                {1, 2, 3}});
        boolean isActual = true;
        boolean expected = MatrixWorker.isAllElementsOfColEven(matrix,1);
        assertEquals(expected, isActual);
    }
    @Test
    public void isNotAllElementsOfColEven() {
        Matrix matrix = new Matrix(new int[][]{
                {2, 5, 3},
                {1, 2, 3}});
        boolean isActual = false;
        boolean expected = MatrixWorker.isAllElementsOfColEven(matrix,1);
        assertEquals(expected, isActual);
    }
    @Test
    public void numberOfColWithNegativeElementsOnTheMainDiagonal() {
        Matrix matrix = new Matrix(new int[][]{
                {1, 2, 3},
                {1, -2, 3}});
        int[] numbers = new int[] {1};
        int[] expected = MatrixWorker.numberOfColWithNegativeElementsOnTheMainDiagonal(matrix);
        assertArrayEquals(expected, numbers);
    }
    @Test
    public void ColWithAllNotNegativeElementsOnTheMainDiagonal() {
        Matrix matrix = new Matrix(new int[][]{
                {1, 2, 3},
                {1, 6, 3}});
        int[] numbers = new int[] {};
        int[] expected = MatrixWorker.numberOfColWithNegativeElementsOnTheMainDiagonal(matrix);
        assertArrayEquals(expected, numbers);
    }
    @Test
    public void ColWithAllZeroElementsOnTheMainDiagonal() {
        Matrix matrix = new Matrix(new int[][]{
                {0, 0, 0},
                {0, 0, 0}});
        int[] numbers = new int[] {};
        int[] expected = MatrixWorker.numberOfColWithNegativeElementsOnTheMainDiagonal(matrix);
        assertArrayEquals(expected, numbers);
    }

    @Test
    public void sumOfElementsColWithNegativeElementOnTheMainDiagonal() {
        Matrix matrix = new Matrix(new int[][]{
                {1, 2, 3},
                {1, -6, 3}});
        int[] numbers = new int[] {1};
        int[] actual = new int[] {-4};
        int[] expected = MatrixWorker.sumOfElementsColWithNegativeElementOnTheMainDiagonal(matrix, numbers);
        assertArrayEquals(expected, actual);
    }
    @Test
    public void sumOfElementsColWitNotNegativeElementOnTheMainDiagonal() {
        Matrix matrix = new Matrix(new int[][]{
                {1, 2, 3},
                {1, 1, 3}});
        int[] numbers = new int[] {};
        int[] actual = new int[] {};
        int[] expected = MatrixWorker.sumOfElementsColWithNegativeElementOnTheMainDiagonal(matrix, numbers);
        assertArrayEquals(expected, actual);
    }
}