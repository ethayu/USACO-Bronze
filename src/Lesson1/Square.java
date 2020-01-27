package Lesson1;

import java.io.*;
import java.util.*;


public class Square {

    public static void main(String [] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("square.in"));

        int [][] info = new int[2][4];

        for (int i = 0; i < 4; i++) {
            info[0][i] = sc.nextInt();
            info[1][i] = sc.nextInt();
        }

        Arrays.sort(info[0]);
        Arrays.sort(info[1]);

        PrintWriter writer = new PrintWriter(new File("square.out"));

        if ((info[0][3]-info[0][0]) > (info[1][3]-info[1][0])) {
            writer.println((info[0][3]-info[0][0])*(info[0][3]-info[0][0]));
        } else {
            writer.println((info[1][3]-info[1][0])*(info[1][3]-info[1][0]));
        }

        writer.close();

    }

}
