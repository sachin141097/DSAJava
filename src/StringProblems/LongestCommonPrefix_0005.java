package StringProblems;

/*
Write a function to find the longest common prefix string amongst an array of strings.



If there is no common prefix, return an empty string "".


Example 1

Input : str = ["flowers" , "flow" , "fly", "flight" ]

Output : "fl"

Explanation :

All strings given in array contains common prefix "fl".

Example 2

Input : str = ["dog" , "cat" , "animal", "monkey" ]

Output : ""

Explanation :

There is no common prefix among the given strings in array.

Example 3

Input : str = ["lady" , "lazy"]

Output:

"la"
 */
/*
For str = ["flowers", "flow", "fly", "flight"]:

n = 4 strings
m = 3 (shortest is "fly")
Operations ≈ 4 × 3 = 12 character comparisons maximum
Time Complexity: O(N*M)
 */
public class LongestCommonPrefix_0005 {
    private static String LongestCommonPrefix(String[] str) {
        String first = str[0];
        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            for (int j = 1; j < str.length; j++) {
                if (i >= str[j].length()) {
                    return first.substring(0, i);
                }
                if (str[j].charAt(i) != c) {
                    //char mismatch
                    return first.substring(0, i);
                }
            }
        }
        return first;
    }

    public static void main(String[] args) {
        String[] str = {"flowers", "flow", "fly", "flight"};
        System.out.println(LongestCommonPrefix(str));

    }
}
