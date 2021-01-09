package com.xindi.letter.combinations_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    Map<Character, String> map = new HashMap<Character, String>(){
        {
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
    public List<String> letterCombinations(String digits){
        List<String> res = new ArrayList<>();
        if(digits == null || digits.length() == 0) return res;
        dfs("", res, digits,0);
        return res;
    }

    public void dfs(String curStr, List<String> res, String digits, int index){
        if(curStr.length() == digits.length()){
            res.add(curStr);
            return;
        }
        if (index >= digits.length()) return;
        char alpha = digits.charAt(index);
        for(char c:map.get(alpha).toCharArray()){
            dfs(curStr + c, res, digits, index +1);
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        sol.letterCombinations("23");
    }
}
