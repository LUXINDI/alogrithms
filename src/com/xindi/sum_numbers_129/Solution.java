package com.xindi.sum_numbers_129;

import com.xindi.utils.TreeNode;

public class Solution {
    public int sumNumbers(TreeNode root){
        return dfs(root,0);
    }

    public int dfs(TreeNode node, int preSum){
        if(node==null) return 0;
        int sum = preSum*10 + node.val;
        if(node.left==null&&node.right==null){
            return sum;
        }
        return dfs(node.left,sum)+ dfs(node.right,sum);
    }

}
