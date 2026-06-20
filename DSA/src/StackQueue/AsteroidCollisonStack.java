package StackQueue;

import java.util.Arrays;
import java.util.Stack;

/*
Time Complexity: O(N)
 */
public class AsteroidCollisonStack {
    private static int[] asteroidCollisonStack(int[] arr) {
        Stack<Integer> st = new Stack<>();
        for (int a : arr) {
            if (survives(a, st)) {
                st.push(a);
            }
        }
        int[] result = new int[st.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = st.pop();
        }
        return result;
    }

    private static boolean survives(int a, Stack<Integer> st) {
        while (a < 0 && !st.isEmpty() && st.peek() > 0) {
            int top = st.peek();
            if (top < -a) {
                st.pop(); // top loses, keep fighting the next one down
            } else if (top == -a) {
                st.pop(); //both destroyed
                return false;
            } else {
                return false; //a destroyed top survives
            }
        }
        return true; //nothing left to fight a survives
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, -5};
        System.out.println(Arrays.toString(asteroidCollisonStack(arr)));
    }
}
