package Lesson3;

import java.io.*;
import java.util.*;

public class SkiDesign {

    public static void main( String [] args) throws FileNotFoundException {

        String filename = "skidesign";
        Scanner sc = new Scanner(new File( filename + ".in"));

        int n = sc.nextInt();


        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {

            heights[i] = sc.nextInt();

        }

        int cost;
        int mincost = Integer.MAX_VALUE;

        Arrays.sort(heights);
        for (int i = heights[0]; i < heights[n-1] - 17; i++) {

            cost = 0;

            for (int j = 0; j < n; j++) {
                if (heights[j] < i) {
                    cost += (i-heights[j])*(i-heights[j]);
                } else if (heights[j] > i + 17) {
                    cost += (heights[j] - i - 17)*(heights[j] - i - 17);
                }
            }

            if (mincost > cost) {
                mincost = cost;
            }

        }

        if (mincost == Integer.MAX_VALUE) mincost = 0;

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        writer.println(mincost);
        writer.close();

    }

}
