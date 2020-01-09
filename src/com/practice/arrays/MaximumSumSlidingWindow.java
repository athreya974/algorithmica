package com.practice.arrays;
/*check the max sum for first k elements from then on add one by one and remove one by one and track for max_so_far*/
public class MaximumSumSlidingWindow {
    public static void main(String args[]){
        int arr1[] = {1, -7, 3, 6, -5, 6};
        MaximumSumSlidingWindow aa = new MaximumSumSlidingWindow();
        int result= aa.maximumSumSlidingWindow(arr1,3);
        System.out.print(" Maximum sum in sliding window is  " +result);
    }

    private int maximumSumSlidingWindow(int[] arr1, int k) {
        int currentSum =0,max_so_far=0;
        for(int i=0;i< k;i++){
            currentSum= currentSum+arr1[i];
        }
        if(currentSum>max_so_far){
            max_so_far=currentSum;
        }
        for(int i=k;i<arr1.length;i++){
            currentSum = currentSum +arr1[i]- arr1[i-k];
            if(currentSum>max_so_far){
                max_so_far=currentSum;
            }
        }
        return  max_so_far;
    }
}
