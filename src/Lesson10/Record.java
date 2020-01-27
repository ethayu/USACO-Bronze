package Lesson10;

import java.util.*;
import java.io.*;

public class Record {

    public static void main (String [] args) throws FileNotFoundException {

        String filename = "records";
        Scanner sc = new Scanner(new File(filename + ".in"));

        HashMap<String, Integer> records = new HashMap<>();

        int max = 1;
        int n = sc.nextInt();

        String line;

        for (int i = 0; i < n ; i++) {

            String[] record = new String[3];
            record[0] = sc.next();
            record[1] = sc.next();
            record[2] = sc.next();
            Arrays.sort(record);
            line = record[0] + record[1] + record[2];

            if (records.containsKey(line)) {
                records.put(line, records.get(line) + 1);
                max = Math.max(records.get(line), max);
            }
            else records.put(line, 1);

        }

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        writer.println(max);
        writer.close();

    }

}
