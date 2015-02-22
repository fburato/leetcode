/*
There are two sorted arrays A and B of size m and n respectively. Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).


*/

public class Solution {
    public double findMedianSortedArrays(int A[], int B[]) {
        int merged[] = new int[A.length+B.length];
        int startA = 0, startB = 0;
        for(int i = 0; i < merged.length; ++i) {
            if(startA >= A.length || startB < B.length && B[startB] <= A[startA]) {
                merged[i] = B[startB++];
            } else {
                merged[i] = A[startA++];
            }
        }
        int med = merged.length / 2;
        if(merged.length % 2 == 0) {
            return (((double) merged[med-1]) + merged[med])/2;
        } else {
            return merged[med];
        }
    }
}
