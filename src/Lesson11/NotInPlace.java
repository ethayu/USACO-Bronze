//package Lesson11;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

public class NotInPlace {

    public static void main(String [] args) throws FileNotFoundException {
        String filename = "outofplace";
        Scanner sc = new Scanner(new File(filename + ".in"));

        int[] order = new int[sc.nextInt()];
        int[] sorted = new int[order.length];

        int counter = 0;

        for (int i = 0; i < order.length; i++) {
            order[i] = sc.nextInt();
            sorted[i] = order[i];
        }

        Arrays.sort(sorted);

        for (int i = 0; i < order.length; i++) {
            if (sorted[i] != order[i]) counter++;
        }

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));

        writer.println(counter-1);
        writer.close();

    }

}
