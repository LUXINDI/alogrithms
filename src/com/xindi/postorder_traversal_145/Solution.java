package com.xindi.postorder_traversal_145;

import com.xindi.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

//迭代法不会？？
class Solution {
    List<Integer> res = new ArrayList<>();
    public List<Integer> postorderTraversal(TreeNode root) {
        helper(root);
        return res;
    }

    public void helper(TreeNode node){
        if(node==null){
            return;
        }
        helper(node.left);
        helper(node.right);
        res.add(node.val);
    }
}
