package com.xindi.offer.verifyPostorder_33;
//递归分治
//单调栈
//reference：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/mian-shi-ti-33-er-cha-sou-suo-shu-de-hou-xu-bian-6/
public class Solution {
    ////https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-hou-xu-bian-li-xu-lie-lcof/solution/di-gui-he-zhan-liang-chong-fang-shi-jie-jue-zui-ha/
    public boolean verifyPostorder(int[] postorder){
        //二叉搜索树：左子树的值<根节点<右子树的值
        return helper(postorder,0,postorder.length-1);
    }
    public boolean helper(int[] postorder, int left, int right){
        if(left>=right) return true; //说明节点数<=1
        int root = postorder[right];
        int p = left;
        while(postorder[p]<root) p++;
        int m = p; //从左至右第一个>= root的位置 [left,m-1]<root
        while(postorder[p]>root) p++;
        // p==right保证 [m,right-1]>root
        return p==right && helper(postorder,left,m-1)&&helper(postorder,m,right-1);
    }
}
