package com.practice.arrays;

import java.util.HashMap;
import java.util.Map;

public class GivenSumSubArrayWithGivenSize {
    public static void main(String args[]){
        int arr1[] = {1, -7, 3, 6, -5, 6};
        GivenSumSubArrayWithGivenSize aa = new GivenSumSubArrayWithGivenSize();
        int result[] = aa.givenSumSubArrayWithGivenSize(arr1,7,3);
        System.out.print(" Given sum in the array is from index " + result[0]+" to "+result[1]);
    }

    private int[] givenSumSubArrayWithGivenSize(int[] arr1, int sum, int k) {
        int[]result = new int[2];
        int currentSum =0;
        for(int i=0;i< k;i++){
            currentSum= currentSum+arr1[i];
        }
        if(currentSum==sum){
            result[0]=0;
            result[1]=k-1;
        }
        for(int i=k;i<arr1.length;i++){
            currentSum = currentSum +arr1[i]- arr1[i-k];
            if(currentSum==sum){
                result[0]=i-k+1;
                result[1]=i;
                return result;
            }
        }
        result[0]=-1;
        result[1]=-1;
       return result;
    }
}
