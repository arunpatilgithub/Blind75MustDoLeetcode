package addons;

public class MatrixTranspose {

    public static void main(String[] args) {

        int[][] input = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        System.out.println("Before transpose: ");
        printMatrix(input);

        transpose(input);

        System.out.println("After transpose: ");
        printMatrix(input);
    }

    private static void transpose(int[][] input) {

        int l = input.length;

        for (int m = 0; m < input.length; m++) {
            for (int n = m; n < input.length; n++) {
                int temp = input[m][n];
                input[m][n] = input[n][m];
                input[n][m] = temp;
            }
        }

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
}
