package com.xindi.twopointers.three.sum_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
注意如何去掉重复值
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums){
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<nums.length-2;i++){
            //已经排序好
            if (nums[i]>0) return res;
            if (i>0 && nums[i] == nums[i-1]) continue;
            int left = i+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[i] + nums[left] + nums[right];
                if(sum == 0){
                    List<Integer> curRes = new ArrayList<>();
                    curRes.add(nums[i]);
                    curRes.add(nums[left]);
                    curRes.add(nums[right]);
                    res.add(curRes);
                    left ++;
                    right --;
                    while(left < right && nums[left] == nums[left-1]){
                        left ++;
                    }
                    while(left < right && nums[right] == nums[right+1]){
                        right --;
                    }
                } else if (sum>0){
                    right--;
                } else {
                    left ++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        sol.threeSum(new int[]{1,-1,-1,0});
    }
}
