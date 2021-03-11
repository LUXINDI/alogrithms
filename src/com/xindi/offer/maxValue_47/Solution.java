package com.xindi.offer.maxValue_47;

import com.xindi.Utils;

//比较简单，不用看
public class Solution {
    public int maxValue(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        dp[0][0] = grid[0][0];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1])+grid[i-1][j-1];
            }
        }
        return dp[m][n];
    }

    public int maxValue2(int[][] grid){
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(j==0){
                    dp[j]=dp[j]+grid[i][j];
                }else {
                    dp[j] = Math.max(dp[j-1], dp[j]) + grid[i][j];
                }
            }
            Utils.printArray(dp);
        }
        return dp[n-1];
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[][] grid = new int[][]{{1,3,1},{1,5,1},{4,2,1}};
        sol.maxValue2(grid);
    }
}
