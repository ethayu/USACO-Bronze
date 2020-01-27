package Lesson8;

import java.io.*;
import java.util.*;

public class SlowDown {

    public static void main( String [] args) throws FileNotFoundException {

        String filename = "slowdown";
        Scanner sc = new Scanner(new File(filename + ".in"));

        ArrayList<Integer> times = new ArrayList<> ();
        ArrayList<Integer> distances = new ArrayList<> ();

        char event;

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            event = sc.next().charAt(0);
            if (event == 'T') times.add(sc.nextInt());
            else distances.add(sc.nextInt());
        }

        distances.add(1000);

        Collections.sort(distances);
        Collections.sort(times);
        //distances.sort(Integer::compareTo);
        //times.sort(Integer::compareTo);

        double t = 0;
        int s = 1;
        double d = 0;

        char nextevent;

        while (!distances.isEmpty()) {
            if (d >= 1000) break;
            if (times.isEmpty()) {
                t += ((distances.get(0) - d) * s);
                d = distances.remove(0);
                s++;
                continue;
            }
            if (((distances.get(0) - d) * s) > (times.get(0) - t)) {
                d += (times.get(0) - t) / s;
                if (d > 1000) {
                    d -= (times.get(0) - t) / s;
                    continue;
                }
                t = times.remove(0);
            } else {
                t += ((distances.get(0) - d) * s);
                d = distances.remove(0);
            }
            s++;
        }

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        writer.println((int)(t + 0.5));
        writer.close();

    }

}