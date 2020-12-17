package com.xindi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinations2 {
    private Map<Character,String> map = new HashMap<Character, String>(){{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};
    private List<String> res = new ArrayList<>();
    private StringBuilder sb = new StringBuilder();

    public List<String> letterCombinations(String digits){
        if (digits == null || digits.length() ==0) return res;
        backtrack(digits,0);
        return res;
    }

    private void backtrack(String digits, int index){
        if (digits.length() == index) {
            res.add(sb.toString());
            return;
        }
        String val = map.get(digits.charAt(index));
        for(char c : val.toCharArray()){
            sb.append(c);
            backtrack(digits, index+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

}
