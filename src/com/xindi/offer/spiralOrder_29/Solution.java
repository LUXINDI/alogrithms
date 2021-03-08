package com.xindi.offer.spiralOrder_29;

/**
 * reference:
 * https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof/solution/mian-shi-ti-29-shun-shi-zhen-da-yin-ju-zhen-she-di/
 */
public class Solution {
    public int[] spiralOrder(int[][] matrix){
        if(matrix==null||matrix.length==0||matrix[0].length==0){
            return new int[]{};
        }
        int l = 0; // 左边界
        int r = matrix[0].length-1; //右边界
        int t = 0; // 上边界
        int b = matrix.length-1; // 下边界
        int[] res = new int[(r+1)*(b+1)];
        int ind =0;
        while(true){
            //left to right
            for(int i=l;i<=r;i++){
                res[ind++] = matrix[t][i];
            }
            if(++t>b) break;
            //top to bottom
            for(int i=t;i<=b;i++){
                res[ind++] = matrix[i][r];
            }
            if(--r<l) break;
            // right to left
            for(int i=r;i>=l;i--){
                res[ind++] = matrix[b][i];
            }
            if(--b<t) break;
            // bottom to top
            for(int i=b;i>=t;i--){
                res[ind++] = matrix[i][l];
            }
            if(++l>r) break;
        }
        return res;
    }
}
