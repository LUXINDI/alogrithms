package com.xindi.merge_88;

public class Solution2 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1,0,nums1_copy,0,m);
        int id1 = 0;
        int id2 = 0;
        int id = 0;
        while(id1<m && id2<n){
            if(nums1_copy[id1]<=nums2[id2]){
                nums1[id] = nums1_copy[id1];
                id1++;
            }else{
                nums1[id] = nums2[id2];
                id2++;
            }
            id++;
        }
        while(id1<m){
            nums1[id++] = nums1_copy[id1++];
        }
        while(id2<n){
            nums1[id++] = nums2[id2++];
        }
    }
}
