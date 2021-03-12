package com.xindi.offer.reverseWords_58;

//参考答案写的
//reference:https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/solution/mian-shi-ti-58-i-fan-zhuan-dan-ci-shun-xu-shuang-z/
public class Solution {
    public String reverseWords(String s){
        s = s.trim();
        StringBuilder sb = new StringBuilder();
        int j=s.length()-1;
        int i=j;
        while(i>=0){
            while(i>=0&&s.charAt(i)!=' '){
                i--;
            }
            String cur = s.substring(i+1,j+1);
            sb.append(cur);
            sb.append(' ');
            while(i>=0&&s.charAt(i)==' '){
                i--;
            }
            j=i;
        }
        return sb.toString().trim();
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        sol.reverseWords("  hello world!  ");
    }
}
