package com.xindi;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 *
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 *
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 *
 *
 * 示例 1：
 *
 * 输入：grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * 输出：1
 *
 * 示例 2：
 *
 * 输入：grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * 输出：3
 */
class NumberOfIsLands {
  int num = 0;
  public int numIslands(char[][] grid) {
    if (grid == null || grid.length == 0 || grid[0].length == 0) return num;
    int m = grid.length;
    int n = grid[0].length;
    for(int i=0;i<m;i++){
      for(int j=0;j<n;j++){
        if (grid[i][j]=='1') {
          dfs(i, j, grid, m, n);
          num ++;
        }
      }
    }
    return num;
  }
  public void dfs(int i, int j, char[][] grid, int m, int n){
    grid[i][j] = '0';
    if (i+1<m && grid[i+1][j] == '1'){
      dfs(i+1,j, grid, m,n);
    }
    if (i-1>=0 && grid[i-1][j] == '1'){
      dfs(i-1,j, grid, m,n);
    }
    if (j+1<n && grid[i][j+1] == '1'){
      dfs(i,j+1, grid, m,n);
    }
    if (j-1>=0 && grid[i][j-1] == '1'){
      dfs(i,j-1, grid, m,n);
    }
    num ++;
  }

  public void dfs2(int i, int j, char[][] grid, int m, int n){
    if (i<0 || j<0 || i>=m || j>= n || grid[i][j] == '0') return;
    grid[i][j] = '0';
    dfs(i+1,j, grid, m,n);
    dfs(i-1,j, grid, m,n);
    dfs(i,j+1, grid, m,n);
    dfs(i,j-1, grid, m,n);
  }
}
