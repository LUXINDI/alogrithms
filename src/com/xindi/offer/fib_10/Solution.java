package com.xindi.offer.fib_10;

public class Solution {
    // sum=a+b
    // sum%n=(a+b)%n=(a%n+b%n)%n
    public int fib(int n){
        if(n<=1) return n;
        int a=0;
        int b=1;
        for(int i=2;i<=n;i++){
            int temp = b;
            b = (a+b)%(1000000007);
            a=temp;
        }
        return b;
    }
}
