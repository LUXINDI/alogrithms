package com.xindi.offer.printNumbres_17;

public class Solution {
    public int[] printNumbers(int n){
        int maxNum = 0;
        for(int i=1;i<=n;i++){
            maxNum = maxNum*10+9;
        }
        int[] res = new int[maxNum];
        for(int i=1;i<=maxNum;i++){
            res[i-1] = i;
        }
        return res;
    }
}
