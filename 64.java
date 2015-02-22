/*
Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.
*/
public class Solution {
    public int minPathSum(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0].length == 0){
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int prev[] = new int[n];
        prev[0] = grid[0][0];
        for(int i = 1; i < n; i++) {
            prev[i] = prev[i-1]+grid[0][i];
        }
        for(int row = 1; row < m; ++row) {
            int next[] = new int[n];
            next[0] = prev[0] + grid[row][0];
            for(int i = 1; i < n; ++i) {
                next[i] = grid[row][i];
                if(next[i-1] < prev[i]) {
                    next[i] += next[i-1];
                } else {
                    next[i] += prev[i];
                }
            }
            prev = next;
        }
        return prev[n-1];
    }
}
