package com.xindi.dfs.permute.unique_47;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permuteUnique(int[] nums){
        Arrays.sort(nums);
        int[] flags = new int[nums.length];
        dfs(nums,flags);
        return res;
    }
    public void dfs(int[] nums, int[] flags){
        if(nums.length == path.size()){
            res.add(new ArrayList<>(path));
            return;
        }
        //保证在填第i个数时，重复数字只会被填入一次
        for(int i=0;i<nums.length;){
            if(flags[i] == 1) {
                i++;
                continue;
            }
            path.add(nums[i]);
            flags[i] = 1;
            dfs(nums, flags);
            path.remove(path.size()-1);
            flags[i] = 0;
            while(i<nums.length-1 && nums[i] == nums[i+1]){
                i++;
            }
            i++;
        }
    }
}
