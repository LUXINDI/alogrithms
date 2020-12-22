package com.xindi.ans;

import java.util.Stack;

public class DailyTemperatures {
    public int[] dailyTempratures(int[] T){
        int len = T.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<len;i++){
            while(!stack.isEmpty()){
                if (T[stack.peek()]< T[i]){
                    int idx = stack.pop();
                    res[idx] = i-idx;
                } else {
                    break;
                }
            }
            stack.push(i);
        }
        return res;

    }
}
