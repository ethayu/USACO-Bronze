package Lesson10;

import java.util.*;
import java.io.*;

public class NotLast {

    public static void main (String [] args) throws FileNotFoundException {

        String filename = "notlast";
        Scanner sc = new Scanner(new File(filename + ".in"));

        HashMap<String, Integer> entries = new HashMap<>();

        int min = Integer.MAX_VALUE - 1;
        int min2 = Integer.MAX_VALUE;

        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String cow = sc.next();
            if (entries.containsKey(cow)) entries.put(cow, entries.get(cow) + sc.nextInt());
            else {
                entries.put(cow, sc.nextInt());
            }
        }

        for (String cow : entries.keySet()) {
            min = Math.min(entries.get(cow), min);
        }

        for (String cow : entries.keySet()) {
            if ((entries.get(cow) > min) && (entries.get(cow) < min2))
            min2 = entries.get(cow);
        }

        if (entries.size() < 7) {
            min2 = min;
            min = 0;
        }

        int counter = 0;

        String notlastcow = "";

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));

        for (String cow : entries.keySet()) {
            if (entries.get(cow) == min2) {
                counter++;
                if (counter == 1) notlastcow = cow;
            }
        }

        if ((min2 == Integer.MAX_VALUE) || (counter > 1)) {
            writer.println("Tie");
            writer.close();
        }

        writer.println(notlastcow);
        writer.close();

    }

}
