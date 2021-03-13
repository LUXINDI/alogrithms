package com.xindi.offer.isStraight_61;

import java.util.Arrays;

//不会写
//reference：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/solution/mian-shi-ti-61-bu-ke-pai-zhong-de-shun-zi-ji-he-se/
public class Solution {
    //要没有重复的数字
    //最大牌减去最小牌<5
    public boolean isStraight(int[] nums){
        Arrays.sort(nums);
        int zeros=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                zeros++;
                continue;
            }
            if(i>=1&&nums[i]==nums[i-1]){
                return false;
            }
        }
        return nums[nums.length-1]-nums[zeros]<5;
    }
}
