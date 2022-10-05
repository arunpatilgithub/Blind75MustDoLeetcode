import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/minimum-window-substring/">Lhttps://leetcode.com/problems/minimum-window-substring/</a>
 */
public class MinimumWindowSubstring76 {

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }

    private static String minWindow(String s, String t) {

        int l = 0;
        int r = 0;

        String minSubString = "";

        Map<Character, Integer> actual = new HashMap<>();
        Map<Character, Integer> expected = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            expected.put(t.charAt(i), expected.getOrDefault(t.charAt(i), 0) + 1);
        }

        int actualLength = 0;

        while (r < s.length()) {
            if (expected.containsKey(s.charAt(r))) {
                if (actual.get(s.charAt(r)) < expected.get(t.charAt(r))) {
                    actualLength++;
                    actual.put(s.charAt(r), actual.getOrDefault(s.charAt(r), 0) + 1);
                }

                if (actualLength == t.length()) {
                    String tempString = s.substring(l, r + 1);
                    if (tempString.length() < minSubString.length()) {
                        minSubString = tempString;
                    }

                    while (actualLength == t.length()) {
                        l++;

                        if (expected.containsKey(s.charAt(l))) {

                        }

                    }

                }

            } else {
                r++;
            }
        }

        return minSubString;
    }


}
