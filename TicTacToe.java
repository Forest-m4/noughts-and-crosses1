import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        char currentPlayer = 'X';
        boolean playAgain = true;

        System.out.println("Крестики-нолики (3x3). Ввод: строка и столбец от 1 до 3.");

        while (playAgain) {
            board.reset();
            currentPlayer = 'X';
            boolean gameOver = false;

            while (!gameOver) {
                board.printBoard();
                System.out.println("Ход игрока: " + currentPlayer);
                int row = -1, col = -1;

                // читаем ввод — два числа
                while (true) {
                    System.out.print("Введите строку (1-3) и столбец (1-3), через пробел: ");
                    String line = scanner.nextLine().trim();
                    String[] parts = line.split("\\s+");
                    if (parts.length < 2) {
                        System.out.println("Нужно ввести два числа. Попробуй ещё раз.");
                        continue;
                    }
                    try {
                        row = Integer.parseInt(parts[0]) - 1;
                        col = Integer.parseInt(parts[1]) - 1;
                    } catch (NumberFormatException e) {
                        System.out.println("Это не числа. Попробуй ещё раз.");
                        continue;
                    }
                    if (!board.placeMove(row, col, currentPlayer)) {
                        System.out.println("Неверный ход (вне поля или занято). Попробуй снова.");
                        continue;
                    }
                    break;
                }

                // проверяем победу
                if (board.checkWin(currentPlayer)) {
                    board.printBoard();
                    System.out.println("Игрок " + currentPlayer + " победил!");
                    gameOver = true;
                } else if (board.isFull()) {
                    board.printBoard();
                    System.out.println("Ничья!");
                    gameOver = true;
                } else {
                    // смена игрока
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }

            // спросим, играть ли снова
            System.out.print("Хотите сыграть ещё раз? (y/n): ");
            String answer = scanner.nextLine().trim().toLowerCase();
            if (!answer.equals("y") && !answer.equals("yes") && !answer.equals("д") && !answer.equals("да")) {
                playAgain = false;
            }
        }

        System.out.println("Спасибо за игру. Пока!");
        scanner.close();
    }
}