package com.xindi.binary.search.insert_35;

//二分法
//找到第一个>=target的下标
//find first position >= target
public class Solution2 {
    public int searchInsert(int[] nums, int target){
        int left = 0;
        int right = nums.length -1;
        while(left + 1 < right){
            int mid = left + (right-left)/2;
            if(target<nums[mid]){
                right = mid - 1;
            }else{
                left = mid;
            }
        }
        return nums[left] >= target ? left : (nums[right]>=target ? right : right+1) ;
    }

    public static void main(String[] args){
        int[] nums = new int[]{1,3,5,6};
        Solution2 sol = new Solution2();
        System.out.println(sol.searchInsert(nums, 2));
    }
}
