package addons;

public class MatrixPrinter {

    public static void printInteger2dMatrix(int[][] matrix) {
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                System.out.print(String.format("%20s", matrix[i][j]));
            }
            System.out.println("");
        }
    }
}
