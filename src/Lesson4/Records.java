package Lesson4;

import java.io.*;
import java.util.*;

public class Records {

    public static void main( String [] args) throws FileNotFoundException {

        String filename = "records";
        Scanner sc = new Scanner( new File ( filename + ".in"));

        String[][] groups = new String[sc.nextInt()][3];

        for (int i = 0; i < groups.length; i++) {
            groups[i][0] = sc.next();
            groups[i][1] = sc.next();
            groups[i][2] = sc.next();
            Arrays.sort(groups[i]);
        }

        int maxnum = Integer.MIN_VALUE;
        int num;

        for (int i = 0; i < groups.length; i++) {
            num = 0;
            for (int j = 0; j < groups.length; j++) {
                if (Arrays.equals(groups[j], groups[i])) {
                    num++;
                }
            }
            maxnum = Math.max(maxnum, num);
        }

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        writer.println(maxnum);
        writer.close();

    }

}
