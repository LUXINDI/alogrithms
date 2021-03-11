package com.xindi.offer.majorityElement_39;

// 看答案写的
// reference：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof/solution/mian-shi-ti-39-shu-zu-zhong-chu-xian-ci-shu-chao-3/
public class Solution {
    //不同的数字抵消，占一半以上的一定留到最后
    public int majorityElement(int[] nums){
        int votes=0;
        int majority = 0;
        for(int i=0;i<nums.length;i++){
            if(votes==0){
                majority=nums[i];
                votes=1;
            }else{
                votes += nums[i]==majority ? 1:-1;
            }
        }
        return majority;
    }
}
