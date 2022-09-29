import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/climbing-stairs/">LC70. Climbing Stairs</a>
 */
public class ClimbingStairs70 {

    public static void main(String[] args) {


        System.out.println(climbStairs(5));
        System.out.println(climbStairs2(5));
    }


    private static int climbStairs2(int n) {

       int[] dp = new int[n+1];

        for (int i = n; i>=0;i--) {

            if (i == n || i == n-1) {
                dp[i] = 1;
            } else {
                dp[i] = dp[i+1] + dp[i+2];
            }

        }

        return dp[0];
    }

    private static int climbStairs(int n) {

        Map<Integer, Integer> tracker = new HashMap<>();

        return recursive(n, tracker);
    }

    private static int recursive(int n, Map<Integer, Integer> tracker) {

        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (tracker.get(n) != null) {
            return tracker.get(n);
        }

        int l = recursive(n-1, tracker);
        int r = recursive(n-2, tracker);
        int result = l + r;

        tracker.put(n,result);

        return result;
    }



}
