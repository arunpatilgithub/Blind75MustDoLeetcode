import addons.MatrixPrinter;

/**
 * <a href="https://leetcode.com/problems/set-matrix-zeroes/">LC73. Set Matrix Zeroes</a>
 */
public class SetMatrixZeroes73 {

    public static void main(String[] args) {

        int[][] matrix = {{0,1,2,0},{3,4,5,2},{1,3,1,5}};
        //int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};

        MatrixPrinter.printInteger2dMatrix(matrix);
        System.out.println("\n");

        setZeroes(matrix);
        MatrixPrinter.printInteger2dMatrix(matrix);
        System.out.println("\n");
    }

    private static void setZeroes(int[][] matrix) {

        boolean firstRowZero = false;
        boolean firstColZero = false;

        for (int i=0; i<matrix[0].length; i++) {
            if (matrix[0][i] == 0) {
                firstRowZero = true;
                break;
            }
        }

        for (int i=0; i<matrix.length; i++) {
            if (matrix[i][0] == 0) {
                firstColZero = true;
                break;
            }
        }

        for (int i=1; i<matrix.length; i++) {
            for (int j=1; j<matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i=1; i<matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {

                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRowZero) {
            for (int i=0; i<matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }

        if (firstColZero) {
            for (int i=0; i<matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

    }

}
