package com.xindi.group.anagrams_49;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution3 {
    public List<List<String>> groupAnagrams(String[] strs){
        Map<String,List<String>> map = new HashMap<>();
        for(String str : strs){
            int[] counts = new int[26];
            for(char c:str.toCharArray()){
                counts[c-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<26;i++){
                if(counts[i]>0){
                    sb.append(i+'a');
                    sb.append(counts[i]);
                }
            }
            List<String> list = map.getOrDefault(sb.toString(),new ArrayList<>());
            list.add(str);
            map.put(sb.toString(),list);
        }
        return new ArrayList<>(map.values());
    }
}
