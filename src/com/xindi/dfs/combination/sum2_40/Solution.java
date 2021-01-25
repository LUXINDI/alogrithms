package com.xindi.dfs.combination.sum2_40;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//https://leetcode-cn.com/problems/combination-sum-ii/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, 0, target);
        return res;
    }

    public void dfs(int[] candidates, int begin, int target){
        if (target ==0) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (target <0 || begin>=candidates.length){
            return;
        }
        for(int i=begin;i<candidates.length;){
            if(target-candidates[i]<0) break;
            path.add(candidates[i]);
            dfs(candidates, i+1, target-candidates[i]);
            path.remove(path.size()-1);
            while(i<candidates.length-1 && candidates[i] == candidates[i+1]){
                i++;
            }
            i++;
        }
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        sol.combinationSum2(new int[]{1,2,2,2,5},5);
    }
}
