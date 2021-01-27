package com.xindi.canjump_55;

public class Solution {
    public boolean canJump(int[] nums){
        int[] dp = new int[nums.length];
        int maxPoint = 0;
        for(int i=0;i<nums.length;i++){
            if(i>maxPoint) return false;
            maxPoint = Math.max(maxPoint, i+nums[i]);
        }
        return true;
    }
}
