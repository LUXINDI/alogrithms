package com.xindi.offer.lowsetCommonAncestor_68;

import com.xindi.utils.TreeNode;

//reference:https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-zui-jin-gong-gong-zu-xian-lcof/solution/mian-shi-ti-68-i-er-cha-sou-suo-shu-de-zui-jin-g-7/
public class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){
        if(p.val<root.val&&q.val<root.val){ // 都在root的左子树中
            return lowestCommonAncestor(root.left,p,q);
        }
        if(p.val>root.val&&q.val>root.val){ //都在root右子树中
            return lowestCommonAncestor(root.right, p,q);
        }
        return root;
    }
}
