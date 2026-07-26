package RecursionBackTracking;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    private static boolean isValid(char[][] board, int row, int col) {
        //Need to check possible attacks from upward directions only since we are placing queens from top downward side attacks won't be possible

        //Check for possible upward side attack
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') return false;
        }

        //Check left diagonal upward
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        //Check right diagonal upward
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;

    }

    private static void dfs(char[][] board, int row, List<String> arrangement, List<List<String>> result) {
        if (row == board.length) {
            result.add(new ArrayList<>(arrangement));
            return;
        }
        /*
            place one queen at every row and check before placing
            in every direction where there is risk if being attacks
            i.e. up, diagonally because we are placing queens from
            top row to bottom row, so we need to check if we put a queen
            vertically up in some row or diagonally upwards in some row
        */
        for (int i = 0; i < board.length; i++) {
            if (isValid(board, row, i)) {
                board[row][i] = 'Q';
                arrangement.add(new String(board[row]));
                dfs(board, row + 1, arrangement, result);
                board[row][i] = '.';
                arrangement.remove(arrangement.size() - 1);
            }
        }

    }

    private static List<List<String>> solveNQueens(int boardSize) {
        char[][] board = new char[boardSize][boardSize];
        List<List<String>> result = new ArrayList<>();
        List<String> arrangement = new ArrayList<>();
        for (int i = 0; i < boardSize; i++) {
            for (int j = 0; j < boardSize; j++) {
                board[i][j] = '.';
            }
        }
        dfs(board, 0, arrangement, result);
        return result;
    }

    public static void main(String[] args) {
        int boardSize = 4;
        List<List<String>> answer = solveNQueens(boardSize);
        for (List<String> arrangement : answer) {
            System.out.println(arrangement);
        }
    }
}
