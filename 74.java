/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]

Given target = 3, return true.
*/
public class Solution {
    public int getRow(int[][] matrix, int target) {
        int start = 0, end = matrix.length-1;
        if(target < matrix[start][0] || target > matrix[end][matrix[end].length -1]) {
            return -1;
        }
        // target is certainly in between the element of the matrix
        if(matrix[end][0] <= target) {
            return end;
        }
        // matrix[start][0] <= target < matrix[end][0]
        while(start < end-1) {
            int med = (start+end) / 2;
            if(matrix[med][0] <= target) {
                start = med;
            } else {
                end = med;
            }
        }
        return start;
    }
    
    public boolean binarySearch(int[] v, int target) {
        int start = 0, end = v.length-1;
        if(end >= 0 && v[end] == target) {
            return true;
        }
        // v[start] <= target < v[end]
        while(start < end -1) {
            int med = (start+end) / 2;
            if(v[med] == target) {
                return true;
            } else if(v[med] < target) {
                start = med;
            } else {
                end = med;
            }
        }
        return v[start] == target;
    }
    
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0) {
            return false;
        }
        int row = getRow(matrix,target);
        if(row >= 0) {
            return binarySearch(matrix[row],target);
        } else {
            return false;
        }
    }
}
