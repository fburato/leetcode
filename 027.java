/*
Given an array and a value, remove all instances of that value in place and return the new length.

The order of elements can be changed. It doesn't matter what you leave beyond the new length. 
*/
public class Solution {
    public int removeElement(int[] A, int elem) {
        if(A == null || A.length == 0) {
            return 0;
        }
        int toChange = 0;
        while(toChange < A.length && A[toChange] != elem) {
            toChange++;
        }
        int substitute = A.length -1;
        while(substitute > toChange && A[substitute] == elem) {
            substitute--;
        }
        while(toChange < A.length && substitute > toChange) {
            int swap = A[toChange];
            A[toChange] = A[substitute];
            A[substitute] = swap;
            while(toChange < A.length && A[toChange] != elem) {
                toChange++;
            }
            while(substitute > toChange && A[substitute] == elem) {
                substitute--;
            }
        }
        return toChange;
    }
}
