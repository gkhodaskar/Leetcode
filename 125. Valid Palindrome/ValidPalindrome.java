// Problem Description: https://leetcode.com/problems/valid-palindrome/

class ValidPalindrome{

    public boolean isPalindrome(String s) {

        // One pass, no regex/lowercase conversion
        // TC: O(n), SC: O(1)
        for(int i=0, j=s.length()-1; i < j; i++,j--){

            // Keep moving RIGHT until i'th char is alphanumeric
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }

            // Keep moving LEFT until j'th is alphanumeric
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }

            // If lowercase of i'th and j'th chars is not the
            // same, this string is not a palindrome
            if(Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j)))
                return false;
        }

        return true;
    }

    // Using regex to remove non-alphanumeric characters and converting string to lowercase
    // Additional overhead due to conversion
//    public boolean isPalindrome(String s) {
//
//        s = s.replaceAll("[^a-zA-Z0-9]","");
//        s = s.toLowerCase();
//        if(s.length() == 0) return true;
//
//        int left = 0;
//        int right = s.length()-1;
//
//        while(left <= right){
//            if(s.charAt(left) != s.charAt(right))
//                return false;
//            left++;
//            right--;
//        }
//
//        return true;
//    }
}