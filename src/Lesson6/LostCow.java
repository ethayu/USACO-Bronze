//package Lesson6;

import java.io.*;
import java.util.*;

public class LostCow {

    public static void main( String [] args) throws FileNotFoundException {

        String filename = "lostcow";
        Scanner sc = new Scanner(new File(filename + ".in"));

        int x = sc.nextInt();
        int y = sc.nextInt();

        int dist = 1;
        int a = -2;
        boolean notcrossed = true;

        while (notcrossed) {
            dist += Math.abs((x + a) - (x + (a/-2)));
            if ((x + a >= y) && (y > x + (a/-2)) || (x + a <= y) && (y < x + (a/-2))) {
                dist -= Math.abs(y - (x + a));
                notcrossed = false;
            }
            a *= -2;
        }

        if (y == x + 1) dist = 1;

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        writer.println(dist);
        writer.close();

    }

}