package com.xindi.remove.element_27;

public class Solution2 {
    public int removeElement(int[] nums, int val){
        int left = 0;
        int right = nums.length;
        while(left<right){
            if(nums[left] == val){
                nums[left] = nums[right-1];
                right --;
            }else{
                left ++;
            }
        }
        return right;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        sol.removeElement(new int[]{1},1);
        sol.removeElement(new int[]{3,4,0,3,3,2,2,5,3},3);
    }
}
