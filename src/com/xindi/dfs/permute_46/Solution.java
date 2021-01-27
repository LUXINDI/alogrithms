package com.xindi.dfs.permute_46;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums){
        int[] flags = new int[]{nums.length};
        dfs(nums, flags);
        return res;
    }
    public void dfs(int[] nums, int[] flags){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(flags[i]==1) continue;
            path.add(nums[i]);
            flags[i] = 1;
            dfs(nums, flags);
            path.remove(path.size()-1);
            flags[i] = 0;
        }
    }
}
