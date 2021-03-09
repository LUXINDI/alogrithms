package com.xindi.offer.buildTree_07;

import com.xindi.utils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof/solution/mian-shi-ti-07-zhong-jian-er-cha-shu-di-gui-fa-qin/
 */
public class Solution {
    int[] preorder;
    private Map<Integer, Integer> dic = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder){
        // 构建中序遍历的索引
        int n = inorder.length;
        for(int i=0;i<inorder.length;i++)
        {
            dic.put(inorder[i],i);
        }
        this.preorder = preorder;
        return recur(0,0,n-1);
    }
    // root: 前序遍历的根结点索引
    // left: 中序遍历的左边界
    // right：中序遍历的右边界
    public TreeNode recur(int root, int left, int right){
        if(left>right) return null;
        TreeNode node = new TreeNode(preorder[root]);
        int i = dic.get(preorder[root]); //获得根结点在中序遍历中索引
        node.left = recur(root+1, left,i-1);
        int leftTreeLen = i - left;
        int right_root_idx = root + leftTreeLen + 1;
        node.right = recur(right_root_idx,i+1,right);
        return node;
    }
}
