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
        Arrays.sort(A);
        int i = 0;
        while(i < A.length && A[i] <= 0){
            i++;
        }
        int next = 1;
        while(true) {
            if(i>= A.length || A[i] != next){
                return next;
            }
            while(i < A.length && A[i] == next) {
                i++;
            }
            next++;
        }
    }
}
