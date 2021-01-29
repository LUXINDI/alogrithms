package com.xindi.unique.paths.with.obstacles_63;

public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid){
        if (obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0){
            return 1;
        }
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for(int j=0;j<n;j++){
            if(obstacleGrid[0][j]==1){
                break;
            }
            dp[0][j] = 1;
        }
        for(int i=0;i<m;i++){
            if(obstacleGrid[i][0] ==1){
                break;
            }
            dp[i][0] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                if(obstacleGrid[i][j]==1){
                    dp[i][j] = 0;
                    continue;
                }
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
