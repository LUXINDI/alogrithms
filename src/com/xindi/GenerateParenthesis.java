package com.xindi;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n==0) return res;
        backTrack(n,n, n, new StringBuilder());
        return res;
    }

    public void backTrack(int left, int right, int n, StringBuilder sb){
        if(sb.length()==2*n){
            res.add(sb.toString());
            return;
        }
        if(left>0){
            sb.append('(');
            backTrack(left-1,right,n, sb);
        }
        if(right>left){
            sb.append(')');
            backTrack(left,right-1,n, sb);
        }
    }

    public static void main(String[] args) {
        GenerateParenthesis sol = new GenerateParenthesis();
        List<String> res = sol.generateParenthesis(3);
        for (String s:res){
            System.out.println(s);
        }
    }
}
