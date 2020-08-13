package tictactoe;

public class Main {

    public static void main(String[] args) {

        Board board = new Board();
	    char[][] boardOfChoices = board.createBoard();
        char[][] boardOfChoices2 = boardOfChoices;

        Conditions warunki = new Conditions();

        boolean flag_winX = warunki.sprawdzXwin(boardOfChoices2);
        boolean flag_winO = warunki.sprawdzOwin(boardOfChoices2);
        boolean flag_remis = warunki.remis(boardOfChoices2, flag_winX, flag_winO);
        boolean flag_not = warunki.notFinished(boardOfChoices2, flag_winX, flag_winO);
        boolean flag_impo = warunki.impossible(boardOfChoices2, flag_winX, flag_winO);

        int num = 0;

        boolean going = true;

        Moves moves = new Moves();

        while (going) {
            System.out.println("Enter the coordinates: ");
            if (num % 2 == 0) {
                boardOfChoices2 = moves.moveX(boardOfChoices, num);
                num++;
            } else if (num % 2 != 0) {
                boardOfChoices2 = moves.moveO(boardOfChoices, num);
                num++;
            }
            flag_winX = warunki.sprawdzXwin(boardOfChoices2);
            flag_winO = warunki.sprawdzOwin(boardOfChoices2);
            flag_remis = warunki.remis(boardOfChoices2, flag_winX, flag_winO);

            if (flag_winX) {
                going = false;
                break;
            } else if (flag_winO) {
                going = false;
                break;
            } else if (flag_remis) {
                going = false;
                break;
            }

            if (flag_not || flag_impo) {
                going = false;
                break;
            }
        }

        String winner = warunki.statements(flag_winX, flag_winO, flag_remis, flag_not, flag_impo);
    }
}
