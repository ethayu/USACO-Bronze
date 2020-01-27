package Lesson12;

import java.io.*;
import java.util.*;

public class Moo {

    static char moo(int n) {

        int length = 0;
        int k = 0;

        while (n > length) {
            length = 2*length + 3 + k;
            k++;
        }

        //k--;

        if ((n - (length - (2 + k)) / 2) > 2 + k) {
            return moo((n - (length - (2 + k)) / 2) - (2 + k));
        } else if ((n - (length - (2 + k)) / 2) != 1) {
            return 'o';
        } else return 'm';
    }

    public static void main (String [] args) throws FileNotFoundException {

        String filename = "moo";
        Scanner sc = new Scanner(new File(filename + ".in"));

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        writer.println(moo(sc.nextInt()));
        writer.close();

    }

}
