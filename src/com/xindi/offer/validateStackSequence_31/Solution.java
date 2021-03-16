package com.xindi.offer.validateStackSequence_31;

import java.util.Stack;

//不会写
//reference：https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/solution/mian-shi-ti-31-zhan-de-ya-ru-dan-chu-xu-lie-mo-n-2/
public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped){
        Stack<Integer> stack = new Stack<>();
        int j=0;
        for(int i=0;i<pushed.length;i++){
            stack.push(pushed[i]);
            while(!stack.isEmpty()&&stack.peek()==popped[j]){
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty() && j==popped.length;
    }
}
