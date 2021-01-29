package com.xindi.sqrt_69;

public class Solution {
    // find last position ^2 <= x
    // 注意mid*mid溢出的情况
    public int mySqrt(int x){
        if(x==1) return 1;
        int left = 1;
        int right = x;
        while(left+1<right){
            int mid = left + (right-left)/2;
            if ((long)mid*mid == x) return mid;
            if((long)mid*mid<=x){
                left = mid;
            }else{
                right = mid-1;
            }
        }
        return (long)right*right<=x ? right : left;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        sol.mySqrt(2147483647);
    }
}
