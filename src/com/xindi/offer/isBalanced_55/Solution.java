package com.xindi.offer.isBalanced_55;

import com.xindi.utils.TreeNode;
//可以不看，自己写出来了
class Result{
    boolean balance;
    int height;
    public Result(int h, boolean b){
        this.height = h;
        this.balance = b;
    }
}
public class Solution {
    public boolean isBalanced(TreeNode root){
        return helper(root).balance;
    }
    public Result helper(TreeNode root){
        if(root==null) return new Result(0,true);
        Result left = helper(root.left);
        Result right = helper(root.right);
        int height = Math.max(left.height, right.height)+1;
        boolean balance = left.balance && right.balance && Math.abs(left.height-right.height)<=1;
        return new Result(height, balance);
    }
}
