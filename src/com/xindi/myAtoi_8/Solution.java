package com.xindi.myAtoi_8;
//          ' '  '+/-' '0-9' other
// start    start signed in_number end
// signed   end   end    in_number end
// in_number end  end  in_number end
// end   end end end end

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int myAtoi(String s){
        Automation auto = new Automation();
        for(char c : s.toCharArray()){
            auto.get(c);
        }
        return auto.sign * (int)auto.ans;
    }
    class Automation{
        Map<String, String[]> table;
        public int sign = 1;
        public long ans = 0;
        final String START = "start";
        final String NUMBER = "number";
        final String SIGNED = "signed";
        final String END = "end";
        String state = START;

        public Automation(){
            table = new HashMap<>();
            table.put(START, new String[]{START, SIGNED, NUMBER, END});
            table.put(SIGNED, new String[]{END,END, NUMBER, END});
            table.put(NUMBER, new String[]{END, END, NUMBER, END});
            table.put(END, new String[]{END, END, END, END});
        }

        public int getCol(char c){
            if (c == ' ') return 0;
            if (c == '+' || c == '-') return 1;
            if (c >= '0' && c <= '9') return 2;
            return 3;
        }

        public void get(char c){
            state = table.get(state)[getCol(c)];
            if (state.equals(SIGNED)){
                sign = c == '+' ? 1 : -1;
            }else if (state.equals(NUMBER)){
                ans = ans * 10 + c - '0';
                //[-2**31, 2**31-1]
                if (sign == 1){
                    ans = Math.min(ans , Integer.MAX_VALUE);
                } else {
                    ans = Math.min(ans, -(long)Integer.MIN_VALUE);
                }
            }
        }
    }
}
