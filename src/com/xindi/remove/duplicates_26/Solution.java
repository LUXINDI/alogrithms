package com.xindi.remove.duplicates_26;

public class Solution {
    // 0 0 1 1 1 2 3 4 4 5
    // 0 1 1 1 1 2 3 4 4 5
    // slow = 0, fast = 2
    // slow = 1, fast = 3
    public int removeDuplicates(int[] nums){
        int slow =0;
        int fast = 1;
        while(fast < nums.length){
            if(nums[fast] == nums[slow]){
                fast ++;
            } else {
                if(slow + 1 < fast) {
                    nums[slow + 1] = nums[fast];
                }
                slow ++;
                fast ++;
            }
        }
        return slow + 1;
    }
}
