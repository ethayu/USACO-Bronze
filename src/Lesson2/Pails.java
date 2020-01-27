package Lesson2;

import java.io.*;
import java.util.*;

public class Pails {

    public static void main(String [] args) throws FileNotFoundException {

        String filename  = "pails";
        Scanner sc = new Scanner(new File (filename + ".in"));
        int x = sc.nextInt();
        int y = sc.nextInt();
        int m = sc.nextInt();
        int max = java.lang.Math.floorDiv(m, x)*x;
        int temp = max;
        int countx = java.lang.Math.floorDiv(m, x);
        int county = 0;
        while ((temp > 0) && (county != java.lang.Math.floorDiv(m, y)) && (countx != 0)) {
            temp = temp - x + y;
            county++;
            countx--;
            while (temp > m) {
                temp = temp - x;
                countx--;
            }
            if (temp > max) {
                max = temp;
            }
        }

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        writer.println(max);
        writer.close();


    }

}
