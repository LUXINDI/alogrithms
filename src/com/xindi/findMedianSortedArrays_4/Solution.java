package com.xindi.findMedianSortedArrays_4;

public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int len = nums1.length + nums2.length;
        int left = 0;
        int right = 0;
        while(left < nums1.length && right < nums2.length){
            if ((left+1) + (right +1) == len /2){

            }
            if (nums1[left] <= nums2[right]){
                left ++;
            } else {
                right ++;
            }
        }
    return 0;
    }
}
