package com.xindi.length.of.lastword_58;

public class Solution {
    public int lengthOfLastWord(String s){
        int len = 0;
        int temp = 0;
        for(int i=0;i<s.length();){
            while(s.charAt(i)==' '&& i<s.length()-1 && s.charAt(i+1)==' '){
                i++;
            }
            if(s.charAt(i)==' '){
                temp = len;
                len = 0;
            }else{
                len++;
            }
            i++;
        }
        return len>0?len:temp;
    }
}
