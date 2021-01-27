package com.xindi.group.anagrams_49;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs){
        //在内容相同情况下，String会hash得到相同的key，由于char[]特殊机制，相同内容的在hash后值不会相同。 因此Map中必须使用String作为key
        Map<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] mapkey = str.toCharArray();
            Arrays.sort(mapkey);
            String keystr = toStr(mapkey);
            if (!map.containsKey(keystr)){
                map.put(keystr, new ArrayList<>());
            }
            map.get(keystr).add(str);
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }
    public String toStr(char[] chararr){
        StringBuilder sb = new StringBuilder();
        for(char c:chararr){
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        sol.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }
}
