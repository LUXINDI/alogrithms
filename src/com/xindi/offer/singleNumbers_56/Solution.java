package com.xindi.offer.singleNumbers_56;

//https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof/solution/jian-zhi-offer-56-i-shu-zu-zhong-shu-zi-tykom/

public class Solution {
    public int[] singleNumbers(int[] nums){
        int m=1;
        // a^b
        int temp = 0; // a^b
        for(int num:nums){
            temp^=num;
        }
        //找到a^b第一个为1的位置，即a和b第一个不同的位置
        while((temp&m)==0){
            m=m<<1;
        }
        int a=0;
        int b=0;
        //利用m和nums分别进行与操作，将a和b划分到两组中
        for(int num:nums){
            if((num&m)==0){
                a^=num;
            }else{
                b^=num;
            }
        }
        return new int[]{a,b};
    }
}
