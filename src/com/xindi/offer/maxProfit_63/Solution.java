package com.xindi.offer.maxProfit_63;

//可以不看，自己写出来了，比较简单
public class Solution {
    public int maxProfit(int[] prices){
        if(prices == null || prices.length==0) return 0;
        int minP = prices[0];
        int res = 0;
        for(int i=1;i<prices.length;i++){
            res = Math.max(res,prices[i]-minP);
            minP = Math.min(prices[i], minP);
        }
        return res;
    }
}
