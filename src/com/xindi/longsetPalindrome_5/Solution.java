package com.xindi.longsetPalindrome_5;

public class Solution {
    public String longestPalindrome(String s){
        int maxAns = 0;
        String ans = "";
        for(int i=0;i<s.length();i++){
            int left = i;
            int right = i;
            char alpha = s.charAt(i);
            while(left>=0 && s.charAt(left) == alpha){
                left --;
            }
            while(right<s.length() && s.charAt(right) == alpha){
                right ++;
            }
            while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
                right ++;
                left --;
            }
            if (maxAns < (right-1)-(left+1)+1){
                maxAns = right - 1 - left;
                ans = s.substring(left+1, right);
            }
        }
        return ans;
    }

    public String longestPalindrome2(String s) {
        if(s == null||s.length()==0){
            return "";
        }
        // 从 l到r是否为回文
        boolean[][] dp = new boolean[s.length()][s.length()];
        int maxLen = 1;
        int maxStart = 0;
        int maxEnd = 0;
        for(int r=1;r<s.length();r++){
            for(int l=r;l>=0;l--){
                if(s.charAt(l)==s.charAt(r)&&(r-l<=2||dp[l+1][r-1])){
                    dp[l][r]=true;
                    if(r-l+1>maxLen){
                        maxStart = l;
                        maxEnd = r;
                        maxLen = r-l+1;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd+1);
    }
}
