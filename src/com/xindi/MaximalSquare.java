package com.xindi;

/**
 * https://leetcode-cn.com/problems/maximal-square/solution/zui-da-zheng-fang-xing-by-leetcode-solution/
 */
public class MaximalSquare {
    public int maximalSquare(char[][] square){
        if (square == null || square.length == 0 || square[0].length == 0) return 0;
        int m = square.length;
        int n = square[0].length;
        int maxSide = 0;
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(square[i][j]=='0') {
                    dp[i][j] = 0;
                    continue;
                }
                if (i==0||j==0){
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                maxSide = Math.max(dp[i][j], maxSide);
            }
        }
        return maxSide * maxSide;

    }
}
