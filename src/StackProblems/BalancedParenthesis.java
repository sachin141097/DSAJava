package StackProblems;

/*
Given string str containing just the characters '(', ')', '{', '}', '[' and ']', check if the input string is valid and return true if the string is balanced otherwise return false.


Example 1

Input: str = “()[{}()]”

Output: True

Explanation: As every open bracket has its corresponding close bracket. Match parentheses are in correct order hence they are balanced.

Example 2

Input: str = “[()”

Output: False

Explanation: As ‘[‘ does not have ‘]’ hence it is not valid and will return false.
 */
/*
Time Complexity: O(N)
Space Complexity: O(N) // in worst case all brackets are opening
 */

import java.util.Stack;


public class BalancedParenthesis {

    private static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        //Traverse each char in a string
        for (Character c : s.toCharArray()) {
            //If char is opening push to stack
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else {
                //If stack is empty no matching closing bracket
                if (st.isEmpty()) {
                    return false;
                }
                char top = st.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        return st.isEmpty();
    }

    public static void main(String[] args) {
        String s1 = "()[]{}";
        String s2 = "([)]";
        String s3 = "({";
        System.out.println(isValid(s1));
        System.out.println(isValid(s2));
        System.out.println(isValid(s3));

    }
}
