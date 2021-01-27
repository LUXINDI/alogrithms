package com.xindi.dfs.permute_46;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution2 {
    // 0,1,2,..| first    左边维护已经插入的数
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums){
        dfs(nums,0);
        return res;
    }
    public void dfs(int[] nums, int first){
        if(first == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i = first;i<nums.length;i++){
            path.add(nums[i]);
            swap(nums, first,i);
            dfs(nums, first+1);
            path.remove(path.size()-1);
            swap(nums, first, i);
        }
    }

    public void swap(int[] nums, int ind1, int ind2){
        int temp = nums[ind1];
        nums[ind1] = nums[ind2];
        nums[ind2] = temp;
    }
}
