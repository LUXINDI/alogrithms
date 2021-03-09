package com.xindi.offer.maxSubArray_42;

public class Solution {
    public int maxSubArray(int[] nums){
        if(nums==null||nums.length==0) return 0;
        int[] dp = new int[nums.length];
        //dp[i]:以nums[i]为终点的连续子数组最大和
        dp[0] = nums[0];
        int res = dp[0];
        for(int i=1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            res = Math.max(dp[i],res);
        }
        return res;
    }

    //节省空间，直接在nums上进行操作
    public int maxSubArray2(int[] nums){
        if(nums==null||nums.length==0) return 0;
        //dp[i]:以nums[i]为终点的连续子数组最大和
        int res = nums[0];
        for(int i=1;i<nums.length;i++){
            nums[i] = Math.max(nums[i-1]+nums[i],nums[i]);
            res = Math.max(nums[i],res);
        }
        return res;
    }
}
