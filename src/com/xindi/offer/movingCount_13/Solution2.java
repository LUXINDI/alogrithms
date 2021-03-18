package com.xindi.offer.movingCount_13;

import java.util.LinkedList;
import java.util.Queue;

public class Solution2 {
    public int movingCount(int m, int n, int k){
        boolean[][] visited  = new boolean[m][n];
        Queue<int []> queue = new LinkedList<>();
        queue.offer(new int[]{0,0,0,0});
        int res = 0;
        while(!queue.isEmpty()){
            int[] q = queue.poll();
            int i=q[0];
            int j=q[1];
            int si = q[2];
            int sj = q[3];
            if(i>=m||j>=n||si+sj>k||visited[i][j]) continue;
            visited[i][j] = true;
            res++;
            int iplus = (i+1)%10==0 ? si-8 : si+1;
            int jplus = (j+1)%10==0 ? sj-8 : sj+1;
            queue.offer(new int[]{i+1,j,iplus,sj});
            queue.offer(new int[]{i,j+1,si,jplus});
        }
        return res;
    }
}
