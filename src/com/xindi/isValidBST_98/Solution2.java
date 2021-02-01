package com.xindi.isValidBST_98;

import com.xindi.utils.TreeNode;

/**
 * https://leetcode-cn.com/problems/validate-binary-search-tree/solution/yan-zheng-er-cha-sou-suo-shu-by-leetcode-solution/
 */
public class Solution2 {
    public boolean isValidBST(TreeNode node){
        return helper(node, null,null);
    }
    // 判断以root为根结点，是否在(lower, upper)范围内
    public boolean helper(TreeNode node, Integer lower, Integer upper){
        if(node == null) return true;
        if(lower!=null && node.val<=lower) return false;
        if(upper!=null && node.val>=upper) return false;
        return helper(node.left,lower,node.val) && helper(node.right,node.val,upper);
    }
}
