/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/
public class Solution {
    
    public int binarySearch(int A[], int target, int start, int end) {
        int result = -1;
        while(result == -1 && start <= end) {
            int med = (start+end) / 2;
            if(A[med] == target) {
                result = med;
            } else if(A[med] < target) {
                start = med+1;
            } else {
                end = med-1;
            }
        }
        return result;
    }
    
    public int search(int[] A, int target) {
        if(A == null || A.length == 1 && A[0] != target){
            return -1;
        }
        if(A.length == 1 && A[0] == target){
            return 0;
        }
        // a.length > 1
        return search(A,target,0,A.length-1);
    }
    
    // PRE = A[start] > A[end] && start < end
    public int search(int[] A, int target, int start, int end) {
        int med = (start+end) / 2;
        if(med == start) {
            if(A[med] == target) {
                return med;
            } else if(A[end] == target) {
                return end;
            }
            else return -1;
        }
        //A.length >= 3
        if(A[start] > A[med] && A[med] < A[end] && A[start] <= A[med-1] && A[med+1] <= A[end]) {
            // med is the minimal
            if(target <= A[end]) {
                return binarySearch(A,target,med,end);
            } else {
                return binarySearch(A,target,start,med-1);
            }
        }
        if(A[start] < A[med] && A[med] > A[end] && A[start] <= A[med-1])  {
            // the pivot is at the right of med
            if(target >= A[start] && target <= A[med]) {
                return binarySearch(A,target,start,med);
            } else {
                return search(A,target,med,end);
            }
        }
        //the pivot is at the left of med
        if(target >= A[med] && target <= A[end]) {
            return binarySearch(A,target,med,end);
        } else {
            return search(A,target,start,med);   
        }
    }
}
