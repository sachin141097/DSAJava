package StackQueue;

import java.util.Stack;

public class BalancedParenthesis {
    private static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                st.push(c);
                continue;
            }
            // it's a closer — something must be on top to match it
            if (st.isEmpty()) {
                return false; // nothing open, closing nothing — invalid
            }
            char top = st.pop();
            if (c == ')' && top != '(') return false;
            if (c == '}' && top != '{') return false;
            if (c == ']' && top != '[') return false;
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s = "({})";
        System.out.println(isValid(s));
    }
}
