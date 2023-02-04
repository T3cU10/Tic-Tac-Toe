import java.util.Scanner;

public class TicTacToe {
    static Scanner sc = new Scanner(System.in);
    static char[][] board = new char[3][3];
    static char turn = 'X';
    
    static void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
    
    static boolean checkWin(char player) {
        // check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        
        // check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        
        // check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        
        return false;
    }
    
    public static void main(String[] args) {
        // initialize board
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
        
        while (true) {
            System.out.println("It's " + turn + "'s turn. Enter row and column: ");
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;
            if (board[row][col] == ' ') {
                board[row][col] = turn;
                printBoard();
                if (checkWin(turn)) {
                    System.out.println(turn + " wins!");
                    break;
                }
                if (turn == 'X') {
                    turn = 'O';
                } else {
                    turn = 'X';
                }
            } else {
                System.out.println("This cell is already filled. Try again.");
            }
        }
    }
}
