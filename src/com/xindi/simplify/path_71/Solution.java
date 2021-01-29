package com.xindi.simplify.path_71;

import sun.tools.jstat.JStatLogger;
import sun.tools.jstat.Jstat;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * https://leetcode-cn.com/problems/simplify-path/solution/java-shi-yong-splitfen-ge-hou-shi-yong-zhan-lai-mo/
 */
public class Solution {
    public String simplifyPath(String path){
        String[] paths = path.split("/");
        Deque<String> stack = new ArrayDeque<>();
        for(int i=0;i<paths.length;i++){
            if (paths[i].length()==0 || paths[i].equals(".")) continue;
            if(!stack.isEmpty()){
                if(paths[i].equals("..")){
                    stack.pop();
                }else{
                    stack.push(paths[i]);
                }
            } else{
                if(!paths[i].equals("..")){
                    stack.push(paths[i]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if(stack.isEmpty()) return "/";
        while(!stack.isEmpty()){
            sb.insert(0,stack.pop());
            sb.insert(0,'/');
        }
        return sb.toString();
    }
    public static void main(String[] args){
        Solution sol = new Solution();
        sol.simplifyPath("/a//b////c/d//././/..");
    }
}
