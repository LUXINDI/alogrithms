package com.xindi.offer.reverseleftWords_58;

public class Solution2 {
    //字符串切片
    public String reverseLeftWords(String s, int n){
        return s.substring(n,s.length())+s.substring(0,n);
    }

    //列表遍历拼接
    public String reverseLeftWords2(String s, int n){
        StringBuilder sb = new StringBuilder();
        int len = s.length();
        //0,n-1
        //n,len-1
        for(int i=n;i<=len-1;i++){
            sb.append(s.charAt(i));
        }
        for(int i=0;i<=n-1;i++){
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }

    //取余简化
    public String reverseLeftWords3(String s, int n){
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for(int i=n;i<n+len;i++){
            sb.append(s.charAt(i%len));
        }
        return sb.toString();
    }
}
