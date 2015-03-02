/*
Follow up for "Unique Paths":

Now consider if some obstacles are added to the grids. How many unique paths would there be?

An obstacle and empty space is marked as 1 and 0 respectively in the grid.

For example,

There is one obstacle in the middle of a 3x3 grid as illustrated below.
*/
public class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = obstacleGrid[0].length;
        if(rows== 0 || cols == 0) {
            return 0;
        }
        int prev[] = new int[cols];
        prev[cols-1] = obstacleGrid[rows-1][cols-1] == 1 ? 0 : 1;
        for(int i = cols-2; i >= 0; i--) {
            if(obstacleGrid[rows-1][i] == 1) {
                prev[i] = 0;
            } else {
                prev[i] = prev[i+1];
            }
        }
        for(int i = rows-2; i >= 0; --i) {
            if(obstacleGrid[i][cols-1] == 1) {
                prev[cols-1] = 0;
            }
            for(int j = cols-2; j >= 0; --j) {
                if(obstacleGrid[i][j] == 1) {
                    prev[j] = 0;
                } else {
                    prev[j] = prev[j]+ prev[j+1];
                }
            }
        }
        return prev[0];
    }
}
