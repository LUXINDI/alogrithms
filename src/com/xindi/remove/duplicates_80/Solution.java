package com.xindi.remove.duplicates_80;

public class Solution {
    public int removeDuplicates(int[] nums){
        int count = 1;
        int length = nums.length;
        for(int i=1;i<length;){
            if (nums[i]!=nums[i-1]){
                count = 1;
                i++;
                continue;
            }
            count ++;
            if(count>2){
                removeEle(nums,i);
                length--;
                count--;
            }else{
                i++;
            }
        }
        return length;
    }

    public void removeEle(int[] nums, int idx){
        for(int i=idx;i<nums.length-1;i++){
            nums[i] = nums[i+1];
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        sol.removeDuplicates(new int[]{1,1,1,2,2,3});
    }
}
