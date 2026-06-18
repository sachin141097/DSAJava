package StackQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Time Complexity: O(N^2)
 */
public class AsteroidCollisonBruteForce {
    private static int[] asteroidCollison(int[] arr) {
        List<Integer> list = new ArrayList<>();
        for (int a : arr) {
            list.add(a);
        }
        boolean changed = true;
        while (changed) {
            changed = false;
            for (int i = 0; i < list.size() - 1; i++) {
                int left = list.get(i);
                int right = list.get(i + 1);
                // Collision occurs only when left moves right and right moves left
                if (left > 0 && right < 0) {
                    changed = true;
                    if (Math.abs(left) > Math.abs(right)) {
                        list.remove(i + 1);//right asteroid destroyed
                    } else if (Math.abs(left) < Math.abs(right)) {
                        list.remove(i);//left asteroid destroyed
                    } else {
                        list.remove(i);
                        list.remove(i + 1);//both destroyed
                    }
                    break;
                }
            }
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ans[i] = list.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {5, 10, -5};

        System.out.println(Arrays.toString(asteroidCollison(arr)));
    }
}
