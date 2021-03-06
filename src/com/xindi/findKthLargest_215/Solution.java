package com.xindi.findKthLargest_215;

import com.xindi.Utils;

import java.util.Random;

/**
 * reference: https://leetcode-cn.com/problems/kth-largest-element-in-an-array/solution/partitionfen-er-zhi-zhi-you-xian-dui-lie-java-dai-/
 */
public class Solution {
    Random random = new Random();
    public int findKthLargest(int[] nums, int k){
        int target = nums.length-k;
        int left = 0;
        int right = nums.length-1;
        while(true){
            int part = partition(nums,left,right);
            if(part==target){
                return nums[part];
            }else if (part<target){
                left=part+1;
            }else{
                right=part-1;
            }
        }

    }

    public int partition(int[] nums, int left, int right){
        if(left<right) {
            int randomInd = left + random.nextInt(right - left + 1);
            swap(nums, left, randomInd);
        }
        int pivot = nums[left];
        int ind = left;
        // [left+1, ind] <pivot
        // (ind,right] >= pivot
        for(int i=left+1;i<=right;i++){
            if(nums[i]<pivot){
                ind++;
                swap(nums, ind, i);
            }
        }
        swap(nums, left, ind);
        return ind;
    }

    public int partition3(int[] nums, int left, int right){
        if(left<right) {
            int randomInd = left + random.nextInt(right - left + 1);
            swap(nums, left, randomInd);
        }
        int pivot = nums[left];
        int lt = left+1;
        int rt = right;
        // [left+1,rt] <=pivot
        // [lt, right]>=pivot
        while(lt <= rt){
            //找到从左往右第一个>=pivot的数或者没找到lt>rt
            while(lt<=rt && nums[lt]<=pivot){
                lt++;
            }
            //找到从右往左第一个<=pivot的数或者没找lt>rt
            while(lt<=rt && nums[rt]>=pivot){
                rt--;
            }
            if(lt>rt){
                break;
            }
            swap(nums,lt,rt);
            lt++;
            rt--;
        }
        swap(nums, left,rt);
        return rt;
    }

    public int partition2(int[] nums, int left, int right){
        if(left<right) {
            int randomInd = left + random.nextInt(right - left + 1);
            swap(nums, left, randomInd);
        }
        int pivot = nums[left];
        int lt = left+1;
        int rt = right;

        //[left+1,lt) <=pivot
        //(rt,right] >=pivot
        while(lt<=rt){
            while(lt<=rt && nums[lt]<=pivot){
                lt++;
            }
            while(lt<=rt && nums[rt]>=pivot)
            {
                rt--;
            }
            if(lt>rt){
                break;
            }
            swap(nums, lt,rt);
            lt++;
            rt--;
        }
        swap(nums,left,rt);
        return rt;
    }

    public void swap(int[] nums,int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        int[] nums = new int[]{3,2,1,5,6,4};
        sol.findKthLargest(nums,2);


    }
}
