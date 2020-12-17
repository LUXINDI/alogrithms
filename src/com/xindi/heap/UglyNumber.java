package com.xindi.heap;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class UglyNumber {
    public static int nthUglyNumber(int n) {
        Queue<Integer> Q = new PriorityQueue<>();
        Set<Integer> inQ = new HashSet<>();
        Q.offer(1);
        inQ.add(1);

        int[] primes = new int[3];
        primes[0] = 2;
        primes[1] = 3;
        primes[2] = 5;
        int number = 1;
        for (int i=1; i<=n; i++){
            number = Q.poll();
            for (int j=0; j<3;j++){
                if (!inQ.contains(number*primes[j])){
                    Q.offer(number*primes[j]);
                    inQ.add(number*primes[j]);
                }
            }
        }
        return number;
    }

    public static void main(String[] args){
        nthUglyNumber(10);
    }
}
