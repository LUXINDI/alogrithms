package com.xindi.offer.mirrorTree_27;

import com.xindi.utils.TreeNode;

public class Solution {
    public TreeNode mirrorTree(TreeNode root){
        return helper(root);
    }

    public TreeNode helper(TreeNode node){
        if(node==null) return null;
        if(node.left==null&&node.right==null){
            return node;
        }
        TreeNode temp = node.left;
        node.left = helper(node.right);
        node.right = helper(temp);
        return node;
    }
}
