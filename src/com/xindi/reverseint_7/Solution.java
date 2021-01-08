package com.xindi.reverseint_7;

public class Solution {
    public int reverse(int x){
        long ans = 0;
        while(x!=0){
            ans = ans * 10 + x%10;
            x = x/10;
        }
        return (int)ans == ans ? (int)ans : 0;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        sol.reverse(-120);
    }
}
