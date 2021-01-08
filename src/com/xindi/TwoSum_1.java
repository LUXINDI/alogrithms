package com.xindi;

import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> freq = new HashMap<>();
        for(int num : nums){
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : freq.entrySet()){
            int n = entry.getKey();
            int cnt = entry.getValue();
            if (target-n == n && cnt >= 2){
                return new int[]{n,n};
            }
            if (freq.containsKey(target-n)){
                return new int[]{n, target-n};
            }
        }
        return new int[]{};
    }
}
