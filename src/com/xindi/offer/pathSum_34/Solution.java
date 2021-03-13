package com.xindi.offer.pathSum_34;

import com.xindi.utils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

//写错了
//reference：https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/solution/mian-shi-ti-34-er-cha-shu-zhong-he-wei-mou-yi-zh-5/
public class Solution {
    List<List<Integer>> res = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target){
        helper(root,target);
        return res;
    }
    public void helper(TreeNode node, int target){
        if(node==null) return;
        path.add(node.val);
        target -= node.val;
        if(target==0&&node.left==null&&node.right==null){
            res.add(new LinkedList<>(path));
            //return;注意不能return，还要删去最后一个数
        }
        helper(node.left,target);
        helper(node.right,target);
        path.removeLast();
    }
}
