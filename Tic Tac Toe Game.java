//TIC TAC TOE GAME
import java.util.Scanner;

public class TicTacToe {
    private char[] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[9]; 
        currentPlayer = 'X'; 
        initializeBoard();
    }
    private void initializeBoard() {
        for (int i = 0; i < 9; i++) {
            board[i] = '-';
        }
    }
    public void printBoard() {
        System.out.println("Current board:");
        for (int i = 0; i < 9; i++) {
            System.out.print(board[i] + " ");
            if (i % 3 == 2) {
                System.out.println();
            }
        }
    }
    public boolean isBoardFull() {
        for (char c : board) {
            if (c == '-') {
                return false;
            }
        }
        return true;
    }
    public boolean checkForWin() {
        return (checkRowCol(0, 1, 2) || checkRowCol(3, 4, 5) || checkRowCol(6, 7, 8) || 
                checkRowCol(0, 3, 6) || checkRowCol(1, 4, 7) || checkRowCol(2, 5, 8) ||
                checkRowCol(0, 4, 8) || checkRowCol(2, 4, 6)); 
    }
    private boolean checkRowCol(int i, int j, int k) {
        return (board[i] != '-' && board[i] == board[j] && board[i] == board[k]);
    }
    public void changePlayer() {
        currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
    }
    public void makeMove(int position) {
        if (position >= 0 && position < 9 && board[position] == '-') {
            board[position] = currentPlayer;
        } else {
            System.out.println("This move is not valid");
        }
    }
    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to Tic Tac Toe!");

        while (true) {
            game.printBoard();
            System.out.println("Current player: " + game.currentPlayer);
            System.out.print("Enter position (0-8) for your move: ");
            int position = scanner.nextInt();
            game.makeMove(position);

            if (game.checkForWin()) {
                game.printBoard();
                System.out.println("Player " + game.currentPlayer + " wins!");
                break;
            }

            if (game.isBoardFull()) {
                game.printBoard();
                System.out.println("The game is a tie!");
                break;
            }
            game.changePlayer();
        }
        scanner.close();
    }
}
 