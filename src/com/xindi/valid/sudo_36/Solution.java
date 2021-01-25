package com.xindi.valid.sudo_36;

import java.util.HashMap;

public class Solution {
    public boolean isValidSudoKu(char[][] board){
        HashMap<Integer, Integer>[] row = new HashMap[9];
        HashMap<Integer, Integer>[] col = new HashMap[9];
        HashMap<Integer, Integer>[] box = new HashMap[9];
        for (int i =0;i<9;i++){
            row[i] = new HashMap<>();
            col[i] = new HashMap<>();
            box[i] = new HashMap<>();
        }
        for (int i=0; i<9 ;i ++){
            for(int j = 0;j<9;j++){
                char n = board[i][j];
                if (n!='.'){
                    int num = (int)n;
                    int boxInd = (i/3)*3 + j/3;
                    row[i].put(num, row[i].getOrDefault(num,0)+1);
                    col[j].put(num, col[j].getOrDefault(num,0)+1);
                    box[boxInd].put(num, box[boxInd].getOrDefault(num,0)+1);

                    if (row[i].get(num)>1 || col[j].get(num)>1 || box[boxInd].get(num)>1){
                        return false;
                    }
                }

            }
        }
        return true;

    }
}
