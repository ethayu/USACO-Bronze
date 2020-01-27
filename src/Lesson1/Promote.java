package Lesson1;

import java.io.*;
import java.util.Scanner;

public class Promote {

    public static void main(String [] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("promote.in"));

        int info[][] = new int[4][2];
        int output[] = new int[3];

        for (int i = 0; i < 4; i++) {
            info[i][0] = sc.nextInt();
            info[i][1] = sc.nextInt();
        };

        PrintWriter writer = new PrintWriter(new File("promote.out"));

        int numberpromoted = 0;

        for (int i = 3; i > 0; i--) {
            if (i == 3)  numberpromoted = info[i][1] - info[i][0];
            else numberpromoted += info[i][1] - info[i][0];
            output[i-1] = numberpromoted;
        }

        for (int i = 0; i < 3; i++) {
            writer.println(output[i]);
        }

        writer.close();

    }

}
