package com.xindi.trap_42;

import java.util.Stack;

/**
 * 单调递减栈
 * https://leetcode-cn.com/problems/trapping-rain-water/solution/trapping-rain-water-by-ikaruga/
 */
public class Solution2 {
    public int trap(int[] height){
       Stack<Integer> st = new Stack<>();
       int res = 0;
       for(int i=0;i<height.length;i++){
           //找到左边第一个大于height[i]的数 topIdx
           //找到右边第一个大于height[i]的数 i
           while(!st.empty()&&height[st.peek()]<height[i]){
               int popIdx = st.pop();
               if(st.empty()) break;
               int topIdx = st.peek();
               int h = Math.min(height[i],height[topIdx])-height[popIdx];
               int right = i-1;
               int left = topIdx+1;
               res += h*(right-left+1);
           }
           st.push(i);
       }
       return res;
    }
    public static void main(String args){
        Solution sol = new Solution();
        sol.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
    }
}
