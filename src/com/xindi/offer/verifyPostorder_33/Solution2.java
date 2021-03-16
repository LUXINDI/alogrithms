package com.xindi.offer.verifyPostorder_33;

import java.util.Stack;

//单调栈
public class Solution2 {
    //后续遍历的倒序 arr
    // arr[i+1]>arr[i], arr[i+1]一定是arr[i]的右子节点
    // arr[i+1]<arr[i], arr[i+1]一定是arr[0]-arr[i]中某个节点的左子节点，
    // 并且这个值是>arr[i+1]中最小的
    public boolean verifyPostorder(int[] postorder){
        Stack<Integer> s = new Stack<>();
        int parent = Integer.MAX_VALUE;
        for(int i=postorder.length-1;i>=0;i--){
            int cur = postorder[i];
            while(!s.isEmpty()&&s.peek()>cur){
                parent = s.pop();
            }
            if(cur>parent) return false; //??看不懂
            s.add(cur);
        }
        return true;
    }
}
