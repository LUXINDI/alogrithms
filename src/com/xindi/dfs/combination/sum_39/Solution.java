package com.xindi.dfs.combination.sum_39;

import com.xindi.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// dfs
// reference: https://leetcode-cn.com/problems/combination-sum/solution/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-2/
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target){
        Arrays.sort(candidates);
        dfs(candidates, target, 0);
        return res;
    }

    // begin: 搜索起点
    public void dfs(int[] candidates, int target, int begin){
        if(target == 0){
            res.add(new ArrayList<>(path));
            System.out.println("Added:" + Utils.printPath(path));
            return;
        }
        if (target<0) {
            System.out.println("Discarded:" + Utils.printPath(path));
            return;
        }
        for(int i = begin; i<candidates.length; i++){
            if ((target - candidates[i])<0){
                System.out.println("Discarded:" + Utils.printPath(path) + "->" + candidates[i]);
                break;
            }
            path.add(candidates[i]);
            dfs(candidates, target-candidates[i],i);
            path.remove(path.size()-1);
        }
    }


    public static void main(String[] args){
        Solution sol = new Solution();
        sol.combinationSum(new int[]{2,3,6,7},7);
    }
}
