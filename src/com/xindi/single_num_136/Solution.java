package com.xindi.single_num_136;
//a^0=a a^a =0
public class Solution {
    public int singleNumber(int[] nums){
        int single = 0;
        for(int num:nums){
            single ^= num;
        }
        return single;
    }
}
