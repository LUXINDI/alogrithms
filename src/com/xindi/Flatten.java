package com.xindi;

import com.xindi.utils.TreeNode;



class Flatten {
    public static class ResultType {
        public TreeNode first;
        public TreeNode last;

        public ResultType(TreeNode first, TreeNode last){
            this.first = first;
            this.last = last;
        }
    }
    public void flatten2(TreeNode root) {
        if (root == null) return;
        flatten2(root.left);
        flatten2(root.right);
        TreeNode temp = root.right;
        root.right = root.left;
        root.left = null;
        while(root.right!=null){
            root = root.right;
        }
        root.right = temp;
    }
    public void flatten(TreeNode root) {
        helper(root);
    }

    private ResultType helper(TreeNode root){
        if (root == null) return null;
        if (root.left == null && root.right == null) return new ResultType(root, root);
        ResultType leftRes = helper(root.left);
        ResultType rightRes = helper(root.right);
        ResultType res = new ResultType(null,null);
        if (leftRes!=null && rightRes!=null){
            root.right = leftRes.first;
            root.left = null;
            leftRes.last.right = rightRes.first;
            rightRes.last.right = null;
            res.first = root;
            res.last = rightRes.last;
        } else if(leftRes == null){
            root.right = rightRes.first;
            root.left = null;
            rightRes.last.right = null;
            res.first = root;
            res.last = rightRes.last;
        } else {
            root.right = leftRes.first;
            root.left = null;
            leftRes.last.right = null;
            res.first = root;
            res.last = leftRes.last;
        }
        return res;
    }
}


