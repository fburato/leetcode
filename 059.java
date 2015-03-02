/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,
You should return the following matrix:

[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

*/
public class Solution {
    public int[][] generateMatrix(int n) {
        if(n <=0){
            return new int[0][0];
        }
        // n > 0
        int matrix[][] = new int[n][n];
        int low = 0, up = n-1;
        int rowInc[] = {0,1,0,-1};
        int colInc[] = {1,0,-1,0};
        int num = 1;
        while(low <= up) {
            int limit = 0;
            if(low==up) {
                limit = 1;
            } else {
                limit = (up-low+1)*4 - 4;
            }
            int direction = 0;
            int i = low, j = low;
            for(int k = 0; k < limit; ++k) {
                matrix[i][j] = num++;
                i = i + rowInc[direction];
                j = j + colInc[direction];
                if(direction == 0 && j == up ||
                        direction == 1 && i == up ||
                        direction == 2 && j == low) {
                    direction++;            
                }
            }
            low++;
            up--;
        }
        return matrix;
    }
}
