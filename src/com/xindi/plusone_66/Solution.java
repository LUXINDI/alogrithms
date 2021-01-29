package com.xindi.plusone_66;

import java.util.ArrayList;
import java.util.List;

class Solution {
    //错误的解法
    public int[] plusOne(int[] digits) {
        //注意结果溢出
        long res = 0;
        for(int i=0;i<digits.length;i++){
            res = res*10+digits[i];
        }
        res ++;
        List<Integer> list = new ArrayList<>();
        while(res>0){
            list.add((int)(res%10));
            res = res/10;
        }
        int n = list.size();
        int[] finalRes = new int[n];
        for(int i=0;i<n;i++){
            finalRes[i] = list.get(n-i-1);
        }
        return finalRes;
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        sol.plusOne(new int[]{9,8,7,6,5,4,3,2,1,0});
    }
}
