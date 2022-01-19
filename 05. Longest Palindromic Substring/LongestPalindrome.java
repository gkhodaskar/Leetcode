int resultStart;
int resultLength;
public String longestPalindrome(String s) {

    if(s.length() < 2) return s;

    // Time: O(N^2), Space: O(1)
    for(int i = 0; i < s.length(); i++){
        // get longest odd length palindrome with curr character as center
        expandPalindrome(s,i,i); 

        // get longest even length palindrome
        expandPalindrome(s,i,i+1); 

    }

    return s.substring(resultStart, resultStart+resultLength);

}

public void expandPalindrome(String s, int start, int end){
    int n = s.length();
    StringBuilder sb = new StringBuilder();

    while(start >= 0 && end < n && s.charAt(start) == s.charAt(end)){
        start--;
        end++;
    }

    if(resultLength < end-start-1){
        resultStart = start+1;
        resultLength = end-start-1;
    }
}
