package tictactoe;

public class Conditions {

    public static boolean sprawdzXwin(char[][] choices) {
        boolean Xwins = false;
        int countX = 0;

        // sprawdz wygrane dla X poziomo
        for (int z = 0; z < choices.length; z++) {
            countX = 0;
            for (int y = 0; y < choices.length; y++) {
                if (choices[z][y] == 'X') {
                    countX++;
                }
            }
            if (countX == 3) {
                Xwins = true;
                break;
            }
        }

        // sprawdz wygrane dla X pionowo
        for (int z = 0; z < choices.length; z++) {
            countX = 0;
            for (int y = 0; y < choices.length; y++) {
                if (choices[y][z] == 'X') {
                    countX++;
                }
            }
            if (countX == 3) {
                Xwins = true;
                break;
            }
        }

        countX = 0;
        int licznikDiag = 0;

        // sprawdz wygrane dla X diagonalna 1
        for (int z = 0; z < choices.length; z++) {
            if (choices[z][licznikDiag] == 'X') {
                countX++;
            }
            if (countX == 3) {
                Xwins = true;
                break;
            }
            ++licznikDiag;
        }

        countX = 0;
        licznikDiag = 2;
        // sprawdz wygrane dla X diagonalna 2
        for (int z = 0; z < choices.length; z++) {
            if (choices[z][licznikDiag] == 'X') {
                countX++;
            }
            if (countX == 3) {
                Xwins = true;
                break;
            }
            --licznikDiag;
        }

        if (Xwins == true) {
            return Xwins;
        } else {
            Xwins = false;
            return Xwins;
        }
    }

    public static boolean sprawdzOwin(char[][] choices) {
        boolean Owins = false;
        int countO = 0;

        // sprawdz wygrane dla O poziomo
        for (int z = 0; z < choices.length; z++) {
            countO = 0;
            for (int y = 0; y < choices.length; y++) {
                if (choices[z][y] == 'O') {
                    countO++;
                }
            }
            if (countO == 3) {
                Owins = true;
                break;
            }
        }

        // sprawdz wygrane dla X pionowo
        for (int z = 0; z < choices.length; z++) {
            countO = 0;
            for (int y = 0; y < choices.length; y++) {
                if (choices[y][z] == 'O') {
                    countO++;
                }
            }
            if (countO == 3) {
                Owins = true;
                break;
            }
        }

        countO = 0;
        int licznikDiag = 0;
        // sprawdz wygrane dla X diagonalne
        for (int z = 0; z < choices.length; z++) {
            if (choices[z][licznikDiag] == 'O') {
                countO++;
            }
            if (countO == 3) {
                Owins = true;
                break;
            }
            licznikDiag++;
        }

        countO = 0;
        licznikDiag = 2;
        // sprawdz wygrane dla X diagonalna 2
        for (int z = 0; z < choices.length; z++) {
            if (choices[z][licznikDiag] == 'O') {
                countO++;
            }
            if (countO == 3) {
                Owins = true;
                break;
            }
            --licznikDiag;
        }

        if (Owins == true) {
            return Owins;
        } else {
            Owins = false;
            return Owins;
        }
    }

    public static boolean remis(char[][] choices, boolean flag_winX, boolean flag_winO) {
        boolean draw = false;
        int countX = 0;
        int countO = 0;

        for (int i = 0; i < choices.length; i++) {
            for (int j = 0; j < choices.length; j++) {
                if (choices[i][j] != ' ') {
                    if (choices[i][j] == 'X') {
                        countX++;
                    } else {
                        countO++;
                    }
                }
            }
            if (countO + countX == 9) {
                draw = true;
                break;
            }
        }

        if (draw == true && flag_winX != true && flag_winO != true) {
            return draw;
        } else {
            draw = false;
            return draw;
        }
    }

    public static boolean notFinished(char[][] choices, boolean flag_winX, boolean flag_winO) {
        boolean not = false;
        int countX = 0;
        int countO = 0;
        int count_ = 0;

        for (int i = 0; i < choices.length; i++) {
            for (int j = 0; j < choices.length; j++) {
                if (choices[i][j] == 'X') {
                    countX++;
                } else if (choices[i][j] == 'O') {
                    countO++;
                } else {
                    count_++;
                }
            }
            if (count_ == countO && count_ == countX) {
                not = true;
                break;
            }
        }

        if (not == true && flag_winX != true && flag_winO != true) {
            return not;
        } else {
            not = false;
            return not;
        }
    }

    public static boolean impossible(char[][] choices, boolean flag_winX, boolean flag_winO) {
        boolean impo = false;
        int countX = 0;
        int countO = 0;

        for (int i = 0; i < choices.length; i++) {
            for (int j = 0; j  < choices.length; j++) {
                if (choices[i][j] == 'X') {
                    countX++;
                } else if (choices[i][j] == 'O') {
                    countO++;
                }
            }
        }

        if (Math.abs(countX - countO) > 1) {
            impo = true;
        } else if (flag_winX == true && flag_winO == true) {
            impo = true;
        }

        if (impo == true) {
            return impo;
        } else {
            impo = false;
            return impo;
        }
    }

    public static String statements (boolean flag_winX, boolean flag_winO, boolean flag_remis, boolean flag_not, boolean flag_impo) {

        String winner = "";
        String congrats = "Congratulations!";
        String again = "Try again";

        if (flag_winX == true && flag_winO != true && flag_remis != true && flag_not != true && flag_impo != true) {
            winner = "X wins";
            System.out.println(winner + "\n" + congrats);
        } else if (flag_winO == true && flag_winX != true && flag_remis != true && flag_not != true && flag_impo != true) {
            winner = "O wins";
            System.out.println(winner + "\n" + congrats);
        } else if (flag_remis == true && flag_winO != true && flag_winX != true && flag_not != true && flag_impo != true) {
            winner = "Draw";
            System.out.println(winner + "\n" + again);
        } else if (flag_not == true && flag_winX != true && flag_winO != true && flag_remis != true && flag_impo != true) {
            winner = "Game not finished.";
            System.out.println(winner + "\n" + again);
        } else if ((flag_impo == true && flag_not != true && flag_remis != true) || flag_winX == true && flag_winO == true) {
            winner = "Impossible";
            System.out.println(winner + "\n" + again);
        }
        return winner;
    }
}
