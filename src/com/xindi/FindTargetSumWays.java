package com.xindi;

public class FindTargetSumWays {
    private int cnt = 0;
    public int findTargetSumWays(int[] nums, int S){
        if (nums == null) return 0;
        backTrack(nums,0,0,S);
        return cnt;
    }

    private void backTrack(int[] nums, int index, int sum, int S){
        if (index == nums.length){
            if(S==sum) cnt ++;
        } else {
            backTrack(nums, index+1, sum+nums[index],S);
            backTrack(nums,index+1,sum-nums[index],S);
        }
    }
}
