// Problem Description: https://leetcode.com/problems/longest-substring-without-repeating-characters

import java.util.HashMap;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() < 2)
            return s.length();

        int result = 0;

        // Method I: Using hashset with sliding window
        // O(n) Time and Space

        // int left = 0, right = 0;
        // HashSet<Character> set = new HashSet<>();
        // while(right <= s.length()){
        //     if(right == s.length()){
        //         return Math.max(result,right - left);
        //     }
        //     if(set.contains(s.charAt(right))){
        //         // String tmp = s.substring(left, right);
        //         result = Math.max(result, right - left);
        //         left++;
        //         right = left;
        //         set.clear();
        //     } else{
        //         set.add(s.charAt(right));
        //         right++;
        //     }
        // }

        // Method II: Using HashMap to keep track of indices of the last occurence of
        // each character (Optimized Method I)
        // O(n) Time and Space
        HashMap<Character, Integer> hm = new HashMap<>();

        for (int j = 0, i = 0; j < s.length(); j++) {
            if (hm.containsKey(s.charAt(j))) {
                i = Math.max(hm.get(s.charAt(j)), i);
            }

            result = Math.max(result, j - i + 1);
            hm.put(s.charAt(j), j + 1);
        }
        return result;

    }
}