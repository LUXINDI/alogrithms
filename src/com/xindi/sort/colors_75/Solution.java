package com.xindi.sort.colors_75;

/**
 * https://leetcode-cn.com/problems/sort-colors/solution/yan-se-fen-lei-by-leetcode-solution/
 */
public class Solution {
    public void sortColors(int[] nums){
        // 0->left-1 头部区域
        int left = 0;
        //把0都移到头部区域
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                swap(nums, left, i);
                left ++;
            }
        }
        //把1都移到头部区域
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){
                swap(nums, left,i);
                left ++;
            }
        }
    }
    public void swap(int[] nums, int ind1, int ind2){
        int temp = nums[ind1];
        nums[ind1] = nums[ind2];
        nums[ind2] = temp;
    }
}
