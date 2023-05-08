package logic;

import java.util.*;

public class TicTacToe {

    // Function to print the board
    public static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.println("| " + board[i][0] + " | " + board[i][1] + " | " + board[i][2] + " |");
            System.out.println("-------------");
        }
    }

    // Function to check if a player has won
    public static boolean checkWin(char[][] board, char player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    // Function to play a move
    public static boolean playMove(char[][] board, char player, int row, int col) {
        if (board[row][col] == '-') {
            board[row][col] = player;
            return true;
        } else {
            return false;
        }
    }

    // Function to get a list of possible moves
    public static ArrayList<int[]> getPossibleMoves(char[][] board) {
        ArrayList<int[]> moves = new ArrayList<int[]>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    moves.add(new int[]{i, j});
                }
            }
        }
        return moves;
    }

    // Function to play the game
    public static void playGame() {
        // Initialize the board
        char[][] board = {{'-', '-', '-'}, {'-', '-', '-'}, {'-', '-', '-'}};
        printBoard(board);

        // Randomly choose who goes first
        char[] players = {'X', 'O'};
        Random rand = new Random();
        char current_player = players[rand.nextInt(2)];
        System.out.println("Player " + current_player + " goes first");

        // Loop until someone wins or the board is full
        while (!checkWin(board, 'X') && !checkWin(board, 'O') && Arrays.asList(board).contains('-')) {
            // Get possible moves
            ArrayList<int[]> moves = getPossibleMoves(board);

            // If there are no possible moves, break out of the loop
            if (moves.size() == 0) {
                break;
            }

            // Greedy approach: choose the first available move
            int[] move = moves.get(0);

            // Play the move
            playMove(board, current_player, move[0], move[1]);

            // Print the board
            printBoard(board);

            // Switch to the other player
            current_player = current_player ==players[0] ? players[1] : players[0];
            
        }

        // Check who won the game
        if (checkWin(board, 'X')) {
            System.out.println("Player X wins!");
        } else if (checkWin(board, 'O')) {
            System.out.println("Player O wins!");
        } else {
            System.out.println("Tie game!");
        }
    }

    public static void main(String[] args) {
        playGame();
    }
    
}