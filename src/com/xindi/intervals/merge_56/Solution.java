package com.xindi.intervals.merge_56;

import java.util.Arrays;

/*
https://leetcode-cn.com/problems/merge-intervals/solution/chi-jing-ran-yi-yan-miao-dong-by-sweetiee/
 */
public class Solution {
    public int[][] merge(int[][] intervals){
        Arrays.sort(intervals, (v1,v2)->v1[0]-v2[0]);
        int idx = -1;
        int[][] res = new int[intervals.length][2];
        for(int[] interval : intervals){
            if(idx == -1 || interval[0] > res[idx][1]){
                idx ++;
                res[idx] = interval;
            }else{
                res[idx][1] = Math.max(res[idx][1], interval[1]);
            }
        }
        return Arrays.copyOf(res, idx+1);
    }
}
