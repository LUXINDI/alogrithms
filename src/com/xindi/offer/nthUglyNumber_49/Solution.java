package com.xindi.offer.nthUglyNumber_49;

//reference: https://leetcode-cn.com/problems/chou-shu-lcof/solution/chou-shu-ii-qing-xi-de-tui-dao-si-lu-by-mrsate/
//相当于合并三个有序数组
// dp[0]*2,dp[1]*2
// dp[0]*3,dp[1]*3
// dp[0]*5,dp[1]*5
public class Solution {
    public int nthUglyNumber(int n){
        int a=0,b=0,c=0;
        int[] dp = new int[n];
        dp[0]=1;
        for(int i=1;i<n;i++){
            int n2=dp[a]*2;
            int n3=dp[b]*3;
            int n5=dp[c]*5;
            dp[i] = Math.min(n2,Math.min(n3,n5));
            //三个并列的if，而不是if else，因为会有重复的数
            if(dp[i]==n2) a++;
            if(dp[i]==n3) b++;
            if(dp[i]==n5) c++;
        }
        return dp[n-1];
    }
}
