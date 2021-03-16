package com.xindi.offer.singleNumber_56_2;

//不会写
//位运算
// reference： https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/solution/mian-shi-ti-56-ii-shu-zu-zhong-shu-zi-chu-xian-d-4/
public class Solution {
    //reference: https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof/solution/javashi-xian-jian-zhi-si-lu-wei-yun-suan-zhu-wei-t/
    public int singleNumber(int[] nums){
        //把所有出现三次的数字的二进制表示的每一位分别加起来，每一位的和都能被3整除
        //对3取余，得到的就是只出现一次的数
        //Java int类型有32位，首位为符号位
        //用一个长度为32的辅助数组存储二进制表示的每一位的和
        int[] bitSum = new int[32]; //统计所有数各位二进制的和
        for(int num:nums) {
            int bitMask = 1;
            for (int i = 31; i >= 0; i--) {
                //注意这里的判断并不是==1！！ 可以是 num&bitMask==bitMask
                if((num&bitMask)!=0){
                    bitSum[i]++;
                }
                bitMask = bitMask<<1;
            }
        }
        int res = 0;
        for(int i=0;i<32;i++){
            res = res<<1;
            res +=bitSum[i]%3;
        }
        return res;
    }
}
