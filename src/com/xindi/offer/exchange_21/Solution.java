package com.xindi.offer.exchange_21;

//首尾双指针
public class Solution {
    public int[] exchange(int[] nums){
        int left=0;
        int right = nums.length-1;
        while(left<=right){
            while(left<=right&&nums[left]%2==1){
                left++;
            }
            while(left<=right&&nums[right]%2==0)
            {
                right--;
            }
            if(left>right) break;
            swap(nums,left,right);
            left++;
            right--;
        }
        return nums;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        int[] nums = new int[]{0,5,6,7,10,3};
        Solution sol = new Solution();
        sol.exchange(nums);
    }
}
