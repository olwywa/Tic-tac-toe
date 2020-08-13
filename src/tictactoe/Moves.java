package tictactoe;

public class Moves {

    public char[][] moveX(char[][] boardOfChoices, int num) {

        GettingClass get = new GettingClass();
        Coordinates coordinates = new Coordinates();
        Board board = new Board();

        int[] coords = get.getInt();
        int coo1 = coords[0];
        int coo2 = coords[1];

        char[][] boardOfChoices2 = coordinates.errors(coo1, coo2, boardOfChoices, num);
        board.boardAfterInput(boardOfChoices2);

        return boardOfChoices2;
    }

    public char[][] moveO(char[][] boardOfChoices, int num) {

        GettingClass get = new GettingClass();
        Coordinates coordinates = new Coordinates();
        Board board = new Board();

        int[] coords = get.getInt();
        int coo1 = coords[0];
        int coo2 = coords[1];

        char[][] boardOfChoices2 = coordinates.errors(coo1, coo2, boardOfChoices, num);
        board.boardAfterInput(boardOfChoices2);

        return boardOfChoices2;
    }
}
