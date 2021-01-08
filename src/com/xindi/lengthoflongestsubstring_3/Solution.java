package com.xindi.lengthoflongestsubstring_3;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s){
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0;
        // start不动，end后移
        for(int start=0, end=0; end<s.length();end++){
            char alpha = s.charAt(end);
            if(map.containsKey(alpha)){
                //锁定起点，考虑窗口内有重复字母的情况，如 abba
                // 是因为在滑动过程中会出现当前loop出现的重复元素之间的区间，可能还有其他元素也是重复的。（如果仅仅 j =map.get(s.charAt(i)) 则你会忽略两个重复元素之间还有的其他元素也是重复的，例如abba
                start = Math.max(map.get(alpha) + 1,start);
            }
            ans = Math.max(end-start+1,ans);
            map.put(alpha, end);
        }
        return ans;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        sol.lengthOfLongestSubstring("abba");
    }
}
