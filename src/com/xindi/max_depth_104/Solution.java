package com.xindi.max_depth_104;

import com.xindi.utils.TreeNode;

public class Solution {
    public int maxDepth(TreeNode root){
        if (root == null) return 0;
        return Math.max(maxDepth(root.left),maxDepth((root.right)))+1;
    }
}
