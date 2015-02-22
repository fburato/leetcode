/*
 Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

For example,
Given input array A = [1,1,2],

Your function should return length = 2, and A is now [1,2]. 
*/
public class Solution {
    public int removeDuplicates(int[] A) {
        if(A.length <= 1) {
            return A.length;
        }
        //A.length > 2
        int current = 1, next = 1;
        while(next < A.length &&  A[next]==A[next-1]) {
            next++;
        }
        while(next < A.length) {
            A[current] = A[next];
            while(next+1 < A.length && A[next] == A[next+1]) {
                next++;
            }
            next++;
            current++;
        }
        return current;
    }
}
