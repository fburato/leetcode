/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/
public class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if(m == 0 || n == 0) {
            return 0;
        }
        // m > 0 && n > 0
        int row[] = new int[n];
        row[n-1] = grid[m-1][n-1];
        for(int i = n-2; i >= 0; i--) {
            row[i] = row[i+1] + grid[m-1][i];
        }
        for(int i = m-2; i >= 0; i--) {
            row[n-1] = row[n-1]+ grid[i][n-1];
            for(int j = n-2; j >= 0; j--) {
                if(row[j] < row[j+1]) {
                    row[j] = grid[i][j] + row[j];
                } else {
                    row[j] = grid[i][j] + row[j+1];
                }
            }
        }
        return row[0];
    }
}
