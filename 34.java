/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4]. 
*/
public class Solution {
    public int binarySearchLeftMost(int A[], int target) {
        if(A[0] == target) {
            return 0;
        } else if(A[0] > target) {
            return -1;
        }
        // A[start] < target <= A[end]
        int start = 0, end = A.length -1;
        while(start < end) {
            int med = (start + end) / 2;
            if(target <= A[med]) {
                end = med;
            } else {
                start = med;
            }
            if(end-start == 1) {
                start = end;
            }
        }
        if(A[end] == target) {
            return end;
        } else {
            return -1;
        }
    }
    
    // A[start] == target
    public int binarySearchRightMost(int A[], int target, int start) {
        int end = A.length-1;
        if(A[end] == target) {
            return end;
        } 
        // A[start] == target < A[end]
        while(start < end) {
            int med = (start+end) / 2;
            if(target == A[med]) {
                start = med;
            } else {
                end = med;
            }
            if(end-start == 1) {
                end = med;
            }
        }
        return start;
    }
    
    public int[] searchRange(int[] A, int target) {
        int index = binarySearchLeftMost(A,target);
        if(index == -1) {
            return new int[] {-1,-1};
        }
        int second = binarySearchRightMost(A,target,index);
        return new int[] {index,second};
    }
}
