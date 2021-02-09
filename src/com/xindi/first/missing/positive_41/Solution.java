package com.xindi.first.missing.positive_41;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int firstMissingPositive(int[] nums){
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            set.add(num);
        }
        for(int i=1;i<=nums.length;i++){
            if(!set.contains(i)){
                return i;
            }
        }
        return nums.length+1;
    }
}
