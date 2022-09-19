/**
 * <a href="https://leetcode.com/problems/longest-palindromic-substring/">LC5. Longest Palindromic Substring</a>
 */
public class LongestPalindromicSubstringLC5 {

    public static void main(String[] args) {

        String s = "a";

        System.out.println(longestPalindromicSubstring(s));
    }

    private static String longestPalindromicSubstring(String s) {

        String longestPalindrome = "";

        for (int i = 0; i < s.length(); i++) {
            String oddPalindromeSubString = getPalindrome(s, i, i);
            String evenPalindromeSubString = getPalindrome(s, i, i + 1);

            String temp = oddPalindromeSubString.length() > evenPalindromeSubString.length() ? oddPalindromeSubString :
                    evenPalindromeSubString;

            longestPalindrome = longestPalindrome.length() > temp.length() ? longestPalindrome : temp;

        }
        return longestPalindrome;
    }

    private static String getPalindrome(String s, int l, int r) {

        String palindrome = "";
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            palindrome = s.substring(l, r + 1);
            l--;
            r++;
        }

        return palindrome;

    }
}
