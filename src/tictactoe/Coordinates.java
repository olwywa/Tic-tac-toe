package tictactoe;

public class Coordinates {

    public static int[] getCoordinates() {

         GettingClass get = new GettingClass();

        int[] coords = get.getInt();

        return coords;
    }

    public static char[][] errors(int coo1, int coo2, char[][] choices, int num) {

        char[][] choices2 = new char[3][3];
        boolean done = true;

        for (int i = 0; i < choices.length; i++) {
            for (int j = 0; j < choices.length; j++) {
                choices2 = occupied(coo1, coo2, choices, num);
                break;
            }
            if (done) {
                break;
            }
        }
        return choices2;
    }

    public static char[][] occupied(int coo1, int coo2, char[][] choices, int num) {

        int[] coords;
        boolean czyUdane = true;

        for (int i = 0; i < choices.length; i++) {
            for (int j = 0; j < choices.length; j++) {
                if (choices[3 - coo2][coo1 - 1] != ' ') {
                    czyUdane = false;
                    System.out.println("This cell is occupied! Choose another one!");
                    System.out.println("Enter the coordinates: ");
                    coords = getCoordinates();
                    coo1 = coords[0];
                    coo2 = coords[1];
                    if (choices[3 - coo2][coo1 - 1] == ' ') {
                        freeField(coo1, coo2, choices, num);
                        break;
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        System.out.println("Enter the coordinates: ");
                        coords = getCoordinates();
                        coo1 = coords[0];
                        coo2 = coords[1];
                    }
                } else {
                    freeField(coo1, coo2, choices, num);
                    break;
                }
            }
            if (czyUdane) {
                break;
            }
        }
        return choices;
    }

    public static char[][] freeField(int coo1, int coo2, char[][] choices, int num) {

        boolean good = false;
        char o = 'O';
        char x = 'X';

        for (int i = 0; i < choices.length; i++) {
            for (int j = 0; j < choices.length; j++) {
                if (coo1 >= 1 && coo2 >= 1) {
                    if (num %  2 == 0) {
                        choices[3 - coo2][coo1 - 1] = x;
                    } else if (num %  2 != 0) {
                        choices[3 - coo2][coo1 - 1] = o;
                    }
                    good = true;
                    break;
                }
            }
            if (good) {
                break;
            }
        }
        return choices;
    }
}
