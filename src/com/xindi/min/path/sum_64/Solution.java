package com.xindi.min.path.sum_64;

import com.xindi.Utils;

public class Solution {
    public int minPathSum(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        dp[0] = grid[0][0];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j>=1){
                    dp[j] = dp[j-1]+grid[i][j];
                    continue;
                }
                if(j==0 && i>=1){
                    dp[j] = dp[j] + grid[i][j];
                    continue;
                }
                if(i>=1 && j>=1){
                    dp[j] = Math.min(dp[j],dp[j-1])+grid[i][j];
                }
            }
            Utils.printArray(dp);
        }
        return dp[n-1];
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] grid = new int[][]{new int[]{1,3,1},
                new int[]{1,5,1},
                new int[]{4,2,1}};
        sol.minPathSum(grid);
    }
}
