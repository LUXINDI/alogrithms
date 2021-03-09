package com.xindi.offer.cuttingRope_14;

public class Solution{
    //动态规划
    //reference:https://leetcode-cn.com/problems/jian-sheng-zi-lcof/solution/jian-zhi-offer-14-i-jian-sheng-zi-huan-s-xopj/
    public int cuttingRope(int n){
        //dp[i],长度为i的绳子分割为m段后的最大乘积(m>1)
        int[] dp = new int[n+1];
        dp[2] = 1;
        for(int i=3;i<n+1;i++){
            for(int j=1;j<i;j++){ //先把绳子剪掉一段
                //剩下i-j长度的绳子，可以剪也可以不剪
                //不剪：j*(i-j) 剪：j*dp[i-j]
                dp[i]=Math.max(dp[i],Math.max((i-j)*j,dp[i-j]*j));
            }
        }
        return dp[n];
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.cuttingRope(10));
    }
}
