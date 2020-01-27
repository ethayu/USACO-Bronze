package Lesson3;

import java.io.*;
import java.util.*;

public class CircularBarn {

    public static void main ( String [] args) throws FileNotFoundException {

        String filename = "cbarn";
        Scanner sc = new Scanner(new File( filename + ".in"));

        int n = sc.nextInt();

        int[] rooms = new int[n];

        int cows = 0;

        for (int i = 0; i < n; i++) {

            rooms[i] = sc.nextInt();
            cows += rooms[i];

        }

        int mindist = n*cows;
        int dist = n*cows;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                dist -= rooms[(i+j)%n]*(n-j);

            }
            mindist = Math.min(mindist, dist);
            dist = n*cows;

        }

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        writer.println(mindist);
        writer.close();


    }

}
