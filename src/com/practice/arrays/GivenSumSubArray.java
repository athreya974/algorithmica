package com.practice.arrays;

import java.util.HashMap;
import java.util.Map;

public class GivenSumSubArray {
    public static void main(String args[]){
        int arr1[] = {1, -7, 3, 6, -5, 6};
        GivenSumSubArray aa = new GivenSumSubArray();
        int result[] = aa.givenSumSubArray(arr1,4);
        System.out.print(" Given sum in the array is from index " + result[0]+" to "+result[1]);
    }

    private int[] givenSumSubArray(int[] arr1, int sum) {
        int[]result = new int[2];
        Map<Integer,Integer>currentSumMap = new HashMap<Integer,Integer>();
        int currentSum =0, start =0,end =0;
        for(int i =0;i<arr1.length;i++){
            currentSum = currentSum+arr1[i];

            if(currentSum == sum){
                result[0]=0;
                result[1]=i;
                return result;
            }
            if(currentSumMap.containsKey(currentSum - sum)){
                start = currentSumMap.get(currentSum - sum)+1;
                end = i;
            }
            currentSumMap.put(currentSum,i);
        }
        if(end==0){
            result[0]=-1;
            result[1]=-1;
            return  result;
        }
        result[0]=start;
        result[1]=end;
        return result;
    }
}
