package com.xindi.sort.colors_75;

/**
 * https://leetcode-cn.com/problems/sort-colors/solution/kuai-su-pai-xu-partition-guo-cheng-she-ji-xun-huan/
 */
public class Solution2 {
    public void sortColors(int[] nums){
        //[0,zero) 都是0
        //[zero,i) 都是1
        //[two,len-1] 都是2
        int left =0; //头部区域，把0都移到头部区域 【0，left) 0
        // [left,i) 1
        int i =0;
        int right = nums.length; //尾部区域，把2都移到尾部区域 [right,len-1] 2
        while(i<right){
            if(nums[i] == 0){
                swap(nums,left,i);
                left ++;
                i++;
            }else if (nums[i]==2){
                right --;
                swap(nums,right,i);
            }else{
                i++;
            }
        }
    }
    public void swap(int[] nums, int idx1, int idx2){
        int temp = nums[idx1];
        nums[idx1] = nums[idx2];
        nums[idx2] = temp;
    }
}
