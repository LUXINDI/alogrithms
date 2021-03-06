package com.xindi.generate_118;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> generate(int numRows){
        List<List<Integer>> res = new ArrayList<>();
        for(int row=1;row<=numRows;row++){
            List<Integer> cur = new ArrayList<>();
            cur.add(1);
            if (row<=1) {
                res.add(cur);
                continue;
            }
            for(int col=1;col<row-1;col++){
                int num= res.get(row-2).get(col-1)+res.get(row-2).get(col);
                cur.add(num);
            }
            cur.add(1);
            res.add(cur);
        }
        return res;
    }

    public static void main(String[] args){
        Solution sol = new Solution();
        sol.generate(5);
    }
}
