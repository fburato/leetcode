/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/
public class Solution {
    public void rotate(int[][] matrix) {
        for(int i = 0; i < matrix.length - 1 -i ; ++i) {
            for(int j = i; j <= matrix.length -2 -i; ++j) {
                int last = matrix[matrix.length - 1 -j][i];
                matrix[matrix.length - 1 -j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 -j];
                matrix[matrix.length - 1 - i][matrix.length - 1 -j] = matrix[j][matrix.length - 1 - i];
                matrix[j][matrix.length - 1 - i] = matrix[i][j];
                matrix[i][j] = last;
            }
        }
    }
}
