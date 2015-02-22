/*
Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in place. 
*/
public class Solution {
    public void setZeroes(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return ;
        }
        // matrix != null && matrix.length >= 1
        final int m = matrix.length;
        final int n = matrix[0].length;
        boolean rows[] = new boolean[m];
        boolean cols[] = new boolean[n];
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                if(matrix[i][j] == 0) {
                    rows[i] = true;
                    cols[j] = true;
                }
            }
        }
        for(int i = 0; i < m; ++i){
            if(rows[i]) {
                for(int j = 0; j < n ;++j) {
                    matrix[i][j] = 0;
                }
            }
        }
        for(int j = 0; j < n; ++j) {
            if(cols[j]) {
                for(int i = 0; i < m; ++i) {
                    matrix[i][j] = 0;
                }
            }
        }
    }
}
