package SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubStringWithoutRepeatingChars {
    private static int lengthOfLongestSubString(String s) {
        int left = 0;
        int maxLen = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            freqMap.put(s.charAt(right), freqMap.getOrDefault(s.charAt(right), 0) + 1);
            while (freqMap.get(s.charAt(right)) > 1) {
                freqMap.put(s.charAt(left), freqMap.get(s.charAt(left)) - 1);
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubString(s));
    }
}
