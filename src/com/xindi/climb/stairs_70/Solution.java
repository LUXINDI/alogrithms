package com.xindi.climb.stairs_70;

public class Solution {
    public int climbStairs(int n){
        //dp[n] = dp[n-1] + dp[n-2]
        // dp[0] =1 dp[1] =1 dp[2]=2 dp[3]=3
        if(n<2) return 1;
        int a = 1;
        int b = 1;
        for(int i =2;i<=n;i++){
            int temp = b;
            b = a+b;
            a= temp;
        }
        return b;
    }
}
