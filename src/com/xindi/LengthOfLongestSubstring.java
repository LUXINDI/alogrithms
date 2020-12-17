package com.xindi;

import java.util.HashMap;
import java.util.Map;

public class LengthOfLongestSubstring {
    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        int length = s.length();
        for(int start=0, end=0;end<length;end++){
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)){
                start = Math.max(map.get(alpha)+1,start);
            }
            map.put(alpha,end);
            max = Math.max(end-start+1, max);
        }
        return max;

    }

    public static void main(String[] args){
        int max = lengthOfLongestSubstring("abcaacdgsakd");
    }
}
