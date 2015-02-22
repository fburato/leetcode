/*
Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution. 
*/
import java.util.Stack;

public class Solution {
    static class Move {
        public int row;
        public int col;
        public Move(int r, int c) {
            row = r;
            col = c;
        }
    }
    public void solveSudoku(char[][] board) {
        Stack<Move> moves = new Stack<>();
        solveSudoku(board,moves,countFreeCells(board));
    }
    
    public boolean solveSudoku(char[][] board, Stack<Move> moves, int free) {
        int size = moves.size();
        boolean unsolvable = consistency(board,moves,free);
        if(unsolvable) {
            // the current state is inconsistent
            return false;
        }
        if(free - (moves.size() - size) == 0) {
            // no more free cells remaining... the sudoku is solved
            return true;
        }
        // at least a free cell to fill in
        int r = 0, c = 0;
        boolean found = false;
        for(r = 0; !found && r < board.length; r++) {
            for(c = 0; !found && c < board[r].length; c++) {
                found = board[r][c] == '.';
            }
        }
        r--; c--;
        char[] pos = possibilities(board,r,c);
        free = free - (moves.size() - size + 1);
        size = moves.size();
        for(int i = 0; i < pos.length; ++i) {
            board[r][c] = pos[i];
            moves.push(new Move(r,c));
            if(solveSudoku(board,moves,free)) {
                return true;
            }
            backtrack(board,moves, moves.size() - size);
        }
        return false;
    }
    
    public void backtrack(char[][] board, Stack<Move> moves, int num) {
        while(num > 0 && !moves.isEmpty()) {
            Move m = moves.pop();
            board[m.row][m.col] = '.';
            num--;
        }
    }
    
    public boolean consistency(char[][] board, Stack<Move> moves, int free) {
        int lastFree = free;
        int currentFree = lastFree;
        boolean cont = lastFree > 0;
        boolean impossible = false;
        while(cont && !impossible) {
            for(int i = 0; !impossible && i < board.length; ++i) {
                for(int j = 0; !impossible && j < board.length; ++j) {
                    if(board[i][j] == '.') {
                        char[] pos = possibilities(board,i,j);
                        if(pos.length == 0) {
                            impossible = true;
                        } else if(pos.length == 1) {
                            board[i][j] = pos[0];
                            moves.push(new Move(i,j));
                            currentFree--;
                        }
                    }
                }
            }
            if(currentFree < lastFree) {
                lastFree = currentFree;
            } else {
                cont = false;
            }
        }
        return impossible;
    }
    
    public char[] possibilities(char[][] board, int r, int c) {
        int startRow = r / 3 * 3, startColumn = c / 3 *3;
        boolean[] present = new boolean[9];
        int countPossibilities = 9;
        for(int i = 0; i < 9; ++i) {
            if(board[r][i] != '.' && !present[board[r][i] - '1']) {
                present[board[r][i] - '1'] = true;
                countPossibilities--;
            }
            if(board[i][c] != '.' && !present[board[i][c] - '1']) {
                present[board[i][c] - '1'] = true;
                countPossibilities--;
            }
            if(board[startRow + i / 3][startColumn + i % 3] != '.' &&
                !present[board[startRow + i / 3][startColumn + i % 3] - '1']) {
                present[board[startRow + i / 3][startColumn + i % 3] - '1'] = true;    
                countPossibilities--;
            }
        }
        char[] pos = new char[countPossibilities];
        int startPos = 0;
        for(int i = 0; i < present.length; ++i) {
            if(!present[i]) {
                pos[startPos++] = (char) ('1' + i);
            }
        }
        return pos;
    }
    
    public int countFreeCells(char[][] board) {
        int count = 0;
        for(int i = 0; i < board.length; ++i) {
            for(int j = 0; j < board[i].length; ++j) {
                count += board[i][j] == '.' ? 1 : 0;
            }
        }
        return count;
    }
}
