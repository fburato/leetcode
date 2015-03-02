/*
 Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.

For example,
Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6. 
*/
public class Solution {
    public int[] leftMaximals(int[] A) {
        int maximal = -1;
        int res[] = new int[A.length];
        for(int i = 0; i < A.length; ++i) {
            if(maximal < A[i]) {
                maximal = A[i];
            }
            res[i] = maximal;
        }
        return res;
    }
    
    public int[] rightMaximals(int[] A) {
        int maximal = -1;
        int res[] = new int[A.length];
        for(int i = A.length -1; i >= 0; --i) {
            if(maximal < A[i]) {
                maximal = A[i];
            }
            res[i] = maximal;
        }
        return res;
    }
    public int trap(int[] A) {
        int water = 0;
        int leftMaximals[] = leftMaximals(A);
        int rightMaximals[] = rightMaximals(A);
        for(int i = 1; i < A.length-1;++i) {
            water = water + Math.min(leftMaximals[i],rightMaximals[i]) - A[i];
        }
        return water;
    } 
}
