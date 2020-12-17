package com.xindi;

public class Utils {
    public static void printArray(int[] A){
        StringBuilder sb = new StringBuilder();
        for (int a:A){
            sb.append(a);
            sb.append(",");
        }
        System.out.println(sb.toString().substring(0, sb.length()-1));
    }
}
