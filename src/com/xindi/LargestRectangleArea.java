package com.xindi;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
 * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/84-by-ikaruga/
 */
public class LargestRectangleArea {
    public int largestRectangleArea(int[] heights){
        // 遍历每个高度，向左右延伸，获得以当前高度的最大宽度
        if (heights == null || heights.length==0) return 0;
        int len = heights.length;
        int ans = 0;
        for(int i=0;i<len;i++){
            int left = i;
            int curHeight = heights[i];
            //找到左边最后一个大于等于当前高度的index
            while(left-1>=0 && heights[left-1]>=curHeight){
                left--;
            }

            //找到右边第一个大于等于当前高度的index
            int right = i;
            while(right+1<len && heights[right+1]>=curHeight){
                right ++;
            }
            ans = Math.max(ans, curHeight * (right-left+1));

        }
        return ans;
    }
    public int largestRectangleAreaAns(int[] heights) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] new_heights = new int[heights.length + 2];
        for (int i = 1; i < heights.length + 1; i++) {
            new_heights[i] = heights[i - 1];
        }
        for (int i = 0; i < new_heights.length; i++) {
            while (!stack.isEmpty() && new_heights[stack.peek()] > new_heights[i]) {
                int cur = stack.pop();
                int l = stack.peek();
                int r = i;
                res = Math.max(res, (r - l - 1) * new_heights[cur]);
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args){
        LargestRectangleArea sol = new LargestRectangleArea();
        sol.largestRectangleAreaAns(new int[]{2,1,5,6,2,3});
    }



    public int largestRectangleArea2(int[] heights){
        if (heights == null || heights.length==0) return 0;
        Stack<Integer> stack = new Stack<>(); //单调递增栈
        int len = heights.length;
        int[] newHeights = new int[len+2];
        for(int i=1;i < len+1;i++){
            newHeights[i] = heights[i-1];
        }
        //出栈时，新元素是出栈元素往后找第一个比他小的元素
        //出栈后，新的栈顶部是出栈元素向前找第一比他小的元素
        int ans = 0;
        for(int i=0; i<newHeights.length;i++){
            while(!stack.isEmpty() && (newHeights[stack.peek()] > heights[i])){
                int idx = stack.peek();
                { //出栈
                    stack.pop();
                    int right = i-1;
                    int left = stack.peek();
                    ans = Math.max(ans, (right-left+1) * newHeights[idx]);
                }
            }
            stack.push(i);
        }
        return ans;
    }
}
