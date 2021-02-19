package com.xindi.trap_42;

/**
 * https://leetcode-cn.com/problems/trapping-rain-water/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-8/
 */
public class Solution {
    public int trap(int[] height){
        int res = 0;
        for(int i=1;i<height.length-1;i++){
            int maxLeft = 0;
            for(int j=i-1;j>=0;j--){
                maxLeft = Math.max(height[j],maxLeft);
            }
            int maxRight = 0;
            for(int k=i+1;k<height.length;k++){
                maxRight = Math.max(height[k],maxRight);
            }
            if(height[i]<maxLeft && height[i]<maxRight){
                res += Math.min(maxLeft,maxRight) - height[i];
            }
        }
        return res;
    }

    public int trap2(int[] height){
        int[] maxRight = new int[height.length];
        int[] maxLeft = new int[height.length];
        for(int i=1;i<height.length;i++){
            maxLeft[i] = Math.max(height[i-1],maxLeft[i-1]);
        }
        for(int j=height.length-2;j>=0;j--){
            maxRight[j] = Math.max(height[j+1],maxRight[j+1]);
        }
        int res = 0;
        for(int i=1;i<height.length-1;i++){
            res+=Math.max(Math.min(maxLeft[i],maxRight[i])-height[i],0);
        }
        return res;
    }

    /**
     * 估计大家看到双指针空间优化有点绕，我改变了下逻辑，抛砖引玉解释：
     *
     * max_left记录left左边最大值，max_right记录right左边最大值，
     *
     * 若left_max < right_max,而right_max小于等于left右边最大值，因此left所在雨滴以left_max计算
     *
     * 同理，反之right所在雨滴以right_max计算
     * @param height
     * @return
     */

    public int trap3(int[] height){
        if (height.length<=2) return 0;
        int left = 1;
        int right = height.length - 2;
        int maxLeft = height[0]; // 记录left左边最大值
        int maxRight = height[height.length-1]; //记录right 右边最大值
        int res = 0;
        while(left<=right){
            if(maxLeft<maxRight){
                res += Math.max(maxLeft-height[left],0);
                maxLeft = Math.max(maxLeft, height[left]);
                left ++;
            } else {
                res += Math.max(maxRight-height[right],0);
                maxRight = Math.max(maxRight, height[right]);
                right --;
            }
        }
        return res;
    }
}
