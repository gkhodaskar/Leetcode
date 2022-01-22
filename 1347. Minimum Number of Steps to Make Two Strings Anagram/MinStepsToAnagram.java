// Problem Description: https://leetcode.com/problems/minimum-number-of-steps-to-make-two-strings-anagram/

class MinStepsToAnagram {

    // TC: O(n), SC: O(1) -> charCount[] is constant size
    public int minSteps(String s, String t) {

        if(s.length() != t.length())
            return 0;

        int[] charCount = new int[26];

        // One-Pass
        int len = s.length();
        for(int i = 0; i < len; i++){
            // balance out the matching characters
            charCount[s.charAt(i) - 'a']++; // add for char in s
            charCount[t.charAt(i) - 'a']--; // subtract for char in t
        }
        int ans = 0;
        for(int n : charCount){
            if(n > 0) // unmatched characters
                ans += n;
        }

        return ans;
    }
}