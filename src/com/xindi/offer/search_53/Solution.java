package com.xindi.offer.search_53;

public class Solution {
    public int search(int[] nums, int target){
        if(nums==null||nums.length==0) return 0;
        int first = firstPos(nums,target);
        if(first==-1) return 0;
        int last = lastPos(nums, target);
        return last-first+1;
    }

    public int firstPos(int[] nums, int target){
        int left=0;
        int right = nums.length-1;
        //find first position nums[i]==target
        while(left+1<right){
            int mid = left+(right-left)/2;
            if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                right = mid;
            }
        }
        return nums[left]==target ? left :(nums[right]==target ? right : -1);
    }

    public int lastPos(int[] nums, int target){
        int left=0;
        int right = nums.length-1;
        //find las position nums[i]==target
        while(left+1<right){
            int mid = left+(right-left)/2;
            if(nums[mid]>target){
                right=mid-1;
            }else if(nums[mid]<target){
                left=mid+1;
            }else{
                left = mid;
            }
        }
        return nums[right]==target ? right :(nums[left]==target ? left : -1);
    }
}
