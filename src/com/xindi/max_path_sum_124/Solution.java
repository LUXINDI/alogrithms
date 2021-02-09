package com.xindi.max_path_sum_124;

import com.xindi.utils.TreeNode;

/**
 * https://leetcode-cn.com/problems/binary-tree-maximum-path-sum/solution/er-cha-shu-zhong-de-zui-da-lu-jing-he-by-leetcode-/
 */
public class Solution {
    int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root){
        maxGain(root);
        return maxSum;
    }
    //以当前节点为结尾的最大路径和
    public int maxGain(TreeNode node){
        if(node == null) return 0;
        int left = maxGain(node.left);
        int right = maxGain(node.right);
        //经过node的最大路径和
        int curSum = node.val + Math.max(left,0) + Math.max(right,0);
        maxSum = Math.max(maxSum,curSum);
        return Math.max(Math.max(left,0), Math.max(right,0))+node.val;
    }
}
