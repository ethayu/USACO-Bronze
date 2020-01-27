//package Lesson14;
//50M timeout
import java.io.*;
import java.util.*;

public class LoadBalancing {

    static int check(int xc, int yc, int[] x, int[] y, int n) {
        int[] quadrants = new int[4];
        Arrays.fill(quadrants, 0);

        for (int i = 0; i < n; i++) {

            if (x[i] > xc) {
                if (y[i] > yc) {
                    quadrants[0]++;
                } else quadrants[3]++;
            }
            if (x[i] < xc) {
                if (y[i] > yc) {
                    quadrants[1]++;
                } else quadrants[2]++;
            }

        }

        Arrays.sort(quadrants);
        return quadrants[3];
    }

    public static void main(String [] args) throws FileNotFoundException {

        String filename = "balancing";
        Scanner sc = new Scanner( new File( filename + ".in"));

        int n = sc.nextInt();
        sc.nextInt();

        int[] x = new int[n];
        int[] y = new int[n];
        int[] xs = new int[n];
        int[] ys = new int[n];

        for (int i = 0; i < n; i++) {

            x[i] = sc.nextInt();
            xs[i] = x[i];
            y[i] = sc.nextInt();
            ys[i] = y[i];

        }

        Arrays.sort(xs);
        Arrays.sort(ys);

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-1; j++) {
                min = Integer.min(min, check(xs[i] + 1, ys[i] + 1, x, y, n ));
            }
        }




        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        writer.println(min);
        writer.close();

    }

}
