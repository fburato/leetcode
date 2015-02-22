/*
Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
*/
public class Solution {
    public boolean validateArea(char[][] board, int tLeftX, int tLeftY, int bRightX, int bRightY) {
        boolean valid[] = new boolean[9];
        for(int i = tLeftX; i <= bRightX; ++i) {
            for(int j = tLeftY; j <= bRightY; ++j) {
                if(board[i][j] == '.') {
                    // do nothing
                } else if(board[i][j] < '1' || board[i][j] > '9' || valid[board[i][j]-'1']){
                    return false;
                } else {
                    valid[board[i][j]-'1'] = true;
                }
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        // check boundaries
        boolean rightDimensions = board.length == 9;
        for(int i = 0; rightDimensions && i < board.length; ++i) {
            rightDimensions = board[i].length == 9;
        }
        if(!rightDimensions) {
            return false;
        }
        // board is 9x9
        // check rows and columns
        for(int i=0; i < 9; ++i) {
            if(!validateArea(board,i,0,i,8) || !validateArea(board,0,i,8,i) || !validateArea(board,(i/3)*3,(i%3)*3,(i/3)*3+2,(i%3)*3+2)) {
                return false;
            }
        }
        return true;
    }
}
