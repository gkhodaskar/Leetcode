// Problem Description: https://leetcode.com/problems/generate-parentheses/

class GenerateParanthesis {
    ArrayList<String> result;
    StringBuilder sb;

    public List<String> generateParenthesis(int n){
        result=new ArrayList<>();
        sb=new StringBuilder();
        generateParantheses(0,0,n);

        return result;
    }

    private void generateParantheses(int open,int close,int n){
        if(sb.length()==2*n){
            result.add(sb.toString());
            return;
        }

        if(open<n){
            sb.append("(");
            generateParantheses(open+1,close,n);
            sb.deleteCharAt(sb.length()-1);
        }

        if(close<open){
            sb.append(")");
            generateParantheses(open,close+1,n);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}