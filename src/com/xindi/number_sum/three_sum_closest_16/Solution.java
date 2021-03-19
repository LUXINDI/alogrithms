package com.xindi.number_sum.three_sum_closest_16;

import java.util.Arrays;

/**
 * 给定一个包括n 个整数的数组nums和 一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 */
public class Solution {
    public int threeSumClosest(int[] nums, int target){
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for (int i=0;i<nums.length-2;i++){
            int left = i+1;
            int right = nums.length -1;
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if (Math.abs(sum-target)<Math.abs(ans-target)){
                    ans = sum;
                }
                if (sum > target){
                    right --;
                } else if (sum < target){
                    left ++;
                } else {
                    return target;
                }
            }
        }
        return ans;
    }

    //2021-03-18
    public int threeSumClosest2(int[] nums, int target){
        Arrays.sort(nums);
        int minDiff = Math.abs(target-nums[0]-nums[1]-nums[2]);
        int res = nums[0]+nums[1]+nums[2];
        for(int i=0;i<=nums.length-3;i++){
            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(target-sum)<minDiff){
                    minDiff = Math.abs(target-sum);
                    res = sum;
                }
                if(sum>target){
                    right--;
                }else if(sum<target){
                    left++;
                }else{
                    return sum;
                }
            }
        }
        return res;
    }
}
