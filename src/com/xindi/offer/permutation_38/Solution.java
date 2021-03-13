package com.xindi.offer.permutation_38;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//写错了。后参考答案
//reference:https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof/solution/mian-shi-ti-38-zi-fu-chuan-de-pai-lie-hui-su-fa-by/
public class Solution {
    List<String> res = new ArrayList<>();
    char[] c;
    public String[] permutation(String s){
        c = s.toCharArray();
        dfs(0);
        //注意如何将list转为string
        return res.toArray(new String[res.size()]);
    }

    public void dfs(int start){
        if(start==c.length){
            res.add(String.valueOf(c));
            return;
        }
        //同一个固定位，相同的字母只能出现一次
        Set<Character> set = new HashSet<>();
        for(int i=start;i<c.length;i++){
            if(set.contains(c[i])) continue;
            set.add(c[i]);
            swap(c,start,i); //交换，将c[i]固定在start位置
            dfs(start+1);//固定start+1位
            swap(c,i,start); //恢复交换
        }
    }

    public void swap(char[] c, int i, int j){
        char temp = c[i];
        c[i] = c[j];
        c[j] = temp;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        sol.permutation("abb");
        sol.permutation("abc");
    }
}
