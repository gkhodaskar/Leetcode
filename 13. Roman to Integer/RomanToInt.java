// Problem Description: https://leetcode.com/problems/roman-to-integer

import java.util.HashMap;

public class RomanToInt {

    public int romanToInt(String s) {

        // Create dictionary to hold standard roman character and their values
        HashMap<Character, Integer> hm = new HashMap<Character, Integer>() {{
            put('I', 1);
            put('V', 5);
            put('X', 10);
            put('L', 50);
            put('C', 100);
            put('D', 500);
            put('M', 1000);
        }};

        // Add value of last element to answer
        int answer = hm.get(s.charAt(s.length() - 1));

        for (int i = s.length() - 2; i >= 0; i--) {
            // If this character's value is smaller than the next character's value, subtract --> applies to numbers like 4, 9, 40, 90 etc
            if (hm.get(s.charAt(i)) < hm.get(s.charAt(i + 1)))
                answer -= hm.get(s.charAt(i));
            else // Otherwise add the value of this character
                answer += hm.get(s.charAt(i));
        }
        return answer;

    }
}