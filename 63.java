/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,

There is one obstacle in the middle of a 3x3 grid as illustrated below.
*/
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid == null || obstacleGrid.length == 0 || obstacleGrid[0].length == 0) {
            return 0;
        }
        // m,n > 0
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int prev[] = new int[n];
        boolean obstacle = false;
        for(int i = 0; i < n; ++i) {
            if(obstacle) {
                prev[i] = 0;
            } else if(obstacleGrid[0][i] == 1) {
                prev[i] = 0;
                obstacle = true;
            }  else {
                prev[i] = 1;
            }
        }
        int row = 1;
        while(row < m) {
            int next[] = new int[n];
            if(obstacleGrid[row][0] == 1 || prev[0] == 0) {
                next[0] = 0;
            } else {
                next[0] = 1;
            }
            for(int i = 1; i < n; ++i) {
                if(obstacleGrid[row][i] == 1) {
                    next[i] = 0;
                } else {
                    next[i] = next[i-1] + prev[i];
                }
            }
            prev = next;
            row++;
        }
        return prev[n-1];
    }
}
