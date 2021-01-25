package com.xindi.twopointers.four.sum_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums==null || nums.length<4) return res;
        Arrays.sort(nums);
        int n = nums.length;
        for(int i=0;i<nums.length-3;i++){
            //当前最小值
            if(nums[i]+nums[i+1]+nums[i+2]+nums[i+3]>target) break;
            //当前最大值
            if(nums[i] + nums[n-1]+nums[n-2]+nums[n-3]<target) continue;
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<nums.length-2;j++){
                //当前最小值
                if(nums[i] + nums[j] + nums[j+1] + nums[j+2] > target) break;
                //当前最大值
                if (nums[i]+nums[j]+nums[n-1]+nums[n-2]<target) continue;
                if (j>i+1 && nums[j] == nums[j-1]) continue;
                int left = j+1;
                int right = nums.length-1;
                while(left < right){
                    int sum = nums[i] + nums[j] + nums[left] + nums[right];
                    if (sum == target){
                        List<Integer> cur = new ArrayList<>();
                        cur.add(nums[i]);
                        cur.add(nums[j]);
                        cur.add(nums[left]);
                        cur.add(nums[right]);
                        res.add(cur);
                        left ++;
                        right --;
                        while(left < right && nums[left] == nums[left-1]){
                            left ++;
                        }
                        while(left < right && nums[right] == nums[right +1]){
                            right --;
                        }
                    } else if (sum>target){
                        right --;
                    } else {
                        left ++;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        sol.fourSum(new int[]{1,0,-1,0,-2,2},0);
    }
}
