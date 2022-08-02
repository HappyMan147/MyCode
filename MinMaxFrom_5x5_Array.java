/*
  The program creates a 5 x 5 table with the numbers from -5 to 5 and finds the minimum
    and maximum in each column in the table and displays each minimum and maximum
 */

import java.util.Random;

public class Zad_3 {
    public static void main(String[] args) {
        TMaxMin();
    }

    public static int[][] tablica() {
        final Random rand = new Random();
        int[][] tab = new int[5][5];
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab.length; j++) {
                tab[i][j] = rand.nextInt(10) - 5;
            }
        }
        return tab;
    }

    public static void TMaxMin() {
        int[][] cop = tablica();
        int[] minima = new int[cop.length];
        int[] maxima = new int[cop.length];


        for (int i = 0; i < cop.length; i++) {
            int min = cop[0][i];
            int max = cop[0][i];

            for (int j = 0; j < cop.length; j++) {
                if (max < cop[j][i]) {
                    max = cop[j][i];
                }
                if (min > cop[j][i]) {
                    min = cop[j][i];
                }
            }
            maxima[i] = max;
            minima[i] = min;
         }
      
      
        for (int i = 0; i < cop.length; i++) {
            for (int j = 0; j < cop.length; j++) {
                System.out.print(cop[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("An array with minims");
        for(int x : minima){
            System.out.print(x + " ");
        }
        System.out.println();
        System.out.println();
        System.out.println("An array with maxims");
        for (int z : maxima){
            System.out.print(z + " ");
        }

    }


}
