/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

You should return [1,2,3,6,9,8,7,4,5]. 
*/
import java.util.LinkedList;
public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> l = new LinkedList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return l;
        }
        int rowInc[] = {0,1,0,-1};
        int colInc[] = {1,0,-1,0};
        int rowLower = 0, rowUpper = matrix.length-1,
                colLower = 0, colUpper = matrix[0].length-1;
        while(rowLower<=rowUpper && colLower <= colUpper) {
            int i = rowLower, j = colLower;
            int limit = 0;
            if(rowLower == rowUpper) {
                limit = colUpper - colLower +1;
            } else if(colLower == colUpper) {
                limit = rowUpper - rowLower +1;
            } else {
                limit = 2*(colUpper - colLower + rowUpper - rowLower);
            }
            
            int direction = colLower == colUpper ? 1 : 0; // 0 = RIGHT, 1 = DOWN, 2 = LEFT, 3 = UP
            for(int counter = 0; counter < limit; ++counter) {
                l.add(matrix[i][j]);
                i=i+rowInc[direction];
                j=j+colInc[direction];
                if(direction == 0 && j == colUpper ||
                    direction == 1 && i == rowUpper ||
                    direction == 2 && j == colLower) {
                    direction++;
                } 
            }
            rowLower++;
            rowUpper--;
            colLower++;
            colUpper--;
        }
        return l;
    }
}
