package com.xindi.offer.hammingWeight_15;

public class Solution {
    // reference:https://leetcode-cn.com/problems/er-jin-zhi-zhong-1de-ge-shu-lcof/solution/mian-shi-ti-15-er-jin-zhi-zhong-1de-ge-shu-wei-yun/
    // time limit
    public int hammingWeight2(int n){
        int res =0;
        while(n!=0){
            res+=n&1;
            n=n>>1;
        }
        return res;
    }

    public int hammingWeight(int n){
        int res = 0;
        while(n!=0){
            n=n&(n-1);
            res++;
        }
        return res;
    }
}
