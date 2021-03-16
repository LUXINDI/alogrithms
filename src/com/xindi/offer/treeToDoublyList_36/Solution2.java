package com.xindi.offer.treeToDoublyList_36;

import com.xindi.utils.Node;

//reference:https://leetcode-cn.com/problems/er-cha-sou-suo-shu-yu-shuang-xiang-lian-biao-lcof/solution/mian-shi-ti-36-er-cha-sou-suo-shu-yu-shuang-xian-5/
//没看懂
public class Solution2 {
    Node pre, head;
    public Node treeToDoublyList(Node root){
        if(root==null) return null;
        dfs(root);
        head.left = pre;
        pre.right = head;
        return head;
    }
    public void dfs(Node cur){
        if(cur==null) return;
        dfs(cur.left);
        if(pre==null) head=cur;
        else{
            pre.right = cur;
        }
        cur.left = pre;
        pre=cur;
        dfs(cur.right);
    }
}
