package com.xindi.is_same_tree_100;

import com.xindi.utils.TreeNode;

public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q){
        if(p==null&&q==null) return true;
        if(p==null || q==null) return false;
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right,q.right);
    }
}
