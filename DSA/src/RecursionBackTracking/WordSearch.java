package RecursionBackTracking;

public class WordSearch {
    private static boolean find(char[][] board, int currentRow, int currentCol, String word, int index, int totalRows, int totalCols) {
        if (index == word.length()) return true;
        if (currentRow < 0 || currentCol < 0 || currentRow >= totalRows || currentCol >= totalCols || board[currentRow][currentCol] == '#' || board[currentRow][currentCol] != word.charAt(index)) {
            return false;
        }
        char temp = board[currentRow][currentCol];
        board[currentRow][currentCol] = '#';
        if (find(board, currentRow - 1, currentCol, word, index + 1, totalRows, totalCols) ||
                find(board, currentRow + 1, currentCol, word, index + 1, totalRows, totalCols) ||
                find(board, currentRow, currentCol - 1, word, index + 1, totalRows, totalCols) ||
                find(board, currentRow, currentCol + 1, word, index + 1, totalRows, totalCols)) return true;
        board[currentRow][currentCol] = temp;
        return false;
    }

    private static boolean exist(char[][] board, String word) {
        int totalRows = board.length;
        int totalCols = board[0].length;
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalCols; j++) {
                if (board[i][j] == word.charAt(0) && find(board, i, j, word, 0, totalRows, totalCols)) return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "SEE";
        System.out.println(exist(board, word));

    }
}
