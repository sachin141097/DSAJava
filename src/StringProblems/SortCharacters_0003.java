package StringProblems;

/*
You are given a string s. Return the array of unique characters, sorted by highest to lowest occurring characters.



If two or more characters have same frequency then arrange them in alphabetic order.


Example 1

Input : s = "tree"

Output : ['e', 'r', 't' ]

Explanation :

The occurrences of each character are as shown below :

e --> 2

r --> 1

t --> 1.

The r and t have same occurrences , so we arrange them by alphabetic order.

Example 2

Input : s = "raaaajj"

Output : ['a' , 'j', 'r' ]

Explanation :

The occurrences of each character are as shown below :

a --> 4

j --> 2

r --> 1
 */
/*
⏱ Time Complexity

Building frequency map:

for (char c : s.toCharArray())


Runs once per character → O(n)

Sorting unique characters:

Collections.sort(temp, comparator)


Let k = number of unique characters

Sorting → O(k log k)

Total complexity:

O(n + k log k)


Worst case: all characters unique → k = n → O(n log n)

🧠 Space Complexity

Map stores frequencies: O(k)

List stores unique chars: O(k)

Auxiliary variables: O(1)

Total: O(k) → worst case O(n)
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.List;

public class SortCharacters_0003 {
    private static List<Character> frequencySort(String s) {
        HashMap<Character, Integer> m = new HashMap<>();
        char[] ch = s.toCharArray();
        for (char c : ch) {
            m.put(c, m.getOrDefault(c, 0) + 1);
        }
        List<Character> temp = new ArrayList<>(m.keySet());
        temp.sort((a, b) -> {
            if (m.get(a).equals(m.get(b))) {
                return a - b;// alphabetical order in case of frequency tie
            }
            return m.get(b) - m.get(a);//higher frequency first
        });
        return temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of string");
        String s = sc.next();
        List<Character> ans = frequencySort(s);
        System.out.println(ans);
    }
}
