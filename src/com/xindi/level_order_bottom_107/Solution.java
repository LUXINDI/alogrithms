package com.xindi.level_order_bottom_107;

import com.xindi.utils.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root){
        Deque<List<Integer>> res = new LinkedList<>();
        if(root == null) return new ArrayList<>(res);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int n = q.size();
            List<Integer> cur = new ArrayList<>();
            for(int i=0;i<n;i++){
                TreeNode node = q.poll();
                cur.add(node.val);
                if(node.left!=null) {
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
            res.offerFirst(cur);
        }
        return new ArrayList<>(res);
    }
}
