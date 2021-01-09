package com.xindi.valid.parentheses_20;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution2 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<Character, Character>(){{
            put('}','{');
            put(']','[');
            put(')','(');
        }};
        for(char c:s.toCharArray()){
            if (!map.containsKey(c)){
                stack.push(c);
            } else{
                if (stack.isEmpty()) return false;
                if (stack.pop()!= map.get(c)) return false;
            }
        }
        if (!stack.isEmpty()) return false;
        return true;
    }
}
