package Lesson2;

import java.io.*;
import java.util.*;

public class CowRoute {

    public static void main(String [] args) throws FileNotFoundException {

        String filename = "cowroute";
        Scanner sc = new Scanner(new File(filename + ".in"));

        int a = sc.nextInt();
        int b = sc.nextInt();
        int n = sc.nextInt();

        int[][] routes = new int[2*n][500];

        for (int i = 0; i < n; i++) {

            routes[2*i][0] = sc.nextInt();
            routes[2*i][1] = sc.nextInt();

            for (int j = 0; j < routes[2*i][1]; j++) {

                routes[2*i+1][j] = sc.nextInt();

            }

        }

        int mincost = -1;
        boolean possible = false;

        for (int i = 1; i < 2*n; i += 2) {

            for (int j = 0; j < routes[i-1][1]; j++) {
                if (possible) {
                    if (routes[i][j] == b) {
                        if ((mincost == -1) || (mincost > routes[i-1][0])) {
                            mincost = routes[i-1][0];
                        }
                        break;
                    }
                } else if (routes[i][j] == a) {
                    possible = true;
                }

            }

            possible = false;

        }

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        writer.println(mincost);
        writer.close();

    }

}
