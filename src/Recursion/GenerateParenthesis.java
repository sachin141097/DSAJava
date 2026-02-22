package Recursion;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

public class GenerateParenthesis {
    private static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (Character c : s.toCharArray()) {
            if (c == '(') {
                st.push(c);
            } else {
                if (st.isEmpty()) {
                    return false;
                }
                char top = st.pop();
                if (c == ')' && top != '(') return false;
            }
        }
        return st.isEmpty();
    }

    private static void generateAll(String current, int n, List<String> result) {
        if (current.length() == 2 * n) {
            if (isValid(current)) {
                result.add(current);
            }
            return;
        }
        generateAll(current + "(", n, result);
        generateAll(current + ")", n, result);

    }

    public static List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        generateAll("", n, result);
        return result;

    }

    public static void main(String[] args) {
        int n = 3;
        List<String> ans = generateParenthesis(n);
        System.out.println(ans);

    }
}
