package com.xindi.longestCommonPrefix;

public class Solution {
    public String longestCommonPrefix(String[] strs){
        if (strs == null || strs.length == 0) return "";
        String ans = strs[0];
        for(int i=1;i<strs.length;i++){
            ans = findCPrefix(ans, strs[i]);
            if (ans.equals("")){
                break;
            }
        }
        return ans;
    }

    public String findCPrefix(String s1, String s2){
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<Math.min(s1.length(), s2.length());i++){
            if (s1.charAt(i) == s2.charAt(i)){
                sb.append(s1.charAt(i));
            }else{
                break;
            }
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        sol.longestCommonPrefix(new String[]{"flower","flow","flight"});
    }
}
