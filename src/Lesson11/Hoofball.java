//package Lesson11;

import java.io.*;
import java.util.*;

public class Hoofball {

    public static void main(String [] args) throws FileNotFoundException {
        String filename = "hoofball";
        Scanner sc = new Scanner(new File(filename + ".in"));

        int[] cows = new int[sc.nextInt()];
        int[] dist = new int[cows.length-1];
        int[] receives = new int[cows.length];

        Arrays.fill(receives, 0);

        for (int i = 0; i < cows.length; i++) {
            cows[i] = sc.nextInt();
        }
        Arrays.sort(cows);

        for (int i = 0; i < dist.length; i++) {
            dist[i] = cows[i+1] - cows[i];
        }

        for (int i = 0; i < cows.length; i++) {
            if (i == 0) {
                receives[1]++;
            } else if (i == cows.length-1) {
                receives[cows.length-2]++;
            } else if (dist[i-1] > dist[i]) receives[i+1]++;
            else receives[i-1]++;
        }

        int counter = 0;
        for (int i = 0; i < receives.length; i++) {
            if (receives[i] == 0) counter++;
            if (i == receives.length - 1) break;
            if (receives[i] == 1) {
                if (receives[i + 1] == 1) {
                    if (i >= receives.length-3) {
                        if (dist[i - 2] <= dist[i - 1]) {
                            counter++;
                            i++;
                        }
                    } else if (i <= 1) {
                        if (dist[i + 2] < dist[i + 1]) {
                            counter++;
                            i++;
                        }
                    } else if ((dist[i - 2] <= dist[i - 1]) && (dist[i + 2] < dist[i + 1])) {
                        counter++;
                        i++;
                    }
                }
            }
        }

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));

        writer.println(counter);
        writer.close();

    }

}
