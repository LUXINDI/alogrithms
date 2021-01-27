package com.xindi.max.subarray_53;

public class Solution2 {
    public int maxSubArray(int[] nums){
        int dp=0;
        int res = Integer.MIN_VALUE;
        for (int i=0;i<nums.length;i++){
            dp = Math.max(nums[i],nums[i]+dp);
            res = Math.max(res,dp);
        }
        return res;
    }
}
