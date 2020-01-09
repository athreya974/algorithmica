package com.practice.arrays.ArrayRotation;
/*Given Array divide into A and B. A with d elements and B with remaining n-d elements
* Rotate Ar
* Rotate Br
* Add ArBr
* Roatate (ArBr)r to get BA
* which is B elements+A elements of size d
* */
public class ReversalAlgorithmArrayRotation {
    public static void main(String args[]){
        int arr1[] = {1, 2, 3, 4, 5, 6};
        ReversalAlgorithmArrayRotation aa = new ReversalAlgorithmArrayRotation();
        int result[] = aa.ReversalAlgorithmArrayRotation(arr1,3);
        for(int j=0; j<result.length;j++){
            System.out.println(result[j]);
        }
    }

    private int[] ReversalAlgorithmArrayRotation(int[] arr1, int d) {
        int n = arr1.length;
        revereseArray(arr1, 0, d - 1);
        revereseArray(arr1, d, n - 1);
        revereseArray(arr1, 0, n - 1);
        return arr1;
    }

    private void revereseArray(int[] arr1, int start, int end) {
        int temp=0;
        while (start < end) {
            temp = arr1[start];
            arr1[start] = arr1[end];
            arr1[end] = temp;
            start++;
            end--;
        }
    }

}
