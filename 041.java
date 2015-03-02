/*
 Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space. 
*/
import java.util.Arrays;
public class Solution {
    public int firstMissingPositive(int[] A) {
        for(int i = 0; i < A.length; ++i) {
            while(1 <= A[i] && A[i] <= A.length && A[i] != i+1 && A[A[i] -1] != A[i]) {
                int val = A[A[i]-1];
                A[A[i]-1] = A[i];
                A[i] = val;
            }
        }
        for(int i = 0; i < A.length; ++i) {
            if(A[i] != i+1) {
                return i+1;
            }
        }
        return A.length+1;
    }
}
