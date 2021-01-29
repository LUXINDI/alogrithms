package com.xindi.search.matrix_74;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target){
        int left = 0;
        int m = matrix.length;
        if(m==0) return false;
        int n = matrix[0].length;
        int right = m*n-1;
        while(left <= right){
            int mid = left + (right-left)/2;
            int pivot = matrix[mid/n][mid%n];
            if(pivot == target){
                return true;
            }
            if(pivot<target){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return false;
    }
}
