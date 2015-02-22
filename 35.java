/*
Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0 
*/

public class Solution {
    public int searchInsert(int[] A, int target) {
        if(A == null || A.length == 0) {
            return 0;
        }
        if(A.length == 1) {
            if(target <= A[0] ){
                return 0;
            } else {
                return 1;
            }
        }
        // A.length >= 2
        int start =0, end = A.length -1;
        while(start < end -1) {
            int med = (start+end) / 2;
            if(A[med] == target) {
                return med;
            } else if(A[med] < target) {
                start = med;
            } else {
                end = med;
            }
        }
        if(target <= A[start]) {
            return start;
        } else if(target <= A[end]){
            return end;
        } else {
            return end+1;
        }
    }
}
