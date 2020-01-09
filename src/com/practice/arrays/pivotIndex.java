package com.practice.arrays;

import com.interview.array.ArrayAddition;

public class pivotIndex {
    private int findPivot(int[] arr1) {
        int p[] = new int[arr1.length];
        p[0]=0;
        for(int i=1;i<arr1.length;i++){
            p[i]= p[i-1]+arr1[i-1];
        }
        for(int i=0;i<p.length;i++){
            if(p[i]==p[p.length-1]-p[i]){
                return i;
            }

        }
        return -1;
    }

    public static void main(String args[]){
        int arr1[] = {1, 7, 3, 6, 5, 6};
        pivotIndex aa = new pivotIndex();
        int result = aa.findPivot(arr1);
        System.out.print(" " + result);
    }


}
