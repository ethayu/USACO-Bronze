package Lesson7;

import java.io.*;
import java.util.*;

public class CowTipping {

    public static void Flip(int[][] cows, int a, int b) {
        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                if (cows[i][j] == 1) {
                    cows[i][j] = 0;
                    continue;
                }
                if (cows[i][j] == 0) cows[i][j] = 1;
            }
        }
    }

    public static void main(String [] args) throws FileNotFoundException {

        String filename = "cowtip";
        Scanner sc = new Scanner(new File(filename + ".in"));

        int n = sc.nextInt();

        int[][] cows = new int[n][n];

        String row;

        for (int i = 0; i < n; i++) {
            row = sc.next();
            for (int j = 0; j < n; j++) {
                cows[i][j] = Character.getNumericValue((int)row.charAt(j));
            }
        }

        int flips = 0;

        //int i = n - 1;
        //int j = i;

        for (int i = n - 1; i >= 0 ; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (cows[i][j] == 1) {
                    flips++;
                    Flip(cows, i, j);
                }
            }
        }

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        writer.println(flips);
        writer.close();

    }

}