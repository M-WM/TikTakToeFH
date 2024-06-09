package org.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class TicTacToeTest {

    @Test
    public void testInitializeBoard() {
        TicTacToe game = new TicTacToe();
        char[][] board = game.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertEquals('-', board[i][j]);
            }
        }
    }

    @Test
    public void testPlaceMark() {
        TicTacToe game = new TicTacToe();
        assertTrue(game.placeMark(0, 0));
        assertFalse(game.placeMark(0, 0)); // spot already taken
        assertFalse(game.placeMark(3, 3)); // invalid position
    }

    @Test
    public void testSwitchPlayer() {
        TicTacToe game = new TicTacToe();
        assertEquals('X', game.getCurrentPlayer());
        game.switchPlayer();
        assertEquals('O', game.getCurrentPlayer());
        game.switchPlayer();
        assertEquals('X', game.getCurrentPlayer());
    }

    @Test
    public void testCheckWin() {
        TicTacToe game = new TicTacToe();
        game.placeMark(0, 0);
        game.placeMark(0, 1);
        game.placeMark(0, 2);
        assertTrue(game.checkWin());

        game = new TicTacToe();
        game.placeMark(0, 0);
        game.placeMark(1, 1);
        game.placeMark(2, 2);
        assertTrue(game.checkWin());

        game = new TicTacToe();
        game.placeMark(0, 0);
        game.placeMark(1, 0);
        game.placeMark(2, 0);
        assertTrue(game.checkWin());
    }

    @Test
    public void testIdentifyLanguage() {
        assertEquals("English", TicTacToe.identifyLanguage("play the game"));
        assertEquals("Spanish", TicTacToe.identifyLanguage("jugar el juego"));
        assertEquals("Unknown", TicTacToe.identifyLanguage("this is a test"));
    }

    // Additional test to ensure board is full
    @Test
    public void testIsBoardFull() {
        TicTacToe game = new TicTacToe();
        char[][] board = game.getBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = 'X';
            }
        }
        assertTrue(game.isBoardFull());
    }
}
