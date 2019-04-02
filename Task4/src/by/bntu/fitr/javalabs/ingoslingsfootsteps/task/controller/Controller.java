package by.bntu.fitr.javalabs.ingoslingsfootsteps.task.controller;

import by.bntu.fitr.javalabs.ingoslingsfootsteps.task.model.entity.Matrix;
import by.bntu.fitr.javalabs.ingoslingsfootsteps.task.model.logic.MatrixWorker;
import by.bntu.fitr.javalabs.ingoslingsfootsteps.task.userinput.UserInput;
import by.bntu.fitr.javalabs.ingoslingsfootsteps.task.view.Printer;

public class Controller
{
    public static void main(String[] args)
    {
        int countRow = UserInput.input("Enter number of row");
        int countCol = UserInput.input("Enter number of col");
        Matrix matrix = new Matrix(countRow,countCol);
        MatrixWorker.fillRandom(matrix);
        Printer.print(matrix.toString());
        Printer.print("Numbers of cols with even elements only: \n");
        int[] numbersOfColWithEvenElements = MatrixWorker.numberOfColWithEvenElements(matrix);
        Printer.printArray(numbersOfColWithEvenElements);
        Printer.print("\nNumbers of cols with negative elements on the main diagonal and addition them: \n");
        int[] numbersOfColWithNegativeElementOnMainDiagonal =
                MatrixWorker.numberOfColWithNegativeElementsOnTheMainDiagonal(matrix);
        Printer.printArray(numbersOfColWithNegativeElementOnMainDiagonal);
        int[] sumOfElementsOfColWithNegativeElementOnMainDiagonal =
                MatrixWorker.sumOfElementsColWithNegativeElementOnTheMainDiagonal(matrix,
                        numbersOfColWithNegativeElementOnMainDiagonal);
        Printer.printArray(sumOfElementsOfColWithNegativeElementOnMainDiagonal);
    }
}
