package com.xindi;

public class LongestPalindrome {
    //中心扩散
    public static String LongestPalindrome(String s){
        if (s==null || s.length()==0){
            return "";
        }
        int maxLen = 0;
        int maxStart = 0;
        for(int i=0; i<s.length(); i++){
            int left = i-1;
            int right = i+1;
            int len = 1;
            while(left>=0 && s.charAt(left) == s.charAt(i)){
                left --;
                len ++;
            }
            while(right<s.length() && s.charAt(right) == s.charAt(i)){
                right ++;
                len++;
            }
            while(left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
                len = len+2;
                left --;
                right++;
            }
            if (len>=maxLen){
                maxStart = left+1;
                maxLen = len;
            }
        }
        return s.substring(maxStart, maxStart + maxLen);
    }

    public static String LongestPalindrome2(String s){
        if (s==null || s.length() ==0){
            return "";
        }
        boolean dp[][] = new boolean[s.length()][s.length()]; //表示字符串从 i 到 j 这段是否为回文。
        int maxLen = 1;
        int maxStart = 0;
        int maxEnd = 0;
        for(int r=1;r<s.length();r++){
            for(int l=r;l>=0;l--){
                if(s.charAt(l) == s.charAt(r) && (r-l<=2 || dp[l+1][r-1])){
                    dp[l][r] = true;
                    if (r-l+1 > maxLen){
                        maxLen = r-l+1;
                        maxStart = l;
                        maxEnd = r;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd+1);
    }

    public static void main(String[] args){
        String s = LongestPalindrome2("aacabdkacaa");
        System.out.println(s);
    }
}
