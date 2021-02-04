package com.xindi.pathsum_113;

import com.xindi.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum){
        dfs(root, targetSum);
        return res;
    }

    public void dfs(TreeNode node, int targetSum){
        if(node == null) return;
        path.add(node.val);
        if(node.left == null && node.right == null && targetSum == node.val){
            res.add(new ArrayList<>(path));
            //注意！！
            path.remove(path.size()-1);
            return;
        }
        dfs(node.left, targetSum-node.val);
        dfs(node.right, targetSum-node.val);
        path.remove(path.size()-1);
    }
}
