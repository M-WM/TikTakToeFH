package org.example;
import java.util.Scanner;

public class TicTacToe {

        private char[][] board;
        private char currentPlayer;

        public TicTacToe() {
            board = new char[3][3];
            currentPlayer = 'X';
            initializeBoard();
        }

        // Initialize the board with empty spaces
        public void initializeBoard() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i][j] = '-';
                }
            }
        }

        // Print the current board
        public void printBoard() {
            System.out.println("Board:");
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
        }

        // Check if the game is won by any player
        public boolean checkWin() {
            // Check rows
            for (int i = 0; i < 3; i++) {
                if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                    return true;
                }
            }

            // Check columns
            for (int i = 0; i < 3; i++) {
                if (board[0][i] == board[1][i] && board[1][i] == board[2][i] && board[0][i] != '-') {
                    return true;
                }
            }

            // Check diagonals
            if (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') {
                return true;
            }
            if (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-') {
                return true;
            }

            return false;
        }

        // Check if the board is full
        public boolean isBoardFull() {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if (board[i][j] == '-') {
                        return false;
                    }
                }
            }
            return true;
        }

        // Make a move at the given position
        public boolean placeMark(int row, int col) {
            if (row >= 0 && col >= 0 && row < 3 && col < 3 && board[row][col] == '-') {
                board[row][col] = currentPlayer;
                return true;
            }
            return false;
        }

        // Switch the player
        public void switchPlayer() {
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }

        // Get the current player
        public char getCurrentPlayer() {
            return currentPlayer;
        }

        // Language identification process
        public static String identifyLanguage(String input) {
            String[] englishKeywords = {"play", "move", "row", "col"};
            String[] spanishKeywords = {"jugar", "mover", "fila", "columna"};

            for (String word : englishKeywords) {
                if (input.toLowerCase().contains(word)) {
                    return "English";
                }
            }

            for (String word : spanishKeywords) {
                if (input.toLowerCase().contains(word)) {
                    return "Spanish";
                }
            }

            return "Unknown";
        }

        //return board
        public char[][] getBoard() {
        return board;
        }

        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            TicTacToe game = new TicTacToe();
            game.printBoard();
            System.out.println("Welcome to TicTacToe!");

            while (true) {
                System.out.println("Current player: " + game.getCurrentPlayer());
                System.out.println("Enter your move (row and column): ");
                int row = scanner.nextInt();
                int col = scanner.nextInt();
                if (game.placeMark(row, col)) {
                    game.printBoard();
                    if (game.checkWin()) {
                        System.out.println("Player " + game.getCurrentPlayer() + " wins!");
                        break;
                    }
                    if (game.isBoardFull()) {
                        System.out.println("The game is a tie!");
                        break;
                    }
                    game.switchPlayer();
                } else {
                    System.out.println("This move is not valid");
                }
            }
            scanner.close();
        }
    }
