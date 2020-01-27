package Lesson13;

import java.io.*;
import java.util.*;

public class CountingHaybales {

    public static void main (String [] args) throws FileNotFoundException {

        String filename = "haybales";
        Scanner sc = new Scanner(new File(filename + ".in"));

        int n = sc.nextInt();
        int q = sc.nextInt();

        int[] haybales = new int[n];

        for (int i = 0; i < n; i++) {
            haybales[i] = sc.nextInt();
        }

        Arrays.sort(haybales);

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));

        for (int i = 0; i < q; i++) {
            int begin = Arrays.binarySearch(haybales, sc.nextInt());
            int end = Arrays.binarySearch(haybales, sc.nextInt());
            if (begin < 0) {
                begin = -1 * (begin + 1);
            }
            if (end < 0) {
                end = -1 * (end + 1) - 1;
            }
            writer.println(end - begin + 1);

        }
        writer.close();

    }

}
