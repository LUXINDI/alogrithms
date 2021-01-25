package com.xindi;

import java.util.List;

public class Utils {
    public static String printPath(List<Integer> A){
        StringBuilder sb = new StringBuilder();
        for(int a:A){
            sb.append(a);
            sb.append("->");
        }
        return sb.substring(0,sb.length()-2);
    }
    public static void printArray(int[] A){
        StringBuilder sb = new StringBuilder();
        for (int a:A){
            sb.append(a);
            sb.append(",");
        }
        System.out.println(sb.toString().substring(0, sb.length()-1));
    }
}
