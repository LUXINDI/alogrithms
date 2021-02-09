package com.xindi.word_break_139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution2 {
    Set<String> wordSet = new HashSet<>();
    boolean res = false;
    int n;
    public boolean wordBreak(String s, List<String> wordDict){
        wordSet = new HashSet<>(wordDict);
        n = s.length();
        int[] memo = new int[n];
        return dfs(s,0, memo);
    }
    //判断s[start,n-1]能否break
    public boolean dfs(String s, int start, int[] memo){
        if(start == n){
            return true;
        }
        if(memo[start]!=0) return memo[start]==1;
        for(int i=start+1;i<=n;i++){
            String w = s.substring(start,i);
            if(wordSet.contains(w) && dfs(s,i, memo)){
                memo[start] = 1;
                return true;
            }
        }
        memo[start] = -1;
        return false;
    }
}
