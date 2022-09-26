import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/spiral-matrix/">LC54. Spiral Matrix</a>
 */
public class SpiralMatrixLC54 {

    public static void main(String[] args) {

        //int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        //int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
        int[][] matrix = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}};
        //int[][] matrix = {{3}, {2}};

        List<Integer> actual = spiralOrder(matrix);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 8, 12, 16, 15, 14, 13, 9, 5, 6, 7, 11, 10);
        //List<Integer> expected = Arrays.asList(3, 2);

        print(matrix);

        System.out.println(expected);
        System.out.println(actual);

        //System.out.println(spiralOrder.equals(Arrays.asList(1, 2, 3, 6, 9, 8, 7, 4, 5)));
        System.out.println(actual.equals(expected));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        for (int m = 0; m < matrix.length; m++) {
            for (int n = 0; n < matrix[m].length; n++) {
                visited[m][n] = false;
            }
        }

        List<Integer> result = new ArrayList<>();

        dfs(matrix, visited, result, 0, 0, "E");
        return result;
    }

    public static void dfs(int[][] matrix, boolean[][] visited, List<Integer> result, int i, int j,
                           String currentDirection) {

        if (i > matrix.length - 1 || j > matrix[0].length - 1 || i < 0 || j < 0 || visited[i][j]) {
            return;
        }

        visited[i][j] = true;
        result.add(matrix[i][j]);

        if (currentDirection.equals("E")) {
            j = j + 1;
        } else if (currentDirection.equals("S")) {
            i = i + 1;
        } else if (currentDirection.equals("W")) {
            j = j - 1;
        } else {
            i = i - 1;
        }

        dfs(matrix, visited, result, i, j, currentDirection);

        if (currentDirection.equals("E")) {
            currentDirection = "S";
            j = j - 1;
            i = i + 1;
        } else if (currentDirection.equals("S")) {
            currentDirection = "W";
            i = i - 1;
            j = j - 1;
        } else if (currentDirection.equals("W")) {
            currentDirection = "N";
            j = j + 1;
            i = i - 1;
        } else {
            currentDirection = "E";
            j = j + 1;
            i = i + 1;
        }

        dfs(matrix, visited, result, i, j, currentDirection);

        return;
    }

    private static void print(int[][] matrixArray) {

        for (int i = 0; i < matrixArray.length; i++) {
            for (int j = 0; j < matrixArray[0].length; j++) {
                System.out.print(String.format("%5s", matrixArray[i][j]));
            }
            System.out.println();
        }
    }
}
