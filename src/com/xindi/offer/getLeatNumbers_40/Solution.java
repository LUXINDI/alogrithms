package com.xindi.offer.getLeatNumbers_40;

import java.util.PriorityQueue;

//最小堆
public class Solution {
    public int[] getLeastNumbers(int[] arr, int k){
        if (k==0) return new int[]{};
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(k, (a,b)->a-b);
        for(int n : arr){
            minHeap.add(n);
        }
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = minHeap.poll();
        }
        return res;
    }
}
