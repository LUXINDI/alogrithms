package com.xindi.myPow_16;

public class Solution {
    public double myPow(double x, int n){
        if(n>0){
            return mul(x,n);
        }else{
            return 1/mul(x,-n);
        }
    }

    public double mul(double x, int n){
        if(n==0) return 1;
        double res = mul(x,n/2);
        if(n%2==0){
            return res*res;
        }else{
            return res*res*x;
        }
    }
}
