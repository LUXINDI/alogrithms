package com.xindi.offer.reverseleftWords_58;

public class Solution {
    public String reverseLeftWords(String s, int n){
        char[] charArr = s.toCharArray();
        int len = charArr.length;
        reverse(charArr,0,len-1);
        reverse(charArr, 0, len-n-1);
        reverse(charArr,len-n,len-1);
        StringBuilder sb = new StringBuilder();
        sb.append(charArr);
        return sb.toString();
    }

    public void reverse(char[] chararr, int start, int end){
        int left = start;
        int right = end;
        while(left<right){
            swap(chararr, left, right);
            left++;
            right--;
        }
    }
    public void swap(char[] chararr, int i, int j){
        char temp = chararr[i];
        chararr[i] = chararr[j];
        chararr[j] = temp;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        sol.reverseLeftWords("abcdefg",2);
    }
}
