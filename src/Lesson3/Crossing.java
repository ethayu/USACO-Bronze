package Lesson3;

import java.io.*;
import java.util.*;

public class Crossing {

    public static void main( String [] args) throws FileNotFoundException {

        String filename = "crossroad";
        Scanner sc = new Scanner(new File( filename + ".in"));

        int n = sc.nextInt();

        int[] info = new int[n];

        int id = -1;

        int side = -1;

        int count = 0;

        //populate
        Arrays.fill(info, -1);

        for (int i = 0; i < n; i++) {

            id = sc.nextInt();
            side = sc.nextInt();

            if ((info[id-1] != -1) && (info[id-1] != side)) {

                count++;

            }
            info[id-1] = side;

        }

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        writer.println(count);
        writer.close();

    }

}
