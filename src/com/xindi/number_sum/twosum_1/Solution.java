package com.xindi.number_sum.twosum_1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//时间复杂度 O(N)
//空间复杂度 O(N)
//为什么不怕重复：
// 两个重复，第二次遇到这个数字时，如果是解，直接返回；如果不是，覆盖也没事
// 3个或3个以上重复，不是解
public class Solution {
    public int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                return new int[]{map.get(target-nums[i]), i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No Two Sum!");
    }
}
