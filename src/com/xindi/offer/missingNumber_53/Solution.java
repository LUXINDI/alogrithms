package com.xindi.offer.missingNumber_53;

public class Solution {
    // find first position nums[i]>i
    public int missingNumber(int[] nums){
        int left=0;
        int right=nums.length-1;
        while(left<right){
            int mid = left+(right-left)/2;
            if(nums[mid]>mid){
                right=mid;
            }else{
                left = mid+1;
            }
        }
        // input:[0] output:  1
        // 要判断最后有没有找到
        return nums[left]>left?(nums[left]-1):nums.length;
    }

    public int missingNumber2(int[] nums){
        int left=0;
        int right=nums.length-1;
        // 左边：nums[i] == i; 右边：nums[i]!=i
        while(left+1<right){
            int mid = left+(right-left)/2;
            if(nums[mid]!=mid){
                right=mid;
            }else{
                left = mid+1;
            }
        }
        //返回右子数组的第一个元素对应的索引
        return nums[left]!=left?left:(nums[right]!=right ? right : nums.length);
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        sol.missingNumber(new int[]{0,1,3});
    }
}
