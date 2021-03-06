package com.xindi.rotate_189;

import com.xindi.Utils;

public class Solution {
    public void rotate(int[] nums, int k){
        // x -> (x+k)%len
        int[] copy = new int[nums.length];
        int len = nums.length;
        for(int i=0;i<nums.length;i++){
            copy[(i+k)%len] = nums[i];
        }
        System.arraycopy(copy,0,nums,0,len);
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,2,3,4,5,6,7};
        Solution sol = new Solution();
        Utils.printArray(nums);
        sol.rotate(nums,3);
        Utils.printArray(nums);
    }
}
