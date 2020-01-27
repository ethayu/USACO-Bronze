package Lesson2;

import java.util.*;
import java.io.*;

public class Marathon {

    static int distance(int a, int b, int c, int d) {
        return Math.abs(a - c) + Math.abs(b - d);
    }

    public static void main(String [] args) throws FileNotFoundException {

        String filename = "marathon";

        Scanner sc = new Scanner(new File(filename + ".in"));

        int n = sc.nextInt();

        int[][] checkpoints = new int[n][2];

        for (int i = 0; i < n; i++) {

            checkpoints[i][0] = sc.nextInt();
            checkpoints[i][1] = sc.nextInt();

        }

        int totalsum = 0;
        int maxsaved = 0;
        int saved = 0;

        for (int i = 1; i < n - 1; i++) {

            totalsum += distance(checkpoints[i][0], checkpoints[i][1], checkpoints[i-1][0], checkpoints[i-1][1]);
            maxsaved = Math.max(maxsaved,
                    ((
                    (distance(checkpoints[i][0], checkpoints[i][1], checkpoints[i-1][0], checkpoints[i-1][1])) +
                    (distance(checkpoints[i][0], checkpoints[i][1], checkpoints[i+1][0], checkpoints[i+1][1])) -
                    (distance(checkpoints[i-1][0], checkpoints[i-1][1], checkpoints[i+1][0], checkpoints[i+1][1]))
                    ))
            );

        }

        totalsum += distance(checkpoints[n-2][0], checkpoints[n-2][1], checkpoints[n-1][0], checkpoints[n-1][1]);

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        writer.println(totalsum-maxsaved);
        writer.close();

    }

}
