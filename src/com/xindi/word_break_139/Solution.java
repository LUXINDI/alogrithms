package com.xindi.word_break_139;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/word-break/solution/shou-hui-tu-jie-san-chong-fang-fa-dfs-bfs-dong-tai/
 */
public class Solution {
    public boolean wordBreak(String s, List<String> wordDict){
        //dp[i] 长度为i的S[0,i-1]能否拆分成单词
        // dp[j]:s[0,j-1]能拆分,s[j,i-1]在单词表里
        Set<String> wordSet = new HashSet<>(wordDict);
        int n = s.length();
        boolean[] dp = new boolean[n+1];
        dp[0] = true;
        for(int i=1;i<=n;i++){
            for(int j=0;j<i;j++){
                String w = s.substring(j,i);
                if(dp[j] && wordSet.contains(w)){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
