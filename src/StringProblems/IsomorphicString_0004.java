package StringProblems;

import java.util.HashMap;

/*
Given two strings s and t, determine if they are isomorphic. Two strings s and t are isomorphic if the characters in s can be replaced to get t.



All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.


Example 1

Input : s = "egg" , t = "add"

Output : true

Explanation :

The 'e' in string s can be replaced with 'a' of string t.

The 'g' in string s can be replaced with 'd' of t.

Hence all characters in s can be replaced to get t.

Example 2

Input : s = "apple" , t = "bbnbm"

Output : false

Explanation :

Strings are matched index by index.

At index 0, 'a' maps to 'b'.

At index 1, 'p' also maps to 'b'.

This is invalid because two different characters (a and p) cannot map to the same character (b) in a one-to-one mapping.

Therefore, no valid mapping exists and the output is false.

 */
/*
Time Complexity: O(n)
Space Complexity: O(n)
 */
public class IsomorphicString_0004 {
    private static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        //Map to store mapping from chracters of s->characters of T
        HashMap<Character, Character> mapST = new HashMap<>();

        //Map to track which characters in T are already used
        HashMap<Character, Boolean> usedT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if (mapST.containsKey(c1)) {
                //check if existing mapping matches current character
                if (mapST.get(c1) != c2) {
                    return false;
                }
            } else {
                //If c2 is used by some other character
                //s="ab",t="aa"
                if (usedT.containsKey(c2)) {
                    return false;
                }
                mapST.put(c1, c2);
                //mark c2 as used
                usedT.put(c2, true);
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isIsomorphic("egg", "add"));
        System.out.println(isIsomorphic("paper", "title"));
        System.out.println(isIsomorphic("apple", "bbnbm"));
        System.out.println(isIsomorphic("ab", "aa"));
    }
}
