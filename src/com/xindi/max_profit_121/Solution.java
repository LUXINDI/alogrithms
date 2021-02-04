package com.xindi.max_profit_121;

public class Solution {
    public int maxProfit(int[] prices){
        if(prices == null || prices.length<=1) return 0;
        int minPrice = prices[0];
        int maxP = 0;
        for(int i=1;i<prices.length;i++){
            maxP = Math.max(prices[i]-minPrice,maxP);
            minPrice = Math.min(prices[i],minPrice);
        }
        return maxP;
    }
}
