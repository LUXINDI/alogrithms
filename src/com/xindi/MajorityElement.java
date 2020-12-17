package com.xindi;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public int majorityElement(int[] nums){



        int cand = nums[0];
        int cnt = 1;
        for(int i=1;i<nums.length;i++){
            if (cnt == 0){
                cand = nums[i];
                cnt = 1;
                continue;
            }
            if (nums[i] == cand){
                cnt ++;
            } else {
                cnt --;
            }
        }
        return cand;
    }
}
