package com.xindi.isSymmetric_28;

import com.xindi.utils.TreeNode;

//可以pass，比较简单
public class Solution {
    public boolean isSymmetric(TreeNode root){
        return helper(root,root);
    }
    public boolean helper(TreeNode node1, TreeNode node2){
        if(node1==null&&node2==null) return true;
        if(node1==null||node2==null) return false;
        return node1.val==node2.val && helper(node1.left,node2.right) && helper(node1.right,node2.left);
    }
}
