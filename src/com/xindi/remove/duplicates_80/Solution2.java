package com.xindi.remove.duplicates_80;

public class Solution2 {
    public int removeDuplicates(int[] nums){
        if(nums==null) return 0;
        if(nums.length<=2) return nums.length;
        // [0,slow] 数字重复<=2
        int slow = 1;
        int fast = 2;
        while(fast<nums.length){
            if(nums[fast] == nums[slow-1]){
                fast++;
            }else{
                slow++;
                nums[slow] = nums[fast];
                fast++;
            }
        }
        return slow+1;
    }
}
