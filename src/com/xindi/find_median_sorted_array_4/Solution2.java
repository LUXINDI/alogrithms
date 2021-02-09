package com.xindi.find_median_sorted_array_4;

public class Solution2 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int m = nums1.length;
        int n = nums2.length;
        int[] temp = new int[m+n];
        int left=0;
        int right=0;
        int index = 0;
        int midIndex = (m+n)/2;
        while(left<nums1.length&&right<nums2.length){
            if(nums1[left]<=nums2[right]){
                temp[index]=nums1[left];
                left++;
            }else{
                temp[index] = nums2[right];
                right++;
            }
            index++;
        }
        while(left<nums1.length){
            temp[index++] = nums1[left++];
        }
        while(right<nums2.length){
            temp[index++] = nums2[right++];
        }
        if(m+n==1){
            return temp[0];
        }
        if((m+n)%2==1){
            return temp[(m+n)/2];
        }else{
            return (temp[(m+n)/2]+temp[(m+n)/2-1])/2.0;
        }
    }

    public static void main(String[] args){
        Solution2 sol = new Solution2();
        sol.findMedianSortedArrays(new int[]{1,3},new int[]{2});
    }
}
