import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/decode-ways/">91. Decode Ways</a>
 */
public class DecodeWays91 {

    public static void main(String[] args) {

        String s = "12";

        System.out.println(numDecodings(s));
    }

    private static int numDecodings(String s) {

        Map<Integer, Integer> dpMap = new HashMap<>();
        return recur(s, 0, dpMap);
    }

    private static int recur(String s, int i, Map<Integer, Integer> dpMap) {

        if (i >= s.length()) {
            return 1;
        }

        if (s.charAt(i) == '0') {
            return 0;
        }

        if (dpMap.containsKey(i)) {
            return dpMap.get(i);
        }

        int ways = recur(s, i + 1, dpMap);

        if (i + 2 <= s.length() && Integer.parseInt(s.substring(i, i + 2)) <= 26) {
            ways += recur(s, i + 2, dpMap);
        }

        dpMap.put(i, ways);

        return ways;

    }


}
