import java.util.HashMap;

/**
 * <a href="https://leetcode.com/problems/minimum-window-substring/">76. Minimum Window Substring</a>
 */
public class MinimumWindowSubstring76 {

    public static void main(String[] args) {

        String s = "ADOBECODEBANC";
        String t = "ABC";

        System.out.println(minWindow(s, t));
    }

    //Not my solution. Need to re-visit this.
    private static String minWindow(String s, String t) {

        HashMap<Character, Integer> map = new HashMap<>();

        for (char x : t.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int matched = 0;
        int start = 0;
        int minLen = s.length() + 1;
        int subStr = 0;
        for (int endWindow = 0; endWindow < s.length(); endWindow++) {
            char right = s.charAt(endWindow);
            if (map.containsKey(right)) {
                map.put(right, map.get(right) - 1);
                if (map.get(right) == 0) matched++;
            }

            while (matched == map.size()) {
                if (minLen > endWindow - start + 1) {
                    minLen = endWindow - start + 1;
                    subStr = start;
                }
                char deleted = s.charAt(start++);
                if (map.containsKey(deleted)) {
                    if (map.get(deleted) == 0) matched--;
                    map.put(deleted, map.get(deleted) + 1);
                }
            }
        }
        return minLen > s.length() ? "" : s.substring(subStr, subStr + minLen);
    }

//    private static String minWindow(String s, String t) {
//
//        int l = 0;
//        int r = 0;
//
//        String minSubString = s;
//
//        Map<Character, Integer> actual = new HashMap<>();
//        Map<Character, Integer> expected = new HashMap<>();
//
//        for (int i = 0; i < t.length(); i++) {
//            expected.put(t.charAt(i), expected.getOrDefault(t.charAt(i), 0) + 1);
//        }
//
//        int actualLength = 0;
//
//        while (r < s.length()) {
//            if (expected.containsKey(s.charAt(r))) {
//                actual.put(s.charAt(r), actual.getOrDefault(s.charAt(r), 0) + 1);
//
//                if (actual.getOrDefault(s.charAt(r), 0) < expected.get(s.charAt(r))) {
//                    actualLength++;
//                }
//
//
//                if (actualLength == t.length()) {
//                    String tempString = s.substring(l, r + 1);
//                    if (tempString.length() < minSubString.length()) {
//                        minSubString = tempString;
//                    }
//
//                    actual.put(s.charAt(l), actual.get(s.charAt(l)) - 1);
//                    actualLength--;
//                    l++;
//                    r++;
//
//                    while (!actual.containsKey(s.charAt(l)) && l < s.length()) {
//                        l++;
//                    }
//
//                } else {
//                    r++;
//                }
//
//            } else {
//                r++;
//            }
//        }
//
//        return minSubString;
//    }


}
