package com.xindi.dfs.subsets_78;

import java.util.ArrayList;
import java.util.List;

public class Solution_0131 {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> subset = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums){
        dfs(nums,0);
        return res;
    }
    public void dfs(int[] nums, int begin){
        if(begin == nums.length){
            res.add(new ArrayList<>(subset));
            return;
        }
        dfs(nums,begin+1);
        subset.add(nums[begin]);
        dfs(nums,begin+1);
        subset.remove(subset.size()-1);
    }
}
