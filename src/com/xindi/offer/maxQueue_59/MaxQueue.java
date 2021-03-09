package com.xindi.offer.maxQueue_59;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 双端队列
// https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/solution/mian-shi-ti-59-ii-dui-lie-de-zui-da-zhi-by-leetcod/
// https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/solution/jian-zhi-offer-59-ii-dui-lie-de-zui-da-z-0pap/
public class MaxQueue {
    Queue<Integer> q;
    Deque<Integer> p;

    public MaxQueue(){
        q = new LinkedList<>();
        p = new LinkedList<>();
    }
    public int max_value(){
        if(p.isEmpty()) return -1;
        return p.peekFirst();
    }
    public void push_back(int value){
        while(!p.isEmpty()&&value>p.peekLast()){
            p.pollLast();
        }
        q.offer(value);
        p.offerLast(value);
    }
    public int pop_front(){
        if(q.isEmpty()) return -1;
        int val = q.poll();
        if(!p.isEmpty()&&val == p.peekFirst()){
            p.pollFirst();
        }
        return val;
    }
}
