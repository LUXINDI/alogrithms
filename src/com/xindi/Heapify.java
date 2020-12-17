package com.xindi;

class Heapify {
    public static void heapify(int[] A) {
        // write your code here
        for (int i = A.length/2; i >= 0; i--) {
            siftdown(A, i);
        }
    }

    private static void siftdown(int[] A, int k) {
        while (k < A.length) {
            int smallest = k;
            if (2 * k + 1 < A.length && A[2*k + 1]<A[smallest]){
                smallest = 2 * k + 1;
            }
            if (2 * k + 2 < A.length && A[2*k + 2] <A[smallest] ){
                smallest = 2 * k + 2;
            }
            if (smallest == k) {
                break;
            }
            int temp = A[k];
            A[k] = A[smallest];
            A[smallest] = temp;
            k = smallest;
        }
    }

    public static void main(String[] args){
        int[] A = new int[]{3,2,1,4,5};
        Heapify.heapify(A);
    }
}
