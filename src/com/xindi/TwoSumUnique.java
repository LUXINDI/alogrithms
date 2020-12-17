package com.xindi;

import java.util.Arrays;

public class TwoSumUnique {
    /**
     * @param nums: an array of integer
     * @param target: An integer
     * @return: An integer
     */
    public static int twoSum6(int[] nums, int target) {
        // write your code here
        if (nums == null) return 0;
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length -1;
        int res = 0;
        while (left < right){
            int sum = nums[left] + nums[right];
            if (sum < target){
                left ++;
            }else if (sum > target){
                right --;
            }else {
                res ++;
                left ++;
                right --;
                while (left<right && left >=1 && nums[left] == nums[left-1]){
                    left ++;
                }
                while (left<right && right < nums.length-1 && nums[right] == nums[right+1]){
                    right --;
                }
            }
        }
        return res;
    }

    public int twoSumLessThanOrEqualTo(int[] nums, int target){
        Arrays.sort(nums);
        if (nums == null || nums.length < 2){
            return 0;
        }
        int cnt = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int sum = nums[left] + nums[right];
            if (sum > target){
                right --;
            } else {
                cnt = cnt + right - left;
                left ++;
            }
        }
        return cnt;
    }

    public int twoSumGreaterThanOrEqualTo(int[] nums, int target){
        Arrays.sort(nums);
        if (nums == null || nums.length < 2){
            return 0;
        }
        int cnt = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left < right){
            int sum = nums[left] + nums[right];
            if (sum > target){
                cnt = cnt + right - left;
                right --;
            } else {
                left ++;
            }
        }
        return cnt;
    }

    public int twoSumClosest(int[] nums, int target){
        if (nums == null || nums.length < 2){
            return -1;
        }
        Arrays.sort(nums);
        int minDiff = Integer.MAX_VALUE;
        int left = 0;
        int right = nums.length -1;
        while (left < right){
            int sum = nums[left] + nums[right];
            int diff = Math.abs(sum - target);
            minDiff = Math.min(diff, minDiff);
            if (sum > target){
                right --;
            } else if (sum < target){
                left ++;
            } else {
                return 0;
            }
        }
        return minDiff;
    }

    public static int[] twoSumDiff(int[] nums, int target){
        if (nums == null || nums.length < 2){
            return new int[2];
        }
        Arrays.sort(nums);
        int left = 0;
        int right = 1;
        while(right <= nums.length -1){
            int diff = nums[right] - nums[left];
            if (diff < target){
                right ++;
            } else if (diff > target){
                left ++;
            } else {
                return new int[]{nums[left],nums[right]};
            }
            if (right == left){
                right ++;
            }
        }
        return new int[2];

    }


    public static void main(String[] args){
        int[] ans =TwoSumUnique.twoSumDiff(new int[]{2,7,15,24},5);
        TwoSumUnique.twoSum6(new int[]{1,1,2,45,46,46}, 47);
        TwoSumUnique.twoSum6(new int[]{1,1,1,1,1},2);
    }
}
