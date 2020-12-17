package com.xindi;

import java.util.*;

class TopKFrequent {
    private Map<Integer, Integer> getFreqMap(int[] nums){
        Map<Integer, Integer> occur = new HashMap<>();
        for (int num: nums){
            occur.put(num, occur.getOrDefault(num,0)+1);
        }
        return occur;
    }
    public int[] topKFrequent3(int[] nums, int k){
        Map<Integer, Integer> occur = getFreqMap(nums);
        List<Integer>[] list = new List[nums.length+1];
        for(Map.Entry<Integer, Integer> entry : occur.entrySet()){
            int val = entry.getKey();
            int freq= entry.getValue();
            if (list[freq] == null){
                list[freq] = new ArrayList<>();
            }
            list[freq].add(val);
        }
        int[] res = new int[k];
        int idx = 0;
        for(int i = nums.length; i>=1&&idx<k;i--){
            if(list[i]!=null){
                for(int v : list[i]){
                   res[idx] = v;
                   idx++;
                }
            }
        }
        return res;

    }
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> occur = getFreqMap(nums);
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(
                new Comparator<int[]>(){
                    public int compare(int[] m, int[] n){
                        return m[1] - n[1];
                    }
                });
        for(Map.Entry<Integer, Integer> entry : occur.entrySet()){
            int val = entry.getKey();
            int freq = entry.getValue();
            if (heap.size()<k){
                heap.offer(new int[]{val, freq});
            } else if (heap.size()==k){
                if (heap.peek()[1]<freq){
                    heap.offer(new int[]{val,freq});
                    heap.poll();
                }
            }
        }
        int[] res = new int[k];
        for(int i=0;i<k;i++){
            res[i] = heap.poll()[0];
        }
        return res;
    }
}
