package com.xindi.generate.parentheses_22;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    List<String> res = new ArrayList<>();
    StringBuilder sb = new StringBuilder();
    public List<String> generateParenthesis(int n){
        dfs(0,0,n);
        return res;
    }

    public void dfs(int left, int right, int n){
        if(sb.length() == 2*n){
            res.add(sb.toString());
            return;
        }
        if(left<right) return;
        if (left<n){
            sb.append("(");
            dfs(left+1, right, n);
            sb.deleteCharAt(sb.length()-1);
        }
        if (right<n){
            sb.append(")");
            dfs(left, right+1, n);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
