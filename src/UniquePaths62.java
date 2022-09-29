import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.com/problems/unique-paths/">LC62. Unique Paths</a>
 */
public class UniquePaths62 {

    public static void main(String[] args) {

        int m = 3;
        int n = 7;

        System.out.println(uniquePaths(m,n));
        System.out.println(uniquePathsWithDP(m,n));
    }

    private static int uniquePathsWithDP(int m, int n) {

        int[][] dp = new int[m][n];

        for (int i = m-1; i>=0; i--) {
            for (int j= n-1; j>=0; j--) {

                if (i == m-1 || j == n-1) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] =  dp[i][j+1] + dp[i+1][j];
                }

            }
        }

        return dp[0][0];
    }

    /**
     * This one works too but not at all optimal since it re-calculates the path which are already traversed.
     */
    private static int uniquePaths(int m, int n) {

        boolean[][] visited = new boolean[m][n];

        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                visited[i][j] = false;
            }
        }

        List<Integer>  pathList = new ArrayList<>();
        dfs(visited, 0, 0, pathList);
        return pathList.size();

    }

    private static void dfs(boolean[][] visited, int m, int n, List<Integer> patchCount) {

        if (m == visited.length-1 && n == visited[0].length-1) {
            patchCount.add(1);
        }

        if (m < 0 || n < 0 || m >= visited.length || n >= visited[0].length || visited[m][n]) {
            return;
        }

        dfs(visited, m+1, n, patchCount);
        dfs(visited, m, n+1, patchCount);
    }

}
