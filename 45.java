/*
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.) 
*/
public class Solution {
    public int jump(int[] A) {
        int[] minimalJumps = new int[A.length];
        minimalJumps[A.length-1] = 0;
        for(int i = A.length - 2; i >= 0; --i) {
            if(A[i] == 0) {
                minimalJumps[i] = Integer.MAX_VALUE;
            } else {
                int maximalJump = i+A[i];
                if(maximalJump < A.length -1){
                    int minimal = A.length;
                    for(int j = i+1; j <= maximalJump ; ++j) {
                        if(minimalJumps[j] < minimal) {
                            minimal = minimalJumps[j];
                        }
                    }
                    minimalJumps[i] = 1+minimal;
                } else {
                    minimalJumps[i] = 1;
                }
            }
        }
        return minimalJumps[0];
    }
}
