package com.xindi.isValidBST_98;

import com.xindi.utils.TreeNode;

class ResultType{
    long min;
    long max;
    boolean valid;
    ResultType(long min, long max, boolean valid){
        this.min = min;
        this.max = max;
        this.valid = valid;
    }
}
public class Solution {
    public boolean isValidBST(TreeNode node){
        ResultType res = helper(node);
        return res.valid;
    }

    public ResultType helper(TreeNode node){
        if(node == null) return new ResultType(Long.MAX_VALUE, Long.MIN_VALUE, true);
        ResultType left = helper(node.left);
        ResultType right = helper(node.right);
        boolean valid = left.valid && right.valid && left.max < node.val && right.min > node.val;
        long max = Math.max(Math.max(left.max,right.max),node.val);
        long min = Math.min(Math.min(left.min,right.min), node.val);
        return new ResultType(min,max,valid);
    }
}
