/*
 * This is a game where user need to fing correct number from 0 to 100 .
 */

import java.util.*;

public class Zad_6 {
    public static void main(String[] args) {
        lottery();
    }

    public static void lottery() {
        final Scanner sc = new Scanner(System.in);
        final Random rand = new Random();

        System.out.println("Put yout number from 0 to 100 :");
        int y = rand.nextInt(101);
        
        int x = sc.nextInt();
        while (x != y) {
            if (x > y) {
                System.out.println("The number is too big");
                System.out.println("Trye again");
                x = sc.nextInt();
            }if (x < y) {
                System.out.println("The number is too low");
                System.out.println("Trye again");
                x = sc.nextInt();
            }

        }
        System.out.println("Congratulations");
    }
}
