package com.xindi.remove.duplicates_26;

public class Solution_0130 {
    public int removeDuplicates(int[] nums){
        // [0,slow] 无重复元素
        if(nums==null || nums.length==0) return 0;
        int slow = 0;
        int fast = 1;
        while(fast < nums.length){
            if(nums[fast]!=nums[slow]){
                slow = slow+1;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow+1;
    }
}
