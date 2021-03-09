package com.xindi.offer.sumNums_64;

/**
 * https://leetcode-cn.com/problems/qiu-12n-lcof/solution/mian-shi-ti-64-qiu-1-2-nluo-ji-fu-duan-lu-qing-xi-/
 */
public class Solution {
    //递归，用到了if
    public int sumNums(int n){
        if(n==1) return n;
        return n+sumNums(n-1);
    }
    public int sumNums2(int n){
        //n > 1 && sumNums(n - 1) // 当 n = 1 时 n > 1 不成立 ，此时 “短路” ，终止后续递归
        // Java 中，为构成语句，需加一个辅助布尔量x,否则会报错；
        //Java 中，开启递归函数需改写为 sumNums(n - 1) > 0 ，此整体作为一个布尔量输出，否则会报错；
        boolean x = (n>1) && (n+=sumNums2(n-1))>0;
        return n;
    }
}
