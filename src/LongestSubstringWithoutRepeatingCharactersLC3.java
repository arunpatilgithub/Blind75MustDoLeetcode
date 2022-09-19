import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/longest-substring-without-repeating-characters/">LC3.
 * Longest Substring Without Repeating Characters</a>
 */
public class LongestSubstringWithoutRepeatingCharactersLC3 {

    public static void main(String[] args) {

        //String s = "tmmzuxt";
        String s = "b";
        //String s = "b";
        //String s = "abcabcbb";
        System.out.println(longestNonRepeatingSubString(s));
    }

    private static int longestNonRepeatingSubString(String s) {

        if (s.length() == 0) {
            return 0;
        }

        int subStringLength = 0;
        int l = 0;
        int r = 0;
        Map<Character, Integer> charPos = new HashMap<>();

        while (r < s.length()) {

            char currentCharAtRight = s.charAt(r);

            if (charPos.get(currentCharAtRight) != null && charPos.get(currentCharAtRight) >= l) {
                l = charPos.get(currentCharAtRight) + 1;
            }
            charPos.put(currentCharAtRight, r);

            subStringLength = Math.max(subStringLength, r - l + 1);
            r++;
        }

        return subStringLength;
    }
}
