package by.bntu.fitr.javalabs.ingoslingsfootsteps.task.model.entity;

public class Matrix {
    public static final int DEFAUL_SIZE = 5;

    private int[][] matrix;

    public Matrix(int[][] matrix) {
        this.matrix = matrix;
    }

    public Matrix(){
        matrix = new int[DEFAUL_SIZE][DEFAUL_SIZE];
    }

    public Matrix(int countRow, int countCol) {
        this.matrix = new int[countRow][countCol];
    }

//    public Matrix(Matrix object){
//        this(object.getCountOfRow(), object.getCountOfCol());
//
//        for(int i = 0; i < matrix.length; i++){
//            for(int j = 0; j < matrix[0].length; j++){
//                matrix[i][j] = object.matrix[i][j];
//            }
//        }
//    }

    public int getCountOfRow() {
        return matrix.length;
    }

    public int getCountOfCol() {
        return matrix[0].length;
    }

    public int getValueOfIndex(int countRow, int countCol) {
        return matrix[countRow][countCol];
    }

    public void setValueOfIndex(int value, int countRow, int countCol) {
        matrix[countRow][countCol] = value;
    }

    @Override
    public String toString() {
        StringBuilder matrixString = new StringBuilder();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrixString.append(matrix[i][j]).append("\t   ");
            }
            matrixString.append("\n");
        }
        return matrixString.toString();
    }
}
