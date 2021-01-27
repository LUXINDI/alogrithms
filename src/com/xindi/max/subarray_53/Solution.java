package com.xindi.max.subarray_53;

public class Solution {
    public int maxSubArray(int[] nums){
        int[] dp = new int[nums.length];
        int res = Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++){
            if(i==0){
                dp[i] = nums[i];
            }else{
                dp[i] = Math.max(nums[i],nums[i]+dp[i-1]);
            }
            res = Math.max(res,dp[i]);
        }
        return res;
    }
}
