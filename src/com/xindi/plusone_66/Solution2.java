package com.xindi.plusone_66;

public class Solution2 {
    public int[] plusOne(int[] digits){
        for(int i = digits.length-1;i>=0;i--){
            digits[i] ++;
            digits[i] = digits[i]%10;
            if(digits[i]%10!=0){
                return digits;
            }
        }
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }
    public static void main(String[] args){
        Solution2 sol = new Solution2();
        sol.plusOne(new int[]{9,9,9});
    }

}
