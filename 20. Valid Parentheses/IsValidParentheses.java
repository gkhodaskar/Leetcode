// Problem Description: https://leetcode.com/problems/valid-parentheses/

import java.util.Stack;
public class IsValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();


        // Push when open brace '(' '{' '['
        // Check top when closing brace ')' '}' ']'

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(!stack.isEmpty() && isAMatch(c, stack.peek())){
                stack.pop();
            }
            else stack.push(c);
        }

        return stack.isEmpty();
    }
    public boolean isAMatch(char close, char open){
        switch(close){
            case '}':
                return open == '{';
            case ']':
                return open == '[';
            case ')':
                return open =='(';
        }
        return false;
    }
}