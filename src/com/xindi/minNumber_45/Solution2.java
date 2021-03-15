package com.xindi.minNumber_45;

import java.util.Random;

public class Solution2 {
    Random random = new Random();
    public String minNumber(int[] nums){
        String[] strs = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            strs[i] = String.valueOf(nums[i]);
        }
        quickSort(strs,0,strs.length-1);
        StringBuilder res = new StringBuilder();
        for(String str:strs){
            res.append(str);
        }
        return res.toString();
    }

    public void quickSort(String[] strs, int left , int right){
        if(left>=right) return;
        int randomInd = left + random.nextInt(right-left+1);
        swap(strs, left, randomInd);
        String pivot = strs[left];
        int j = left;
        // left pivot
        // [left+1, j] < pivot
        // (j, right] >=pivot
        for(int i=left+1;i<=right;i++){
            if((strs[i]+pivot).compareTo(pivot+strs[i])<0){
                j++;
                swap(strs, j ,i);
            }
        }
        // [left,j)<pivot
        // j = pivot
        swap(strs, left, j);
        quickSort(strs,left,j-1);
        quickSort(strs, j+1, right);
    }

    public void swap(String[] strs, int i, int j){
        String temp = strs[i];
        strs[i] = strs[j];
        strs[j] = temp;
    }
}
