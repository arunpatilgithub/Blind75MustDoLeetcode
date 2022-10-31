/**
 * <a href="https://leetcode.com/problems/valid-palindrome/">
 * 125. Valid Palindrome</a>
 */
public class ValidPalindrome125 {

    public static void main(String[] args) {

        //String s = "A man, a plan, a canal: Panama";
        //String s = "race a car";
        //String s = " ";
        //String s = ".,";
        String s = "0P";

        System.out.println(isPalindrome(s));
    }

    private static boolean isPalindrome(String s) {

        if (s.length() == 1) {
            return true;
        }

        int l = 0;
        int r = s.length() - 1;

        while (l <= r) {


            while (l < s.length() - 1 && !isValidAlphaNumeric(s.charAt(l))) {
                l++;
            }

            if (l >= s.length()) {
                return true;
            }
            char lc = s.charAt(l);

            while (r >= 0 && !isValidAlphaNumeric(s.charAt(r))) {
                r--;
            }
            if (r < 0) {
                return true;
            }

            if (l > r) {
                return true;
            }

            char rc = s.charAt(r);


            lc = convertUpperToLowerCase(lc);
            rc = convertUpperToLowerCase(rc);

            if (lc != rc) {
                return false;
            }
            l++;
            r--;
        }

        return true;
    }

    private static boolean isValidAlphaNumeric(char c) {

        return c >= 65 && c <= 90 || c >= 97 && c <= 122 || c >= 48 && c <= 57;

    }

    private static char convertUpperToLowerCase(char c) {

        if (Character.isUpperCase(c)) {
            c = Character.toLowerCase(c);
        }
        return c;
    }

}
