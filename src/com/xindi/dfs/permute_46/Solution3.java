package com.xindi.dfs.permute_46;

import java.util.ArrayList;
import java.util.List;

/*
[1,1,2]
1
1
2 1
  1
 */
public class Solution3 {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums){
        dfs(nums,0);
        return res;
    }
    public void dfs(int[] nums, int begin){
        if(begin == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int num: nums){
                list.add(num);
            }
            res.add(list);
            return;
        }
        for(int i=begin;i<nums.length;i++){
            swap(nums,begin, i);
            dfs(nums,begin+1);
            swap(nums,begin,i);
        }
    }
    public void swap(int[] nums, int ind1, int ind2){
        int temp = nums[ind1];
        nums[ind1] = nums[ind2];
        nums[ind2] = temp;
    }
}
