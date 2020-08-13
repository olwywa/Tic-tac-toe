package tictactoe;

import java.util.Scanner;

public class GettingClass {

    public int[] getInt() {
        Scanner scan = new Scanner(System.in);
        boolean correct = true;
        int coords[] = new int[2];
        int coo1 = 0;
        int coo2 = 0;

        while(correct){
            try {
                if (scan.hasNext()) {
                    String s[]= scan.nextLine().split(" ");
                    for (int i = 0 ; i < s.length; i++){
                        coords[i]= Integer.parseInt(s[i]);
                    }
                    coo1 = coords[0];
                    coo2 = coords[1];

                    if (coo1 < 1 || coo1 > 3 || coo2 < 1 || coo2 > 3) {
                        System.out.println("You should enter numbers from 1 to 3.");
                        System.out.println("Enter the coordinates: ");
                        correct = true;
                    } else {
                        correct = false;
                        return coords;
                    }
                }

            } catch (Exception e) {
                System.out.println("You should enter numbers!");
                System.out.println("Enter the coordinates: ");
                return getInt();
            }
        }
        return coords;
    }
}
