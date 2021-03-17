package com.xindi.reversePairs_51;

import com.xindi.Utils;

//reference:https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/solution/jian-zhi-offer-51-shu-zu-zhong-de-ni-xu-pvn2h/
public class Solution {
    int[] temp;
    int[] nums;
    int res=0;
    public int reversePairs(int[] nums){
        this.temp = new int[nums.length];
        this.nums = nums;
        mergeSort(0,nums.length-1);
        return res;
    }

    public void mergeSort(int start, int end){
        if(start>=end) return;
        int mid = start+(end-start)/2;
        mergeSort(start,mid);
        mergeSort(mid+1,end);
        int left=start;
        int right=mid+1;
        int ind = left;
        while(left<=mid&&right<=end){
            if(nums[left]<=nums[right]){
                temp[ind++] = nums[left++];
            }else{ //nums[right]<nums[left]
                res = res+ (mid-left+1);
                temp[ind++] = nums[right++];
            }
        }
        while(left<=mid){
            temp[ind++]=nums[left++];
        }
        while(right<=end){
            temp[ind++]=nums[right++];
        }
        //这一步千万不要漏！！！
        for(int i=start;i<=end;i++){
            nums[i] = temp[i];
        }
        //Utils.printArray(nums);
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = new int[]{1,3,2,3,1};
        int res = sol.reversePairs(nums);
        System.out.println(res);
    }
}
