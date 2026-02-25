package Recursion;

/*
 * Time Complexity:
 * ----------------
 * There are 2 choices (include/exclude) for each character.
 * So total recursive calls = 2^n
 *
 * Printing each subsequence takes O(n) time in worst case.
 *
 * Therefore overall time complexity = O(n * 2^n)
 *
 *
 * Space Complexity:
 * -----------------
 * Recursion stack depth = O(n)
 * StringBuilder stores at most n characters = O(n)
 *
 * Auxiliary space = O(n)
 * (Ignoring space used for output)
 */
public class PrintAllSubSequences {
    private static void generateSubSequences(String str, int index, StringBuilder current) {
        //base case
        if (index == str.length()) {
            System.out.println(current.toString());
            return;
        }
        //choice 1 include current character
        current.append(str.charAt(index));//choose
        generateSubSequences(str, index + 1, current);//explore
        current.deleteCharAt(current.length() - 1);//un-choose(backtrack)
        //choice 2 exclude current character
        generateSubSequences(str, index + 1, current);

    }

    public static void main(String[] args) {
        String str = "abc";
        generateSubSequences(str, 0, new StringBuilder());
    }
}
