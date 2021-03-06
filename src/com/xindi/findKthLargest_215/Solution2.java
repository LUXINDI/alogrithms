package com.xindi.findKthLargest_215;

import java.util.PriorityQueue;

//heap
public class Solution2 {
    public int findKthLargest(int[] nums,int k){
        int len = nums.length;
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>(len,(a,b)->a-b);
        for(int i=0;i<len;i++){
            minHeap.add(nums[i]);
        }
        for(int i=0;i<len-k;i++){
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
