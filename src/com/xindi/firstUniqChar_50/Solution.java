package com.xindi.firstUniqChar_50;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// reference:https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof/solution/mian-shi-ti-50-di-yi-ge-zhi-chu-xian-yi-ci-de-zi-3/
public class Solution {
    public char firstUniqChar2(String s){
        Map<Character,Boolean> map = new HashMap<>();
        char[] sc = s.toCharArray();
        for(char c:sc){
            map.put(c,!map.containsKey(c));
        }
        for(char c:sc){
            if(map.get(c)) return c;
        }
        return ' ';
    }

    public char firstUniqChar(String s){
        //有序哈希表
        Map<Character,Boolean> map = new LinkedHashMap<>();
        char[] sc = s.toCharArray();
        for(char c:sc){
            map.put(c,!map.containsKey(c));
        }
        //遍历次数变少了
        for(Map.Entry<Character,Boolean> entry:map.entrySet()){
            if(entry.getValue()) return entry.getKey();;
        }
        return ' ';
    }
}
