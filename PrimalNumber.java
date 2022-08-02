/*
    * Program is checking is the number primal or not
 */

import java.util.*;

public class Zad_11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(primeNumbers(sc.nextInt()));
    }
    public static String primeNumbers(int a) {
        
        if (a > 1) {
            for (int i = 2; i < 10; i++) {
                if (i != a) {
                    if (a % i == 0) {
                        return "not prime";
                    }
                }
            }
            return "prime";
        }else {
            return "not prime";
        }
    }
    
}
