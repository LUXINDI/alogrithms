package com.xindi.offer.isSubStructure_26;

import com.xindi.utils.TreeNode;

public class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B){
        if(A==null||B==null) return false;
        return helper(A,B)||isSubStructure(A.left,B)||isSubStructure(A.right,B);
    }

    //判断以A为根结点的树是否包含树B
    public boolean helper(TreeNode A, TreeNode B){
        if(B==null) return true;
        if(A==null||A.val!=B.val) return false;
        return helper(A.left,B.left) && helper(A.right,B.right);
    }
}
