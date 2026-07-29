package LeetcodePOTD;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class SmallestPalindrome {
    private static String smallestPalindrome(String s) {
        HashMap<Character, Integer> freqMap = new HashMap<>();
        for (Character c : s.toCharArray()) {
            freqMap.put(c, freqMap.getOrDefault(c, 0) + 1);
        }
        List<Character> chars = new ArrayList<>(freqMap.keySet());
        Collections.sort(chars);
        StringBuilder left = new StringBuilder();
        char middle = '$';
        boolean hasMiddle = false;
        for (int i = 0; i < chars.size(); i++) {
            char c = chars.get(i);
            int count = freqMap.get(c);
            for (int j = 0; j < count / 2; j++) {
                left.append(c);
            }
            if (count % 2 == 1) {
                middle = c;
                hasMiddle = true;
            }
        }
        StringBuilder result = new StringBuilder(left);
        if (hasMiddle) {
            result.append(middle);
        }
        for (int i = left.length() - 1; i >= 0; i--) {
            result.append(left.charAt(i));
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String s = "bbaabb";
        System.out.println(smallestPalindrome(s));
    }
}
