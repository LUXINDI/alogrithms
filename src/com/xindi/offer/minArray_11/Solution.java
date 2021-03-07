package com.xindi.offer.minArray_11;

public class Solution {
    public int minArray(int[] numbers){
        if (numbers==null || numbers.length==0 ) return -1;
        // find first position <= last number
        int start = 0;
        int end = numbers.length-1;
        while(start+1<end){
            int mid = start + (end-start)/2;
            if(numbers[mid]>numbers[end]){
                start = mid+1;
            }else if (numbers[mid]<numbers[end]){
                end = mid;
            }else{
                end--;
            }
        }
        return Math.min(numbers[start],numbers[end]);
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        sol.minArray(new int[]{1,3,5});
    }
}
