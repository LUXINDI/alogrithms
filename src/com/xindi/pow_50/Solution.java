package com.xindi.pow_50;

public class Solution {
    public double myPow(double x, int n){
        if (n>0){
            return quickMul(x,n);
        } else {
            return 1/quickMul(x,-n);
        }
    }

    public double quickMul(double x, int n){
        if (n==0) return 1;
        double res = quickMul(x, n/2);
        if (n%2==0){
            return res*res;
        } else {
            return res*res*x;
        }
    }
}
