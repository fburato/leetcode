/*
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false. 
*/
public class Solution {
    public boolean canJump2(int[] A) {
        if(A == null || A.length == 0) {
            return false;
        }
        return canJump(A,0);
    }
    
    public boolean canJump(int[] A, int pos) {
        if(pos == A.length-1) {
            return true;
        }
        // pos < A.length -1
        if(A[pos] == 0){
            return false;
        }
        // A[pos] > 0 -> can make some jumps
        boolean finished = false;
        for(int i = Math.min(A[pos],A.length-pos-1); !finished && i > 0; --i) {
            finished = canJump(A,i+pos);
        }
        return finished;
    }
    
    public boolean canJump(int A[]) {
        if(A == null || A.length == 0 || A.length > 1 && A[0] == 0) {
            return false;
        }
        int maxJump = A[0];
        int i;
        for(i = 1; maxJump > 0 && i < A.length; ++i) {
            maxJump--;
            if(A[i] > maxJump) {
                maxJump = A[i];
            }
        }
        return i == A.length; 
    }
}
