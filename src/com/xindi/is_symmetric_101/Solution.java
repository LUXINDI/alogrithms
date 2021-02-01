package com.xindi.is_symmetric_101;

import com.xindi.utils.TreeNode;

public class Solution {
    public boolean isSymmetric(TreeNode root){
        return helper(root,root);
    }

    public boolean helper(TreeNode left, TreeNode right){
        if(left==null && right==null) return true;
        if(left==null || right==null) return false;
        return left.val == right.val && helper(left.left,right.right) && helper(left.right,right.left);
    }
}
