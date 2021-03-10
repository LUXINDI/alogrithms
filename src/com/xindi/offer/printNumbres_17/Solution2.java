package com.xindi.offer.printNumbres_17;

//考虑大数，要使用全排列???
//没有写对
public class Solution2 {
    StringBuilder res;
    StringBuilder path = new StringBuilder();
    int n;
    char[] loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    public String printNumbers(int n){
        res = new StringBuilder();
        this.n = n;
        dfs(0);
        return res.deleteCharAt(res.length()-1).toString();
    }
    public void dfs(int k){
        if(k==n){
            res.append(path);
            res.append(",");
            return;
        }
        int start;
        if(k==0){
            start=1;
        }else{
            start=0;
        }
        for(int i=start;i<loop.length;i++){
            path.append(loop[i]);
            dfs(k+1);
            path.deleteCharAt(k);
        }
    }
    public static void main(String[] args){
        Solution2 sol = new Solution2();
        System.out.println(sol.printNumbers(2));
    }
}
