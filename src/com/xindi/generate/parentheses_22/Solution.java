package com.xindi.generate.parentheses_22;

import java.util.ArrayList;
import java.util.List;

//https://leetcode-cn.com/problems/generate-parentheses/solution/hui-su-suan-fa-by-liweiwei1419/
class Solution {
    public List<String> generateParenthesis(int n){
        List<String> res = new ArrayList<>();
        dfs(0,0,n,"",res);
        return res;
    }

    public void dfs(int left, int right, int n, String curStr, List<String> res){
        if(left == n && right == n){
            res.add(curStr);
            //递归终止
            return;
        }
        if (left < right) {
            //剪枝
            return;
        }
        if (left<n){
            dfs(left+1, right, n, curStr + "(", res);
        }
        if (right<n){
            dfs(left, right+1, n , curStr + ")", res);
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        sol.generateParenthesis(3);
    }
}
