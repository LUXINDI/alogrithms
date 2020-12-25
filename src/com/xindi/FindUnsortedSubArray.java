package com.xindi;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/
 * https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/solution/581-zui-duan-wu-xu-lian-xu-zi-shu-zu-by-ming-zhi-s/
 */
public class FindUnsortedSubArray {
    public int findUnsortedSubArray(int[] nums){
        int[] newNums = nums.clone();
        Arrays.sort(newNums);
        int left = -1;
        int right = -1;
        for(int i=0;i<nums.length;i++){
            if (newNums[i]==nums[i]) continue;
            if(left<0) {
                left = i;
                continue;
            }
            right = i;
        }
        if(left<0) return 0;
        return right-left +1;
    }

    public int findUnsortedSubArray2(int[] nums){
        int l = nums.length;
         int r = -1;
        for(int i=0;i<nums.length-1;i++){
            for(int j=i+1;j<nums.length;j++){
                if (nums[j]<nums[i]){
                    r = Math.max(r,j);
                    l = Math.min(l,i);
                }
            }
        }
        return r<l?0:(r-l+1);
    }

    public int findUnsortedSubArray3(int[] nums){
        int length = nums.length;
        int max = nums[0];
        int min = nums[length-1];
        int right = 0;
        int left = 0;
        for(int i=0;i<nums.length;i++){
            if (nums[i]<max){
                right = i;
            } else {
                max = nums[i];
            }

            if (nums[length-i-1] > min){
                left = length - i -1;
            } else {
                min = nums[length-i-1];
            }
        }
        return right > left ? right - left +1:0;
    }
}




