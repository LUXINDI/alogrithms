package com.xindi.offer.exist_12;

class Solution {
    char[][] board;
    boolean[][] visited;
    int m, n;
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || board[0].length == 0) return false;
        int m = board.length;
        int n = board[0].length;
        this.board = board;
        this.m = m;
        this.n = n;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                visited = new boolean[m][n];
                if(dfs(i,j,0, word.toCharArray())) return true;
            }
        }
        return false;
    }
    public boolean dfs(int i, int j, int ind, char[] charArr) {
        if(i>=m||j>=n||i<0||j<0||visited[i][j] || ind>=charArr.length||board[i][j]!=charArr[ind]) return false;
        if(ind==charArr.length-1) return true;
        visited[i][j] = true;
        boolean res = dfs(i+1,j,ind+1,charArr) || dfs(i,j+1,ind+1,charArr) || dfs(i-1,j,ind+1,charArr) || dfs(i,j-1,ind+1,charArr);
        //注意要将visited[i][j]还原，因为只代表此次搜索过程中，该元素已访问过，当初始i j变化时，又开始了另一次搜索过程
        visited[i][j] = false;
        return res;
    }
}


