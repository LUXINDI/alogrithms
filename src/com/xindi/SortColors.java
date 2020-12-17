package com.xindi;

import java.util.Arrays;

public class SortColors {
    /**
     * @param nums: A list of integer which is 0, 1 or 2
     * @return: nothing
     */
    public static void sortColors(int[] nums) {
        // write your code here
        if (nums == null || nums.length == 1){
            return;
        }
        if (nums.length == 2){
            if (nums[0] > nums[1]) {
                swap(nums, 0 , 1);
            }
        }
        int pl = 0;
        int i = 0;
        int pr = nums.length - 1;
        while (i<=pr){
            System.out.println("pl:" + pl + " i:" + i + " pr:" + pr);
            if (nums[i] == 0){
                System.out.println("swap: " + pl + " <--> " + i);
                swap(nums, pl, i);
                pl ++;
                i ++;
            } else if (nums[i] == 2){
                System.out.println("swap: " + i + " <--> " + pr);
                swap(nums, i , pr);
                pr --;
            } else {
                i ++;
            }
            Utils.printArray(nums);
        }

    }
    public static void swap(int[] nums, int p1, int p2){
        int temp = nums[p1];
        nums[p1] = nums[p2];
        nums[p2] = temp;
    }

    public static void main(String[] args){
        int[] nums = new int[]{2,0,2,1,1,0};
        sortColors(nums);
    }
}
