/*
Given two sorted integer arrays A and B, merge B into A as one sorted array.

Note:
You may assume that A has enough space (size that is greater or equal to m + n) to hold additional elements from B. The number of elements initialized in A and B are m and n respectively.
*/
public class Solution {
    public void merge(int A[], int m, int B[], int n) {
        int startA = m-1, startB = n-1;
        for(int i = m+n-1; i>= 0; i--) {
            if(startA < 0 || startB >= 0 && B[startB] >= A[startA]) {
                A[i] = B[startB--];
            } else {
                A[i] = A[startA--];
            }
        }
    }
}
