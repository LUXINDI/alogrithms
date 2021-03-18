package com.xindi.offer.movingCount_13;

//reference:https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/solution/mian-shi-ti-13-ji-qi-ren-de-yun-dong-fan-wei-dfs-b/
public class Solution {
    //数位和增量公式
    //设x的数位和为s(x), x+1的数位和为s(x+1)
    //若(x+1)%10==0 s(x+1)=s(x)-8
    //若(x+1)%10!=0 s(x+1)=s(x)+1
    int m,n,k;
    boolean[][] visited;
    public int movingCount(int m, int n, int k){
        this.m = m;
        this.n = n;
        this.k = k;
        visited = new boolean[m][n];
        return dfs(0,0,0,0);
    }

    public int dfs(int i, int j, int si, int sj){
        //索引越界|| 数位和>k || 访问
        if(i>=m||j>=n||si+sj>k||visited[i][j]){
            return 0;
        }
        visited[i][j] = true;
        int siplus = (i+1)%10==0 ? si-8 : si+1;
        int sjplus = (j+1)%10==0 ? sj-8 : sj+1;
        return 1+ dfs(i+1,j,siplus,sj) + dfs(i,j+1,si,sjplus);
    }
}
