package com.practice.arrays;

public class ArrayAddition {
    public static void main(String args[]){

        int arr1[] = {9,9,9,9,9,9,9};
        int arr2[] = {1,6,8,2,6,7};
        ArrayAddition aa = new ArrayAddition();
        int result[] = aa.add(arr1, arr2);
        for(int i=0; i < result.length; i++){
            System.out.print(" " + result[i]);
        }
    }

    private int[] add(int[] arr1, int[] arr2) {
        int l = Math.max(arr1.length-1,arr2.length-1);
        int []result = new int[l+1];
        int i = arr1.length-1,j=arr2.length-1,c=0,sum;
        while(i>=0 && j>=0){
            sum = arr1[i]+arr2[j]+c;
            c = sum/10;
            result[l]=sum%10;
            l--;
            i--;j--;
        }
        while(i>=0){
            sum = arr1[i]+c;
            c = sum/10;
            result[l]=sum%10;
            l--;
            i--;
        }
        while(j>=0){
            sum = arr1[j]+c;
            c = sum/10;
            result[l]=sum%10;
            l--;
            j--;
        }
        if(c != 0){
            int[] newResult = new int[result.length+1];
            for(int t= newResult.length-1; t> 0; t--){
                newResult[t] = result[t-1];
            }
            newResult[0] = c;
            return newResult;
        }
        return  result;
    }
}
