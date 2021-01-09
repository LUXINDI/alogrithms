package com.xindi.letter.combinations_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {
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
    StringBuilder sb = new StringBuilder();
    List<String> res = new ArrayList<>();

    public List<String> letterCombinations(String digits){
        if (digits == null || digits.length() == 0) return res;
        dfs(digits, 0);
        return res;
    }

    public void dfs(String digits, int index){
        if(index == digits.length()){
            res.add(sb.toString());
            return;
        }
        char alpha = digits.charAt(index);
        for(char c : map.get(alpha).toCharArray()){
            sb.append(c);
            dfs(digits, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
