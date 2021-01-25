package com.xindi.divide.two.integers_29;

public class Solution {
    //int 范围 [-2**31, 2**31-1]
    int c = 0;
    public int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;
        if(divisor == 1) return dividend;
        if(divisor == -1 && dividend == Integer.MIN_VALUE) return Integer.MAX_VALUE;

        int res = div(Math.abs((long) dividend), Math.abs((long) divisor));
        int sign = (dividend<0 && divisor<0) || (dividend>0 && divisor>0) ? 1 : -1;
        return res * sign;
    }

    public int div(long dividend, long divisor){
        if(dividend < divisor) return 0;
        int count = 1;
        long curSum = divisor;
        while(curSum<=dividend){
            c ++;
            curSum = curSum + curSum;
            count = count + count;
        }
        return count + div(dividend - curSum, divisor);
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        sol.divide(256, 5);
        System.out.println(sol.c);
        // O(log(dividene/divisor))
    }
}
