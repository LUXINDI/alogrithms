package com.xindi.sum_numbers_129;

import com.xindi.utils.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/sum-root-to-leaf-numbers/solution/qiu-gen-dao-xie-zi-jie-dian-shu-zi-zhi-he-by-leetc/
 */
public class Solution2 {
    public int sumNumbers(TreeNode root){
        if(root==null) return 0;
        Queue<TreeNode> nodeQ = new LinkedList<>();
        Queue<Integer> numQ = new LinkedList<>();
        nodeQ.offer(root);
        numQ.offer(root.val);
        int sum = 0;
        while(!nodeQ.isEmpty()){
            TreeNode node = nodeQ.poll();
            int num = numQ.poll();
            if(node.left==null && node.right == null){
                sum += num;
            }
            if (node.left!=null){
                nodeQ.offer(node.left);
                numQ.offer(num*10 + node.left.val);
            }
            if (node.right!=null){
                nodeQ.offer(node.right);
                numQ.offer(num*10 + node.right.val);
            }
        }
        return sum;
    }
}
