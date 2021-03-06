package com.xindi.offer.twoPointers.getKthFromEnd_22.findContinuousSequence_57;

import java.util.ArrayList;
import java.util.List;

/**
 * reference: https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/jian-zhi-offer-57-ii-he-wei-s-de-lian-xu-t85z/
 */
public class Solution {
    //解方程
    public int[][] findContinuousSequence(int target){
        int i = 1;
        double j=2.0;
        List<int[]> res = new ArrayList<>();
        while(i<j){
            //计算公式i*i项可能超过 int 类型取值范围，因此在 Java, C++ 中需要转化成 long 类型
            j = (-1+Math.sqrt(1+4*(2*target+(long)i*i-i)))/2.0;
            if(j==(int)j){
                int len = (int)j-i+1;
                int[] cur = new int[len];
                for(int k=0;k<len;k++){
                    cur[k]=i+k;
                }
                res.add(cur);
            }
            i++;
        }
        return res.toArray(new int[0][]);
    }
}
