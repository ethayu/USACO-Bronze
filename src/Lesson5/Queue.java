package Lesson5;

import java.io.*;
import java.util.*;

public class Queue {

    static class Entry implements Comparable <Entry>{

        int arrival;
        int duration;
        public Entry (int n1, int n2) {
            arrival = n1;
            duration = n2;
        }
        public int compareTo (Entry a) {
            if (arrival > a.arrival) return 1;
            else if (arrival < a.arrival) return -1;
            else return 0;
        }
    }

    public static void main( String [] args) throws FileNotFoundException {

        String filename = "cowqueue";
        Scanner sc = new Scanner( new File ( filename + ".in"));

        int n = sc.nextInt();

        Entry[] cows = new Entry[n];

        for (int i = 0; i < n; i++) {
            cows[i] = new Entry(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(cows);

        int t = cows[0].arrival;

        for (int i = 0; i < n - 1; i++) {
            t += cows[i].duration;
            if (cows[i+1].arrival < t) continue;
            else t = cows[i+1].arrival;
        }

        t += cows[n-1].duration;

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        writer.println(t);
        writer.close();

    }

}
