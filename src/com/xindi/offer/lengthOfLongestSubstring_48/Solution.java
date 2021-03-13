package com.xindi.offer.lengthOfLongestSubstring_48;

import java.util.HashMap;
import java.util.Map;

//不会写
//reference: https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/solution/mian-shi-ti-48-zui-chang-bu-han-zhong-fu-zi-fu-d-9/
public class Solution {
    //dp[j]:以s[j]为结尾的，最长不重复子字符串的长度
    //固定右边界j, s[j]左边距离最近的相同字符为s[i],s[i]=s[j]
    //根据dp[j-1]有没有包含s[i]来判断dp[j]
    //dp[j-1]是否包含s[i]: i+dp[j-1]<j(没有包含)
    //如果dp[j-1]没有包含s[i],dp[j] = dp[i-1]+1 （dp[j-1]<j-i）
    //如果dp[j-1]包含了s[i]，dp[j]= j-(i+1)+1=j-i (dp[j-1]>=j-i)
    //动态规划加哈希表
    public int lengthOfLongestSubstring(String s){
        Map<Character,Integer> dic = new HashMap<>();
        int res=0;
        int tmp=0;
        for(int j=0;j<s.length();j++){
            int i = dic.getOrDefault(s.charAt(j),-1);
            dic.put(s.charAt(j), j);
            tmp = tmp<j-i?tmp+1:j-i;
            res= Math.max(res,tmp);
        }
        return res;
    }

    //动态规划+线性遍历
    public int lengthOfLongestSubstring2(String s){
        int res = 0;
        int tmp = 0;
        for(int j=0;j<s.length();j++){
            int i=j-1;
            //向前搜索第一个与s[j]相等的索引
            while(i>=0&&s.charAt(i)!=s.charAt(j)){
                i--;
            }
            tmp = tmp<j-i ? tmp+1:j-i;
            res = Math.max(res, tmp);
        }
        return res;
    }
}
