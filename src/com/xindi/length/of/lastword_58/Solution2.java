package com.xindi.length.of.lastword_58;

/**
 * https://leetcode-cn.com/problems/length-of-last-word/solution/hua-jie-suan-fa-58-zui-hou-yi-ge-dan-ci-de-chang-d/
 */
public class Solution2 {
    public int lengthOfLastWord(String s){
        int end = s.length()-1;
        while(end>=0 && s.charAt(end) == ' '){
            end --;
        }
        if(end<0) return 0;
        int start = end;
        while(start>=0&& s.charAt(start) !=' '){
            start --;
        }
        return end-start;
    }
}
