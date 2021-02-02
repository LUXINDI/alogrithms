package com.xindi.zigzag_level_order_103;

import com.xindi.utils.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;
        queue.offer(root);
        boolean isOrderLeft = true;
        while(!queue.isEmpty()){
            Deque<Integer> level = new LinkedList<Integer>();
            int size = queue.size();
            for(int i = 0;i<size;i++) {
                TreeNode node = queue.poll();
                if(isOrderLeft) {
                    level.offerLast(node.val);
                }else{
                    level.offerFirst(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res.add(new LinkedList<>(level));
            isOrderLeft = !isOrderLeft;
        }
        return res;
    }
}
