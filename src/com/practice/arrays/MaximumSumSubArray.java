package com.practice.arrays;

public class MaximumSumSubArray {
    public static void main(String args[]){
        int arr1[] = {1, -7, 3, 6, -5, 6};
        MaximumSumSubArray aa = new MaximumSumSubArray();
        int result[] = aa.maxSumSubArray(arr1);
        System.out.print(" Maximum sum in the given array is from index " + result[0]+" to "+result[1]+" and the sum is "+result[2]);
    }

    private int[] maxSumSubArray(int[] arr1) {
        int max_so_far=0,curr_max =0,start =0,s=0,end =0;
        int[]result = new int[3];
        for(int i=0; i<arr1.length;i++){
            curr_max = curr_max+arr1[i];
            if(curr_max<0){
                curr_max = 0;
                s=i+1;
            }
            if(max_so_far<curr_max){
                max_so_far = curr_max;
                start=s;
                end =i;
            }
        }
        result[0]=start;result[1]=end;result[2]=max_so_far;
        return result;
    }
}
