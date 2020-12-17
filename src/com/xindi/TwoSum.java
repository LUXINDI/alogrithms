package com.xindi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TwoSum {
    List<Integer> arr = new ArrayList<>();
    /**
     * @param number: An integer
     * @return: nothing
     */
    public void add(int number) {
        // write your code here
        this.arr.add(number);
    }

    /**
     * @param value: An integer
     * @return: Find if there exists any pair of numbers which sum is equal to the value.
     */
    public boolean find(int value) {
        // write your code here
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<this.arr.size(); i++){
            if (map.containsKey(value - this.arr.get(i))){
                return true;
            }
            map.put(this.arr.get(i), i);
        }
        return false;

    }
}
