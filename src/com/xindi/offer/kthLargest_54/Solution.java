package com.xindi.offer.kthLargest_54;

import com.xindi.utils.TreeNode;
//reference:https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof/solution/mian-shi-ti-54-er-cha-sou-suo-shu-de-di-k-da-jie-d/
public class Solution {
    //二叉搜索树的中序遍历是递增
    //二叉搜索树中序遍历倒序递减
    int res;
    int k;
    public int kthLargest(TreeNode root, int k){
        this.k = k;
        dfs(root);
        return res;
    }

    public void dfs(TreeNode node){
        if(node==null) return;
        dfs(node.right);
        k--;
        if(k==0) {
            res=node.val;
            return;
        }
        dfs(node.left);
    }
}
