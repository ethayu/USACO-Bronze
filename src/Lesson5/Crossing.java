package Lesson5;

import java.io.*;
import java.util.*;

public class Crossing {

    static class Cows implements Comparable <Cows>{

        int a;
        int b;
        boolean safe;
        public Cows (int a, int b) {
            this.a = a;
            this.b = b;
            safe = true;
        }
        public int compareTo (Cows c) {
            return a-c.a;
        }
    }

    public static void main( String [] args) throws FileNotFoundException {

        String filename = "crossings";
        Scanner sc = new Scanner( new File ( filename + ".in"));

        int n = sc.nextInt();

        Cows[] crossings = new Cows[n];

        for (int i = 0; i < n; i++) {
            crossings[i] = new Cows(sc.nextInt(), sc.nextInt());
        }

        Arrays.sort(crossings);

        int counter = 0;
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (crossings[i].b < max) crossings[i].safe = false;
            else max = crossings[i].b;
        }

        for (int i = n-1; i >= 0; i--) {
            if (crossings[i].b > min) crossings[i].safe = false;
            else min = crossings[i].b;
        }

        for (int i = 0; i < n; i++) {
            if (crossings[i].safe) counter++;
        }

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        writer.println(counter);
        writer.close();

    }

}
