package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Enter cells: ");
        Scanner scan = new Scanner(System.in);

        String str = scan.next();
        char[][] choices = new char[3][3];
        int licznikStr = 0;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                choices[i][j] = str.charAt(licznikStr);
                licznikStr++;
            }
        }

        utworzPlansze(choices);

        boolean flag_winX = sprawdzXwin(choices);
        boolean flag_winO = sprawdzOwin(choices);
        boolean flag_remis = remis(choices, flag_winX, flag_winO);
        boolean flag_not = notFinished(choices, flag_winX, flag_winO);
        boolean flag_impo = impossible(choices, flag_winX, flag_winO);

        if (flag_winX == true && flag_winO != true && flag_remis != true && flag_not != true && flag_impo != true) {
            System.out.println("X wins");
        } else if (flag_winO == true && flag_winX != true && flag_remis != true && flag_not != true && flag_impo != true) {
            System.out.println("O wins");
        } else if (flag_remis == true && flag_winO != true && flag_winX != true && flag_not != true && flag_impo != true) {
            System.out.println("Draw");
        } else if (flag_not == true && flag_winX != true && flag_winO != true && flag_remis != true && flag_impo != true) {
            System.out.println("Game not finished");
        } else if ((flag_impo == true && flag_not != true && flag_remis != true) || flag_winX == true && flag_winO == true) {
            System.out.println("Impossible");
        }

    }
    public static void utworzPlansze(char[][] choices) {
        //utworzenie planszy i jej elementów
        char[][] plansza = {
                {'-', '-', '-', '-', '-', '-', '-', '-', '-'},
                {'|', ' ', choices[0][0], ' ', choices[0][1], ' ', choices[0][2], ' ', '|'},
                {'|', ' ', choices[1][0], ' ', choices[1][1], ' ', choices[1][2], ' ', '|'},
                {'|', ' ', choices[2][0], ' ', choices[2][1], ' ', choices[2][2], ' ', '|'},
                {'-', '-', '-', '-', '-', '-', '-', '-', '-'}
        };
        for (int i = 0; i < plansza.length; ++i) {
            System.out.println(plansza[i]);
        }
    }

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
                if (choices[i][j] != '_') {
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

}