package com.xindi.merge_88;

public class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] merged = new int[m+n];
        int id1 = 0;
        int id2 = 0;
        int id = 0;
        while(id1<m && id2<n){
            if(nums1[id1]<=nums2[id2]){
                merged[id] = nums1[id1];
                id1++;
            }else{
                merged[id] = nums2[id2];
                id2++;
            }
            id++;
        }
        while(id1<m){
            merged[id++] = nums1[id1++];
        }
        while(id2<n){
            merged[id++] = nums2[id2++];
        }

        for(int i=0;i<merged.length;i++){
            nums1[i]= merged[i];
        }
    }
}
