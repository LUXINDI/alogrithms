package com.xindi.max_profit_122;

import com.xindi.Utils;

/**
 * https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/solution/mai-mai-gu-piao-de-zui-jia-shi-ji-ii-by-leetcode-s/
 */
public class Solution {
    public int maxProfit(int[] prices){
        if(prices==null || prices.length<=1) return 0;
        int[][] dp = new int[prices.length][2];
        //dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i])
        //dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i])
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        int maxP = 0;
        for(int i=1;i<prices.length;i++){
            dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i]);
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
            maxP = Math.max(Math.max(dp[i][0],dp[i][1]),maxP);
        }
        return maxP;
    }

    public int maxProfit2(int[] prices){
        if(prices==null || prices.length<=1) return 0;
        int[][] dp = new int[prices.length][2];
        //dp[i][0] = Math.max(dp[i-1][0],dp[i-1][1]+prices[i])
        //dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i])
        int dp0 = 0;
        int dp1 = -prices[0];
        for(int i=1;i<prices.length;i++){
            dp0 = Math.max(dp0,dp1+prices[i]);
            dp1 = Math.max(dp1,dp0-prices[i]);
        }
        return dp0;
    }

    public int maxProfit3(int[] prices){
        //因为次数不受限，可以把所有的上坡都收集起来
        if(prices==null || prices.length<=1) return 0;
        int ans = 0;
        for(int i=1;i<prices.length;i++){
            ans += Math.max(0, prices[i]-prices[i-1]);
        }
        return ans;
    }


    public static void main(String[] args){
        Solution sol = new Solution();
        sol.maxProfit(new int[]{7,1,5,2,6,4});
    }
}
