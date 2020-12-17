package com.xindi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Merge {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        List<int[]> results = new ArrayList<>();
        for(int i=0; i<intervals.length; i++){
            int left = intervals[i][0];
            int right = intervals[i][1];
            while(i<intervals.length-1&&intervals[i+1][0]<=right){
                right = Math.max(right, intervals[i+1][1]);
                i++;
            }
            results.add(new int[]{left,right});
        }
        int[][] r = new int[results.size()][2];
        int i = 0;
        for(int[] res:results){
            r[i] = res;
            i++;
        }
        return r;
    }
}
