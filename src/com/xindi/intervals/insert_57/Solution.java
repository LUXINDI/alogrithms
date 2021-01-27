package com.xindi.intervals.insert_57;

import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/insert-interval/solution/bi-xu-miao-dong-li-kou-qu-jian-ti-mu-zhong-die-qu-/
 */
public class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval){
        int[][] res = new int[intervals.length+1][2];
        int idx = 0;
        //首先将在新区间左边并且与相离的区间加入
        int i = 0;
        while(i<intervals.length && intervals[i][1]<newInterval[0]){
            res[idx] = intervals[i];
            idx ++;
            i++;
        }
        //合并
        while(i<intervals.length && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res[idx] = newInterval;
        idx ++;
        //将在新区间右边并且与其相离的加入
        while(i<intervals.length){
            res[idx] = intervals[i];
            idx++;
            i++;
        }
        return Arrays.copyOf(res, idx);
    }
}
