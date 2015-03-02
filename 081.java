/*
Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.
*/
public class Solution {
    
    // A[start] <= target <= A[end]
    public int binarySearch(int A[], int target, int start, int end) {
        int result = -1;
        if(target < A[start] || target > A[end]) {
            return result;
        }
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
    
    public boolean search(int[] A, int target) {
        if(A == null || A.length == 1 && A[0] != target){
            return false;
        }
        if(A.length == 1 && A[0] == target){
            return true;
        }
        // a.length > 1
        if(A[0] < A[A.length-1]) {
            return binarySearch(A,target,0,A.length-1) != -1;
        }
        // A[0] > A[A.length-1]
        return search(A,target,0,A.length-1) != -1;
    }
    
    // PRE = A[start] >= A[end] && start <= end
    public int search(int[] A, int target, int start, int end) {
        while(end > start && A[end] == A[start]) {
            end--;
        }
        while(start < end && A[start] == A[start+1]) {
            start++;
        }
        if(start == end) {
            if(A[start] == target) {
                return start;
            }
            return -1;
        }
        // A[start] > A[end] && start < end
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
