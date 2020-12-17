package com.xindi;

public class MaxArea {
    public static int maxArea(int[] height) {
        if (height==null||height.length==0) return 0;
        int l=0;
        int r=height.length-1;
        int max = 0;
        while(l<r){
            int area = (r-l)*Math.min(height[l],height[r]);
            max = Math.max(max,area);
            if (height[l]<=height[r]){
                l++;
            }else{
                r--;
            }
        }
        return max;
    }

    public static void main(String[] args){
        int max = maxArea(new int[]{1,8,6,2,5,4,8,3,4});
        System.out.println(max);
    }
}
