package com.xindi.offer.findNumberIn2DArray;

public class Solution {
    /**reference:https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/solution/mian-shi-ti-04-er-wei-shu-zu-zhong-de-cha-zhao-zuo/
     * 
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target){
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return false;
        int m = matrix.length;
        int n = matrix[0].length;
        //从矩阵右上角元素开始查找
        int i=0;
        int j=n-1;
        while(i<m&&j>=0) {
            if (matrix[i][j] == target) {
                return true;
            } else if (matrix[i][j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }
}
