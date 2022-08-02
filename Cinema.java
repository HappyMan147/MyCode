/*
  At the start program is reading two positive integer numbers that represents the number of rows and seats in each row.
  Then it prints a menu with four items (1, 2, 3, 4):
 1) "Show the seats" is print the current seating arrangement. The empty seats is marked as an S symbol, and taken seats
    are marked with a B symbol.
 2) "Buy a ticket" is reading the seat coordinates from the input and print the ticket price. After that, the chosen
     seat are marked with a B when the item "Show the seats" is called.
 3) "Statistics" is print the current statistics about cinema: number of purchased tickets, percentage of sellying tickets, current 
     income from selling tickets and total income that we will take when me will sell all tickets.
 4) "Exit" is stop the program.
 */

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;


public class Cinema {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of rows:");
        int a = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int b = sc.nextInt();

        wsid(start(a, b));
    }


    public static void wsid(char[][] first) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("1. Show the seats");
        System.out.println("2. Buy a ticket");
        System.out.println("3. Statistics");
        System.out.println("0. Exit");
        int[] set;
        int w = sc.nextInt();
        switch (w) {
            case 1:
                printTab(first);
                wsid(first);
            case 2:
                set = calPrice(first);
                first[set[0] - 1][set[1] - 1] = 'B';
                wsid(first);
            case 3:
                stats(first);
                wsid(first);
            case 0:
                break;
        }
    }

    public static char[][] start(int a, int b) {
        char[][] arr = new char[a + 1][b + 1];

        for (int i = 0; i < a; i++) {
            for (int j = 0; j < b; j++) {
                arr[i][j] = 'S';
            }
        }
        return arr;
    }

    public static char[][] printTab(char[][] arr) {
        int c = arr[1].length - 1;
        int d = arr.length - 1;
        System.out.println("Cinema:");
        System.out.print("  ");
        for (int i = 1; i <= c; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (
                int i = 0;
                i < d; i++) {
            System.out.print(i + 1 + " ");
            for (int j = 0; j < c; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
        return arr;
    }


    public static int[] calPrice(char[][] arr) {

        Scanner sc = new Scanner(System.in);
        int e = arr[1].length - 1;
        int a = arr.length - 1;

        System.out.println();
        System.out.println("Enter a row number:");
        int r = sc.nextInt();
        System.out.println("Enter a seat number in that row:");
        int s = sc.nextInt();

        while (r > arr.length - 1 || s > arr[1].length - 1 || r <= 0 || s <= 0 || arr[r - 1][s - 1] == 'B') {
            if (r > arr.length - 1 || s > arr[1].length - 1 || r <= 0 || s <= 0) {
                System.out.println();
                System.out.println("Wrong input!");
                System.out.println();
                System.out.println("Enter a row number:");
                r = sc.nextInt();
                System.out.println("Enter a seat number in that row:");
                s = sc.nextInt();
            } else if (arr[r - 1][s - 1] == 'B') {
                System.out.println();
                System.out.println("That ticket has already been purchased!");
                System.out.println();
                System.out.println("Enter a row number:");
                r = sc.nextInt();
                System.out.println("Enter a seat number in that row:");
                s = sc.nextInt();
            }
        }

        int rs = a * e;
        int price;
        int half = a / 2;

        if (rs > 60) {
            if (half >= r) {
                price = 10;
            } else {
                price = 8;
            }
        } else {
            price = 10;
        }

        arr[r - 1][s - 1] = 'B';
        System.out.println();
        System.out.println("Ticket price: $" + price);
        System.out.println();

        return new int[]{r, s};
    }

    public static void stats(char[][] arr) {
        float count = (arr.length * arr[1].length) - ((arr.length + arr[1].length) - 1);
        int hasS = 0;
        float percentage;
        int price = 0;
        int half;
        if (arr.length % 2 == 0) {
            half = (arr.length - 1) / 2;
        } else {
            half = arr.length / 2;
        }
        int totalIncome = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

                if (arr[i][j] == 'B') {
                    hasS++;
                }
            }
        }

        System.out.println("Number of purchased tickets: " + hasS);


        percentage = (hasS / count) * 100;
        DecimalFormat f = new DecimalFormat("0.00");

        System.out.println("Percentage: " + f.format(percentage) + "%");


        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (count > 60) {
                    if (half >= i) {
                        if (arr[i][j] == 'B') {
                            price += 10;
                        }
                        if (i < arr.length - 1 && j < arr[i].length - 1) {
                            totalIncome += 10;
                        }
                    } else {
                        if (arr[i][j] == 'B') {
                            price += 8;
                        }
                        if (i < arr.length - 1 && j < arr[i].length - 1) {
                            totalIncome += 8;
                        }
                    }
                } else {
                    if (arr[i][j] == 'B') {
                        price += 10;
                    }
                    if (i < arr.length - 1 && j < arr[i].length - 1) {
                        totalIncome += 10;
                    }
                }
            }
        }


        System.out.println("Current income: $" + price);
        System.out.println("Total income : $" + totalIncome);

    }
}
