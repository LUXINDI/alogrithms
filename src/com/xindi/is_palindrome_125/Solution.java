package com.xindi.is_palindrome_125;

public class Solution {
    public boolean isPalindrome(String s){
        s=s.toLowerCase();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();i++){
            if(Character.isLetterOrDigit(s.charAt(i))){
                sb.append(s.charAt(i));
            }
        }
        int left = 0;
        int right = sb.length()-1;
        while(left<=right){
            if(sb.charAt(left)==sb.charAt(right)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }

    public boolean isPalindrome2(String s){
        s=s.toLowerCase();
        int left = 0;
        int right = s.length()-1;
        while(left<=right){
            while(left<=right&&!Character.isLetterOrDigit(s.charAt(left))){
                left++;
            }
            while(left<=right&&!Character.isLetterOrDigit(s.charAt(right))){
                right--;
            }
            if(left<=right) {
                if (s.charAt(left) == s.charAt(right)) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        sol.isPalindrome("A man, a plan, a canal: Panama");
    }
}
