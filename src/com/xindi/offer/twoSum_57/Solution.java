package com.xindi.offer.twoSum_57;

import java.util.HashSet;
import java.util.Set;

//哈希表的方法不用看了，自己写出来了
//双指针方法参考：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/solution/mian-shi-ti-57-he-wei-s-de-liang-ge-shu-zi-shuang-/
public class Solution {
    public int[] twoSum1(int[] nums, int target){
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            if(set.contains(target-num)){
                return new int[]{num,target-num};
            }
            set.add(num);
        }
        return new int[0];
    }

    public int[] twoSum(int[] nums, int target){
        int i=0;
        int j=nums.length-1;
        while(i<j){
            if(nums[i]+nums[j]==target){
                return new int[]{nums[i],nums[j]};
            }else if(nums[i]+nums[j]<target){
                i++;
            }else{
                j--;
            }
        }
        return new int[0];
    }
}
