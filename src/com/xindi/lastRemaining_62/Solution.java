package com.xindi.lastRemaining_62;

//reference:https://leetcode-cn.com/problems/yuan-quan-zhong-zui-hou-sheng-xia-de-shu-zi-lcof/solution/jian-zhi-offer-62-yuan-quan-zhong-zui-ho-dcow/
public class Solution {
    //x=(x+t)%n
    //f(n)=(f(n-1)+m%n)%n=(f(n-1)+m)%n
    //f(1)=0
    public int lastRemaining(int n, int m){
        int x=0;
        for(int i=2;i<=n;i++){
            x = (x+m)%i;
        }
        return x;
    }
}
