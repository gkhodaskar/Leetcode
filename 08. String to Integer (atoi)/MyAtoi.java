// Problem Description: https://leetcode.com/problems/string-to-integer-atoi

public int myAtoi(String s) {

    // Read in and ignore any leading whitespace.
    s = s.trim(); // Remove whitespaces
    int sign = 1, i = 0, ans = 0;

    // Eliminate empty or null strings
    if(s==null || s.isEmpty()){
        return 0;
    } else if (s.charAt(i) == '-') { // Check for minus sign
        sign = -1;
        i++;
    } else if(s.charAt(i) == '+'){ // Check for plus sign
        i++;
    }

    while(i < s.length() && Character.isDigit(s.charAt(i))){
        int tmp = s.charAt(i) - '0';
        if (ans > (Integer.MAX_VALUE - tmp) / 10){ 
            return sign > 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        ans = ans*10 + tmp;
        i++;
    }

    return ans * sign;
}
