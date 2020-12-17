package com.xindi;

public class CanJump {
    public boolean canJump(int[] nums) {
        int maxK=0;
        for (int i=0;i<nums.length;i++){
            if (i>maxK) return false;
            if(i+nums[i]>maxK){
                maxK = i+nums[i];
            }

        }
        return true;
    }
    public static void main (String[] args){
        CanJump jump = new CanJump();
        jump.canJump(new int[]{3,2,1,0,4});
    }
}
