package Lesson10;

import java.util.*;
import java.io.*;

public class MowingField {

    public static void main (String [] args) throws FileNotFoundException {

        String filename = "mowing";
        Scanner sc = new Scanner(new File(filename + ".in"));

        HashMap<String, Integer> field = new HashMap<>();

        int n = sc.nextInt();
        int x = 0;
        int y = 0;
        int t = 0;
        int min = Integer.MAX_VALUE;

        String coord;
        char dir;
        int dist;

        for (int i = 0; i < n; i++) {
            dir = sc.next().charAt(0);
            dist = sc.nextInt();
            for (int j = 0; j < dist; j++) {
                coord = x + " " + y;
                if (field.containsKey(coord)) {
                    min = Math.min(min, t - field.get(coord));
                    field.put(coord, t);
                } else field.put(coord, t);
                t++;
                if (dir == 'N') y++;
                else if (dir == 'S') y--;
                else if (dir == 'E') x++;
                else if (dir == 'W') x--;
            }
        }

        if (min == Integer.MAX_VALUE) min = -1;

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));

        writer.println(min);
        writer.close();

    }

}
