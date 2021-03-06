package com.xindi.first.missing.positive_41;

/**
 * https://leetcode-cn.com/problems/first-missing-positive/solution/tong-pai-xu-python-dai-ma-by-liweiwei1419/
 */
public class Solution2 {
    public int firstMissingPositive(int[] nums){
        for(int i=0;i<=nums.length-1;i++){
            while(nums[i]>=1 && nums[i]<=nums.length && nums[nums[i]-1]!=nums[i]){
                swap(nums, nums[i]-1,i);
            }
        }
        for(int i=0;i<nums.length;i++){
            if(nums[i]!=i+1){
                return i+1;
            }
        }
        return nums.length+1;
    }
    public void swap(int[] nums, int id1, int id2){
        int temp = nums[id1];
        nums[id1] = nums[id2];
        nums[id2] = temp;
    }
}
