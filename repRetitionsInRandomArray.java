/*
   Program is creating array with 20 numbers from 1 to 10 
   and printing out how many time and what number is repeting in array
 */

import java.util.*;

public class Zad_2 {
    public static void main(String[] args) {
        HMTSN();

    }

    public static int[] numS() {
        int[] arr = new int[20];
        final Random rand = new Random();
        for (int i = 0; i < 20; i++) {
            arr[i] = rand.nextInt(10) + 1;
        }
        return arr;
    }

    public static void HMTSN() {
        int[] arr = numS();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int x : arr) {
            if (!(map.containsKey(x))) {
                map.put(x, 0);
            }
            // changing map value +1 if map contains x
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            }
        }


        // Print out key and value from map
        for (int f : map.keySet()) {
            System.out.println(f + " - " + map.get(f));
        }
    }

}
