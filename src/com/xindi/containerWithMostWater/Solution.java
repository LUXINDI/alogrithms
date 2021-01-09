package com.xindi.containerWithMostWater;

public class Solution {
    // ？ 为什么相等的时候，随便移动哪一边都可以
    public int maxArea(int[] height){
        int maxAns = 0;
        int left = 0;
        int right = height.length - 1;
        while(left<=right){
            int curArea = (right-left)*Math.min(height[left],height[right]);
            maxAns = Math.max(maxAns, curArea);
            // 如果向内移动短板，宽变短，高可能变大，面积可能变大
            // 如果向内移动长板，宽变短，高不变或者变小，面积变小
            if (height[left]<height[right]){
                left ++;
            } else {
                right --;
            }
        }
        return maxAns;
    }
}
