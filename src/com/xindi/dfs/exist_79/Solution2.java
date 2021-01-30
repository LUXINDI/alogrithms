package com.xindi.dfs.exist_79;

public class Solution2 {
    char[][] board;
    String word;
    int[][] direction = {{-1,0},{1,0},{0,1},{0,-1}};
    int m;
    int n;
    boolean[][] marked;
    public boolean exist(char[][] board, String word){
        this.board = board;
        this.word = word;
        if(board == null) return false;
        this.m = board.length;
        if(m==0) return false;
        this.n = board[0].length;
        if(n==0) return false;
        marked = new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(dfs(i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean inArea(int x, int y){
        return x>=0 && x<m && y>=0 && y<n;
    }
    public boolean dfs(int i, int j, int begin){
        if(begin==word.length()-1){
            return word.charAt(begin) == board[i][j];
        }
        if(word.charAt(begin) == board[i][j]){
            marked[i][j] = true;
            for (int k=0;k<4;k++){
                int newX = i+direction[k][0];
                int newY = j+direction[k][1];
                if(inArea(newX,newY)&&!marked[newX][newY]){
                    if(dfs(newX,newY,begin+1)){
                        return true;
                    }
                }
            }
            marked[i][j] = false;
        }
        return false;
    }
}
