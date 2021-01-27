package com.xindi.group.anagrams_49;

import java.util.*;

public class Solution2 {
    public List<List<String>> groupAnagrams(String[] strs){
        Map<String,List<String>> map = new HashMap<>();
        for(String str:strs){
            char[] mapkey = str.toCharArray();
            Arrays.sort(mapkey);
            String keystr = new String(mapkey);
            List<String> list = map.getOrDefault(keystr, new ArrayList<String>());
            list.add(keystr);
            map.put(keystr,list);
        }
        List<List<String>> res = new ArrayList<>();
        for(Map.Entry<String, List<String>> entry: map.entrySet()){
            res.add(entry.getValue());
        }
        return res;
    }

    public static void main(String[] args){
        Solution2 sol = new Solution2();
        sol.groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"});
    }
}
