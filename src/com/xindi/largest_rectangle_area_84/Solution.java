package com.xindi.largest_rectangle_area_84;

import java.util.LinkedList;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/84-by-ikaruga/
 */
public class Solution {
    public int largestRectangleArea(int[] heights){
        Stack<Integer> st = new Stack<>();
        int[] newH = new int[heights.length+2];
        for(int i=0;i<heights.length;i++){ //最后一个元素是保证最后栈中所有元素都弹出来
            newH[i+1] = heights[i];
        }
        st.push(0);
        int res = 0;
        for(int i=1;i<newH.length;i++){
            while(!st.isEmpty()&&newH[st.peek()]>newH[i]){
                int popIdx = st.pop(); //出栈元素
                int topIdx = st.peek(); //出栈后的栈顶元素,出栈元素向前第一个比它小的idx
                int right = i-1;
                int left = topIdx+1;
                int curArea = newH[popIdx]*(right-left+1);
                res = Math.max(res,curArea);
            }
            st.push(i);
        }
        return res;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.largestRectangleArea(new int[]{2,2,2,2}));
    }
}
