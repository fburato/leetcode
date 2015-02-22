/*
A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

How many possible unique paths are there?
*/
public class Solution {
    public int uniquePaths(int m, int n) {
        if(m <= 0 || n <= 0){
            return 0;
        }
        int prev[] = new int[n];
        for(int i = 0; i < n; i++){
            prev[i] = 1;
        }
        int row = 1;
        while(row < m) {
            int next[] = new int[n];
            next[0] = 1;
            for(int i = 1; i < n; ++i) {
                next[i] = next[i-1]+prev[i];
            }
            prev = next;
            row++;
        }
        return prev[n-1];
    }
}
