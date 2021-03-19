package com.xindi.number_sum.twosum_1;

import java.util.Arrays;

public class Solution2 {
    class Pair implements Comparable<Pair> {
        int number, index;
        public Pair(int number, int index){
            this.number = number;
            this.index = index;
        }
        public int compareTo(Pair other){
            return number- other.number;
        }
    }

    private Pair[] getSortedPairs(int[] nums){
        Pair[] pairs = new Pair[nums.length];
        for (int i=0; i< nums.length; i++){
            pairs[i] = new Pair(nums[i],i);
        }
        Arrays.sort(pairs);
        return pairs;
    }
    public int[] twoSum(int[] nums, int target) {
        Pair[] pairs = getSortedPairs(nums);
        int[] result = new int[2];
        if (nums == null){
            return result;
        }
        int leftindex = 0;
        int rightindex = nums.length-1;
        while(leftindex < rightindex){
            int sum = pairs[leftindex].number + pairs[rightindex].number;
            if (sum > target){
                rightindex --;
            } else if (sum < target){
                leftindex ++;
            } else {
                result[0] = Math.min(pairs[leftindex].index, pairs[rightindex].index);
                result[1] = Math.max(pairs[leftindex].index, pairs[rightindex].index);
                return result;
            }
        }
        return result;
    }
}
