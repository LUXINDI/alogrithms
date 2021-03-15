package com.xindi.minNumber_45;

import java.util.Arrays;

//不会写
//reference：https://leetcode-cn.com/problems/ba-shu-zu-pai-cheng-zui-xiao-de-shu-lcof/solution/mian-shi-ti-45-ba-shu-zu-pai-cheng-zui-xiao-de-s-4/
public class Solution {
    //本质上是一个排序问题
    //若拼接字符串 x+y>y+x，则x应该在y右边; x+y<y+x,则x应该在y左边
    //使用内置函数：(x,y)->(x+y).compareTo(y+x)
    public String minNumber(int[] nums){
        String[] strs = new String[nums.length];
        for(int i=0;i<nums.length;i++){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, (x,y)->(x+y).compareTo(y+x));
        StringBuilder res = new StringBuilder();
        for(String str:strs){
            res.append(str);
        }
        return res.toString();
    }
}
