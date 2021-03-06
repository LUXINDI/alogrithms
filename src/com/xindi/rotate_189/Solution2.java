package com.xindi.rotate_189;

public class Solution2 {
    public void rotate(int[] nums, int k){
        int len = nums.length;
        k = k%len;
        reverse(nums,0,len-1);
        reverse(nums,0,k-1);
        reverse(nums,k,len-1);
    }

    public void reverse(int[] nums,int start, int end){
        int left = start;
        int right = end;
        while(left<right){
            swap(nums,left,right);
            left++;
            right--;
        }
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
