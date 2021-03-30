package com.company;

import javax.swing.*;

public class Engine {

    private char currentPlayer = 'X';
    private boolean winner = false;
    private boolean draw = false;
    private Board b = null;

    Engine(Board board) {
        this.b = board;
    }

    char getCurrentPlayer() {
        return this.currentPlayer;
    }

    void changeCurrentPlayer(char player) {
        currentPlayer = player;
    }

    boolean checkWins(JButton[] buttons) {

        int i = 0;
        //checking rows for the win
        for (int j = 0; j < 3; j++) {
            if (buttons[i].getText().equals(buttons[i + 1].getText()) &&
                    buttons[i + 1].getText().equals(buttons[i + 2].getText()) &&
                    !buttons[i].getText().equals(" ")) {
                return winner = true;
            }
            i += 3;
        }

        //checking columns for the win
        i = 0;
        for (int j = 0; j < 3; j++) {
            if (buttons[i].getText().equals(buttons[i + 3].getText()) &&
                    buttons[i + 3].getText().equals(buttons[i + 6].getText()) &&
                    !buttons[i].getText().equals(" ")) {
                return winner = true;
            }
            i++;
        }

        //checking diagonals for the win
        if (buttons[0].getText().equals(buttons[4].getText()) &&
                buttons[4].getText().equals(buttons[8].getText())
                && !buttons[8].getText().equals(" ")) {
            return winner = true;
        } else if (buttons[2].getText().equals(buttons[4].getText()) && buttons[4].getText().equals(buttons[6].getText())
                && !buttons[6].getText().equals(" ")) {
            return winner = true;
        }

        return winner;
    }

    boolean checkDraw(JButton[] buttons, boolean iswinner) {

        boolean flag_draw = false;
        int counter = 0;

        if (!iswinner) {
            for (int j = 0; j < buttons.length; j++) {
                if (!buttons[j].getText().equals(" ")) {
                    counter++;
                    flag_draw = true;
                } else {
                    return draw;
                }
            }
        }

        if (flag_draw && counter == 9) return draw = true;
        return draw;
    }

    void displayResult() {

        boolean iswinner = checkWins(b.buttons);
        boolean isdraw = checkDraw(b.buttons, iswinner);

        if (iswinner) {
            if (currentPlayer == 'X') {
                changeCurrentPlayer('O');
            } else {
                changeCurrentPlayer('X');
            }
            JOptionPane pane = new JOptionPane();

            int dialogResult = JOptionPane.showConfirmDialog(pane,
                    "Game Over! " + currentPlayer + " wins. Do you want to play again?", "VICTORY",
                    JOptionPane.YES_NO_OPTION);

            if (dialogResult == JOptionPane.YES_OPTION) {
                winner = false;
                b.resetBoard();
            } else System.exit(0);
        }

        if (isdraw) {
            JOptionPane pane = new JOptionPane();

            int dialogResult = JOptionPane.showConfirmDialog(pane,
                    "Game Over! It is a draw. Do you want to play again?", "DRAW",
                    JOptionPane.YES_NO_OPTION);

            if (dialogResult == JOptionPane.YES_OPTION) {
                draw = false;
                b.resetBoard();
            } else System.exit(0);
        }
    }
}
