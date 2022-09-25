/**
 * <a href="https://leetcode.com/problems/rotate-image/">LC48. Rotate Image</a>
 */
public class RotateImageLC48 {

    public static void main(String[] args) {

        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println("Before rotation.");
        printMatrix(matrix);

        rotate(matrix);
        System.out.println("After rotation.");
        printMatrix(matrix);

    }

    private static void printMatrix(int[][] input) {
        int length = input.length;

        for (int m = 0; m < length; m++) {
            for (int n = 0; n < length; n++) {
                System.out.printf(input[m][n] + " ");
            }
            System.out.printf("\n");
        }
    }

    public static void rotate(int[][] matrix) {

        //Step1: transpose
        for (int m = 0; m < matrix.length; m++) {
            for (int n = m; n < matrix.length; n++) {
                int temp = matrix[m][n];
                matrix[m][n] = matrix[n][m];
                matrix[n][m] = temp;
            }
        }

        //Step2: reverse each row.
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length / 2; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix.length - 1 - j];
                matrix[i][matrix.length - 1 - j] = temp;
            }
        }
    }

}
