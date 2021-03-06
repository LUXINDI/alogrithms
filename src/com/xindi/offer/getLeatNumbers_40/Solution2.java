package com.xindi.offer.getLeatNumbers_40;

import java.util.Arrays;
import java.util.Random;

public class Solution2 {
    Random random = new Random();
    public int[] getLeastNumbers(int[] arr, int k){
        if (k==0) return new int[]{};
        int left=0;
        int right = arr.length-1;
        int[] res = new int[k];
        while(true){
            int ind = partition(arr,left,right);
            if(ind == k-1){
                System.arraycopy(arr,0,res,0,k);
                return res;
            } else if(ind<k-1){
                left = ind+1;
            }else{
                right = ind-1;
            }
        }
    }

    public int partition(int[] arr, int left, int right){
        if(left<right) {
            int randomInd = left + random.nextInt(right - left + 1);
            swap(arr, left, randomInd);
        }
        int pivot = arr[left];
        // [left+1,j]<pivot
        // (j,right]>=pivot
        int j=left;
        for(int i=left+1;i<=right;i++){
            if(arr[i]<pivot){
                j++;
                swap(arr,j,i);
            }
        }
        // [left,j-1]<pivot;j=pivot;
        swap(arr,left,j);
        return j;
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
