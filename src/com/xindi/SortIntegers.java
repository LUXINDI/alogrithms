package com.xindi;

import static com.xindi.Utils.printArray;

public class SortIntegers {
    public void mergeSort(int[] A, int start, int end, int[] temp){
        mergeSort(A, start, (start+end)/2, temp);
        mergeSort(A, (start+end)/2+1, end, temp);
        merge(A, start, end, temp);
    }

    private void merge(int[] A, int start, int end, int[] temp){
        int middle = (start+end)/2;
        int leftIndex = start;
        int rightIndex = middle + 1;
        int index = leftIndex;
        while(leftIndex <= middle && rightIndex <= end){
            if(A[leftIndex] <= A[rightIndex]){
                temp[index++] = A[leftIndex++];
            }else {
                temp[index++] = A[rightIndex++];
            }
        }
        while(leftIndex <= middle){
            temp[index++] = A[leftIndex++];
        }
        while(rightIndex <= end){
            temp[index++] = A[rightIndex++];
        }
    }

    private void quickSort(int[] A, int start, int end){
        if (start >= end){
            return;
        }
        printArray(A);
        int pivot = A[(start+end)/2];
        System.out.println("pivot == " + pivot);
        int left =  start;
        int right = end;
        while (left <= right){
            while (left <= right && A[left] < pivot){
                left ++;
                System.out.println("left++ " + left + " " + A[left]);
            }
            while (left <= right && A[right] > pivot){
                right --;
                System.out.println("right-- " + right + " " + A[right]);
            }
            if (left <= right){
                int temp = A[left];
                A[left] = A[right];
                A[right] = temp;
                left ++;
                right --;
            }
            printArray(A);
            System.out.println(left + " " + A[left] + ";" + right + " " + A[right]);
        }
        System.out.println("begin to quicksort "+ start + "->" + right);
        quickSort(A, start, right);
        System.out.println("begin to quicksort " + left + "->" + end );
        quickSort(A, left, end);
    }

    public void sort(int[] nums){
        if (nums == null || nums.length == 0){
            return;
        }

        quickSort(nums, 0, nums.length-1);
    }


    public static void main(String[] args){
        SortIntegers sortTest = new SortIntegers();
        int[] A = {5,90,0,-1,-5,88,90,100,45};
        sortTest.sort(A);
        int[] B = {5,90,0,-1,-5,88,90,100,45};
        int[] temp = new int[B.length];
        sortTest.mergeSort(B, 0, B.length-1, temp);
        printArray(temp);
    }

}


