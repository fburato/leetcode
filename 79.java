/*
 Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ["ABCE"],
  ["SFCS"],
  ["ADEE"]
]

word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

public class Solution {
    int[] rowDir = {0,1,0,-1};
    int[] colDir = {1,0,-1,0};
    public boolean exist(char[][] board, String word) {
        // TODO check boundaries
        boolean[][] used = new boolean[board.length][board[0].length];
        char[] chars = word.toCharArray();
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[i].length; ++j) {
                if(chars[0] == board[i][j]) {
                    used[i][j] = true;
                    if(exist(board,used,chars,1,i,j)) {
                        return true;
                    }
                    used[i][j] = false;
                }
            }
        }
        return false;
    }
    
    public boolean exist(char[][] board, boolean[][] used, char[] c, int index, int row, int col) {
        if(index == c.length) {
            return true;
        }
        for(int i = 0; i < 4; ++i) {
            int rNext = row+rowDir[i];
            int cNext = col+colDir[i];
            if(rNext >= 0 && rNext < board.length && cNext >=0 && cNext < board[rNext].length && !used[rNext][cNext] && board[rNext][cNext] == c[index]) {
                used[rNext][cNext] = true;
                if(exist(board,used,c,index+1,rNext,cNext)) {
                    return true;
                }
                used[rNext][cNext] = false;
            }
        }
        return false;
    }
}
