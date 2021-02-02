package com.xindi.is_balanced_110;

import com.xindi.utils.TreeNode;

class ResultType{
    int depth;
    boolean balanced;
    ResultType(int depth, boolean balanced){
        this.depth = depth;
        this.balanced = balanced;
    }
}
public class Solution {
    public boolean isBalanced(TreeNode root){
        ResultType res = helper(root);
        return res.balanced;
    }

    public ResultType helper(TreeNode node){
        if(node == null) return new ResultType(0,true);
        ResultType left = helper(node.left);
        ResultType right = helper(node.right);
        boolean balanced = left.balanced && right.balanced && Math.abs(left.depth - right.depth)<=1;
        return new ResultType(Math.max(left.depth,right.depth)+1, balanced);
    }
}
