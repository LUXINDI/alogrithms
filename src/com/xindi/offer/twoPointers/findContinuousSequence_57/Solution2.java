package com.xindi.offer.twoPointers.findContinuousSequence_57;

import java.util.ArrayList;
import java.util.List;

public class Solution2 {
    //双指针
    //时间复杂度 o(target)
    public int[][] findContinuousSequence(int target){
        int left=1;
        int right=2;
        List<int[]> res = new ArrayList<>();
        while(left<right){
            int sum = (left+right)*(right-left+1)/2;
            if(sum==target){
                int[] cur = new int[right-left+1];
                for(int i=0;i<right-left+1;i++){
                    cur[i]=left+i;
                }
                res.add(cur);
                //枚举下一个起点
                left++;
            }else if(sum<target){
                //右指针还可以向右移使得sum变大
                right++;
            }else {
                //以left为起点的不存在 sum==target,枚举下一个起点
                left++;
            }
        }
        return res.toArray(new int[0][]);
    }
}
