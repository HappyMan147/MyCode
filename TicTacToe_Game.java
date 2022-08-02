/* TicTacToe game
   1 : First is X next O etc.
   2 : You should input cordinates to 3x3 two dimension array  np 1 1, 2 2, 3 1.
   3 : Game will be end when one of side will win or ther will be a draw.
 */

import java.util.InputMismatchException;
import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {

        input(tab());


    }

   
    public static char[][] tab() {
        Scanner sc = new Scanner(System.in);

        char[][] arr = new char[3][3];
        int k = 0;

        String a = "         ";

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                arr[i][j] = a.charAt(k++);
            }
        }
        System.out.println("---------");
        for (char[] chars : arr) {
            System.out.print("| ");
            for (int j = 0; j < arr.length; j++) {
                System.out.print(chars[j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");

        return arr;
    }


    public static void input(char[][] arr) {
        boolean ch = true;
        while (ch) {
            ch = false;
            try {
                char[][] copy = arr;
                Scanner sc = new Scanner(System.in);
                int n1;
                int n2;
                int count = 0;

                boolean ix = false;
                boolean io = false;
                boolean draw = false;

                while (!draw) {


                    for (int j = 0; j < 3; j++) {

                        if (copy[j][0] == 'X' && copy[j][1] == 'X' && copy[j][2] == 'X' || copy[0][j] == 'X' && copy[1][j] == 'X' && copy[2][j] == 'X' || copy[0][0] == 'X' && copy[1][1] == 'X' && copy[2][2] == 'X' || copy[0][2] == 'X' && copy[1][1] == 'X' && copy[2][0] == 'X') {

                            ix = true;

                        }
                        if (copy[j][0] == 'O' && copy[j][1] == 'O' && copy[j][2] == 'O' || copy[0][j] == 'O' && copy[1][j] == 'O' && copy[2][j] == 'O' || copy[0][0] == 'O' && copy[1][1] == 'O' && copy[2][2] == 'O' || copy[0][2] == 'O' && copy[1][1] == 'O' && copy[2][0] == 'O') {
                            io = true;
                        }
                    }


                    for (int i = 0; i < copy.length; i++) {
                        for (int j = 0; j < copy.length; j++) {
                            if (copy[i][j] != 'X' && copy[i][j] != 'O' && copy[i][j] != ' ') {
                                System.out.println("Draw");
                                draw = true;
                                break;
                            }
                        }
                    }
                    if (io == true && ix == false) {
                        System.out.println("O wins");
                        draw = true;
                        break;
                    } else if (io == false && ix == true) {
                        System.out.println("X wins");
                        draw = true;
                        break;
                    }

                    System.out.print("Enter the coordinates: ");
                    n1 = sc.nextInt();
                    n2 = sc.nextInt();
                    --n1;
                    --n2;
                    if (n1 > 2 || n2 > 2) {
                        System.out.println("Coordinates should be from 1 to 3!");
                        continue;
                    } else if (copy[n1][n2] == 'X' || copy[n1][n2] == 'O') {
                        System.out.println("This cell is occupied! Choose another one!");
                        continue;
                    } else {
                        count++;
                        if (count % 2 == 0) {
                            copy[n1][n2] = 'X';
                        } else copy[n1][n2] = 'O';
                    }

                    System.out.println("---------");

                    for (char[] chars : copy) {
                        System.out.print("| ");
                        for (int j = 0; j < copy.length; j++) {
                            System.out.print(chars[j] + " ");
                        }
                        System.out.println("|");
                    }

                    System.out.println("---------");

                }
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                ch = true;
            }
        }
    }
}
