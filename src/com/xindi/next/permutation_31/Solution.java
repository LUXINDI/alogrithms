package com.xindi.next.permutation_31;

import java.util.Arrays;

public class Solution {
    public void nextPermunation(int[] nums){
        int len = nums.length;
        //从右向左找到第一个比左边相邻位大的数
        int j = len-2;
        while(j>=0 && nums[j]>=nums[j+1]){
            j -- ;
        }
        // 整个数组都是降序的
        if (j==-1) {
            Arrays.sort(nums);
            return;
        }
        // j+1, end都是降序的
        //从右向左找到第一个比 nums[j]大的数
        int i = len-1;
        while(i>=j+1 && nums[i] <= nums[j]){
            i --;
        }
        swap(nums, i, j);
        // 将 j+1到 end 升序
        int r = len-1;
        int l = j+1;
        while(l<r){
            swap(nums, l,r);
            l++;
            r--;
        }
    }

    public void swap(int[] nums, int ind1, int ind2){
        int temp = nums[ind1];
        nums[ind1] = nums[ind2];
        nums[ind2] = temp;
    }
}
