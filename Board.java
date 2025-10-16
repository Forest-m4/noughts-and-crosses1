public class Board {
    private char[][] board;
    private final int SIZE = 3;

    public Board() {
        board = new char[SIZE][SIZE];
        reset();
    }

    // Заполнить доску пробелами
    public void reset() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = ' ';
            }
        }
    }

    // Поставить символ в клетку (row, col) — индексация 0..2
    // Возвращает true, если ход удачен
    public boolean placeMove(int row, int col, char symbol) {
        if (row < 0 || row >= SIZE || col < 0 || col >= SIZE) return false;
        if (board[row][col] != ' ') return false;
        board[row][col] = symbol;
        return true;
    }
    // Проверить, победил ли указанный символ
    public boolean checkWin(char symbol) {
        // строки
        for (int i = 0; i < SIZE; i++) {
            if (board[i][0] == symbol && board[i][1] == symbol && board[i][2] == symbol) return true;
        }
        // столбцы
        for (int j = 0; j < SIZE; j++) {
            if (board[0][j] == symbol && board[1][j] == symbol && board[2][j] == symbol) return true;
        }
        // диагонали
        if (board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol) return true;
        if (board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol) return true;

        return false;
    }
    // Проверить, заполнена ли доска (ничья)
    public boolean isFull() {
        for (int i = 0; i < SIZE; i++)
            for (int j = 0; j < SIZE; j++)
                if (board[i][j] == ' ') return false;
        return true;
    }

    // Вывести доску в консоль
    public void printBoard() {
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print(" ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(board[i][j]);
                if (j < SIZE - 1) System.out.print(" | ");
            }
            System.out.println();
            if (i < SIZE - 1) System.out.println("---+---+---");
        }
        System.out.println();
    }
}