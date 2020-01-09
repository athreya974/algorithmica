package com.practice.arrays.ArrayRotation;

import com.practice.arrays.MaximumSumSubArray;

/*Simple method to rotate an array by d using temp array of size d*/
public class RotateArray {
    public static void main(String args[]){
        int arr1[] = {1, 2, 3, 4, 5, 6};
        RotateArray aa = new RotateArray();
        int result[] = aa.RotateArray(arr1,3);
        for(int j=0; j<result.length;j++){
            System.out.println(result[j]);
        }
    }

    private int[] RotateArray(int[] arr1, int d) {
        int temp[] =  new int[d];
        for(int i=0;i<arr1.length;i++){
            if(i<d) {
                temp[i] = arr1[i];
            }
            if(i+d<arr1.length) {
                arr1[i] = arr1[i + d];
            }
        }
        for(int i=0, j=arr1.length-d;j<arr1.length;j++,i++){
            arr1[j]= temp[i];
        }
        return arr1;
    }
}
