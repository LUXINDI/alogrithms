package com.xindi.offer.exchange_21;

/**reference:
 * https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof/solution/ti-jie-shou-wei-shuang-zhi-zhen-kuai-man-shuang-zh/
 */
//快慢指针
// fast作用是向前搜索奇数位置
//low 的作用是指向下一个奇数应当存放的位置
public class Solution2 {
    public int[] exchange(int[] nums){
        int slow = 0;
        int fast = 0;
        while(fast<nums.length){
            if(nums[fast]%2==1){
                swap(nums,slow,fast);
                slow++;
            }
            fast++;
        }
        return nums;
    }
    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args){
        int[] nums = new int[]{0,5,6,7,10,3};
        Solution2 sol = new Solution2();
        sol.exchange(nums);
    }
}
