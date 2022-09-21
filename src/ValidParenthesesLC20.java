import java.util.Stack;

/**
 * <a href="https://leetcode.com/problems/valid-parentheses/">LC20. Valid Parentheses</a>
 */
public class ValidParenthesesLC20 {
    public static void main(String[] args) {
        //String s = "()[]{}";
        //String s = "()";
        //String s = "(]";
        String s = "{[]}";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '}' && !stack.empty()) {
                if ('{' != stack.pop()) {
                    return false;
                }
            } else if (s.charAt(i) == ']' && !stack.empty()) {
                if ('[' != stack.pop()) {
                    return false;
                }
            } else if (s.charAt(i) == ')' && !stack.empty()) {
                if ('(' != stack.pop()) {
                    return false;
                }
            } else {
                stack.push(s.charAt(i));
            }
        }
        return stack.empty();
    }
}