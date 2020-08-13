package tictactoe;

public class Board {

    public char[][] createBoard() {

        char[][] boardOfChoices = new char[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                boardOfChoices[i][j] = ' ';
            }
        }

        //utworzenie planszy i jej elementów
        char[][] plansza = {
                {'-', '-', '-', '-', '-', '-', '-', '-', '-'},
                {'|', ' ', boardOfChoices[0][0], ' ', boardOfChoices[0][1], ' ', boardOfChoices[0][2], ' ', '|'},
                {'|', ' ', boardOfChoices[1][0], ' ', boardOfChoices[1][1], ' ', boardOfChoices[1][2], ' ', '|'},
                {'|', ' ', boardOfChoices[2][0], ' ', boardOfChoices[2][1], ' ', boardOfChoices[2][2], ' ', '|'},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-'}
        };
        for (int i = 0; i < plansza.length; ++i) {
            System.out.println(plansza[i]);
        }
        return boardOfChoices;
    }

    public char[][] boardAfterInput(char[][] boardOfChoices) {
    char[][] board = new char[3][3];

    for (int i = 0; i < 3; i++) {
        for (int j = 0; j < 3; j++) {
            board[i][j] = boardOfChoices[i][j];
        }
    }

    char[][] plansza2 = {
            {'-', '-', '-', '-', '-', '-', '-', '-', '-'},
            {'|', ' ', board[0][0], ' ', board[0][1], ' ', board[0][2], ' ', '|'},
            {'|', ' ', board[1][0], ' ', board[1][1], ' ', board[1][2], ' ', '|'},
            {'|', ' ', board[2][0], ' ', board[2][1], ' ', board[2][2], ' ', '|'},
            {'-', '-', '-', '-', '-', '-', '-', '-', '-'}
    };

    for (int i = 0; i < plansza2.length; ++i) {
        System.out.println(plansza2[i]);
    }

    return plansza2;
    }
}
