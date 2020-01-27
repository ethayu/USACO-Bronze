package Lesson4;

import java.io.*;
import java.util.*;

public class Baseball {

    public static void main( String [] args) throws FileNotFoundException {

        String filename = "baseball";
        Scanner sc = new Scanner( new File ( filename + ".in"));

        int n = sc.nextInt();

        int[] positions = new int[n];

        for (int i = 0; i < n; i++) {
            positions[i] = sc.nextInt();
        }

        Arrays.sort(positions);

        int num = 0;
        int xy = 0;
        int yz = 0;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                xy = positions[j] - positions[i];
                for (int k = j + 1; k < n; k++) {
                    yz = positions[k] - positions[j];
                    if ((yz <= 2*xy) && (yz >= xy)) {
                        num++;
                    }
                }
            }
        }

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        writer.println(num);
        writer.close();

    }

}
