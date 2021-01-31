package com.xindi.dfs.subsets2_90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * https://leetcode-cn.com/problems/subsets/solution/c-zong-jie-liao-hui-su-wen-ti-lei-xing-dai-ni-gao-/
 */
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums){
        Arrays.sort(nums);
        dfs(nums,0);
        return res;
    }

    public void dfs(int[] nums, int begin){
        res.add(new ArrayList<>(path));
        for(int i=begin;i<nums.length;i++){
            if(i>begin && nums[i]==nums[i-1]) continue;
            path.add(nums[i]);
            dfs(nums,i+1);
            path.remove(path.size()-1);
        }
    }
}

