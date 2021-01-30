package com.xindi.dfs.combine_77;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combine(int n, int k){
        dfs(n, 1, k);
        return res;
    }

    public void dfs(int n , int begin, int k){
        if(path.size()==k){
            res.add(new ArrayList<>(path));
            return;
        }
        for(int i=begin;i<=n;i++){
            path.add(i);
            dfs(n, i+1,k);
            path.remove(path.size()-1);
        }
    }
}
