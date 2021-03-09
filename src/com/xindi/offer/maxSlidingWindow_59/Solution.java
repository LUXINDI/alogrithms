package com.xindi.offer.maxSlidingWindow_59;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int[] maxSlidingWindow(int[] nums, int k){
        if(nums==null||nums.length==0||k==0) return new int[]{};
        Deque<Integer> q = new LinkedList<>();
        for(int i=0;i<k;i++){
            while(!q.isEmpty()&&q.peekLast()<nums[i]){
                q.pollLast();
            }
            q.offerLast(nums[i]);
        }
        int[] res = new int[nums.length-k+1];
        res[0] = q.peekFirst();
        for(int i=1;i<=nums.length-k;i++){
            // window:i~i+k-1
            //去掉i-1
            if(nums[i-1]==q.peekFirst()){
                q.pollFirst();
            }
            while(!q.isEmpty()&& q.peekLast()< nums[i+k-1]){
                q.pollLast();
            }
            q.offerLast(nums[i+k-1]);
            res[i] = q.peekFirst();
        }
        return res;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        sol.maxSlidingWindow(new int[]{4,3,11},3);
    }
}
