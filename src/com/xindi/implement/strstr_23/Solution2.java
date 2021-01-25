package com.xindi.implement.strstr_23;

public class Solution2 {
    //TODO
    // KMP算法？？ https://leetcode-cn.com/problems/implement-strstr/solution/kmp-suan-fa-xiang-jie-by-labuladong/
    public int strStr(String haystack, String needle){
        if (needle.length() == 0) return 0;
        for(int p1 = 0; p1 <= haystack.length() - needle.length();p1++){
            if (haystack.charAt(p1) != needle.charAt(0)){
                continue;
            }
            int curlen = 0;
            for(int i=0;i<needle.length();i++){
                if (haystack.charAt(p1+i)!=needle.charAt(i)){
                    break;
                } else {
                    curlen ++;
                }
            }
            if (curlen == needle.length()) return p1;
        }
        return -1;
    }
}
