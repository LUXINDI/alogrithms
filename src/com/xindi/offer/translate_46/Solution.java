package com.xindi.offer.translate_46;

/**reference
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/solution/mian-shi-ti-46-ba-shu-zi-fan-yi-cheng-zi-fu-chua-6/
 */
public class Solution {
    //从左向右遍历
    public int translateNum(int num){
        String numStr = String.valueOf(num);
        int a=1;
        int b=1;
        for(int i=2;i<=numStr.length();i++){
            String temp = numStr.substring(i-2,i);
            int c = b;
            if(temp.compareTo("10")>=0&&temp.compareTo("25")<=0){
                c = a+b;
            }
            a = b;
            b = c;
        }
        return b;
    }

    // 从右向左遍历
    public int translateNum2(int num){
        String numStr = String.valueOf(num);
        int a = 1;
        int b=1;
        for(int i=numStr.length()-2;i>=0;i--){
            String temp = numStr.substring(i,i+2);
            int c = temp.compareTo("10")>=0 && temp.compareTo("25")<=0 ? a+b:b;
            a = b;
            b = c;
        }
        return b;
    }

    public int translateNum3(int num){
        int a = 1;
        int b = 1;
        int lastD = num%10;
        num = num/10;
        while(num!=0){
            int digit = num%10;
            num = num/10;
            int twoDigits = digit*10+lastD;
            int c = twoDigits>=10 && twoDigits<=25 ? a+b :b;
            a = b;
            b = c;
            lastD = digit;
        }
        return b;
    }
}
