package StringProblems;

import java.util.Scanner;

/*
Let **n = length of the input string**.

### Time Complexity

* The `isPalindrome` method uses two pointers (`start` and `end`).
* In each iteration of the `while` loop, both pointers move toward the center.
* The loop runs at most **n / 2** times.

**Time Complexity:**
[
\boxed{O(n)}
]

### Space Complexity

* No extra data structures are used.
* Only a few variables (`start`, `end`) are created.
* The input string itself is not counted as extra space.

**Space Complexity:**
[
\boxed{O(1)}
]

### Summary

| Aspect | Complexity |
| ------ | ---------- |
| Time   | **O(n)**   |
| Space  | **O(1)**   |

This is an **optimal solution** for checking a palindrome using the two-pointer technique.

 */
public class PalindromeCheck_0001 {
    private static boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of string:");
        String s = sc.next();
        boolean ans = isPalindrome(s);
        if (ans) {
            System.out.println("String is palindrome");
        } else {
            System.out.println("String isn't palindrome");
        }

    }
}
