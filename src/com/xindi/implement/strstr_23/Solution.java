package com.xindi.implement.strstr_23;

public class Solution {
    public int strStr(String haystack, String needle){
        if ((needle == null && haystack == null)||(needle.length()==0)) return 0;

        if (needle == null || haystack == null || haystack.length() == 0  || needle.length() > haystack.length()){
            return -1;
        }
        if (needle.length() == haystack.length()){
            if (needle.equals(haystack)) return 0;
            else return -1;
        }

        boolean found = true;
        for(int j = 0; j <= haystack.length() - needle.length(); j++){
            found = false;
           if (haystack.charAt(j) == needle.charAt(0)){
               found = true;
               for(int i =0;i<needle.length();i++){
                   if (haystack.charAt(j+i) != needle.charAt(i)){
                       found = false;
                       break;
                   }
               }
           }
           if (found){
               return j;
           }
        }
        return -1;
    }
}
