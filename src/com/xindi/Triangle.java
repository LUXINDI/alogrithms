package com.xindi;

public class Triangle {
    public static int minimumTotal(int[][] triangle) {
        // write your code here
        int n = triangle.length;
        int A[][] = new int[n][n];
        for(int i=0;i<=n-1;i++){
            A[n-1][i] = triangle[n-1][i];
        }
        for(int i=n-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                A[i][j]=triangle[i][j] + Math.min(A[i+1][j],A[i+1][j+1]);
            }
        }
        return A[0][0];

    }

    public static void main(String[] args) {

    }
}
