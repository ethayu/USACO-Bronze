 package Lesson9;

import java.io.*;
import java.util.*;

public class ModernArt {

    public static void main( String [] args) throws FileNotFoundException {

        String filename = "art";
        Scanner sc = new Scanner(new File(filename + ".in"));

        int n = sc.nextInt();

        int[][] painting = new int[n][n];
        int[][] parameters = new int[10][4];

        HashSet<Integer> possibilities = new HashSet<>();

        for (int i = 0; i < n; i++) {
            String row = sc.next();
            for (int j = 0; j < n; j++) {
                int color = Character.getNumericValue(row.charAt(j));
                if (color == 0) continue;
                painting[i][j] = color;
                if (possibilities.contains(color)) {
                    if (i < parameters[color][0]) parameters[color][0] = i;
                    if (j < parameters[color][1]) parameters[color][1] = j;
                    if (i > parameters[color][2]) parameters[color][2] = i;
                    if (j > parameters[color][3]) parameters[color][3] = j;
                } else {
                    possibilities.add(color);
                    parameters[color] = new int[]{i, j, -1, -1};
                }
            }
        }

        HashSet<Integer> clone = new HashSet<>(possibilities);
        for (int everycolor : possibilities) {
            for (int i = parameters[everycolor][0]; i <= parameters[everycolor][2]; i++) {
                for (int j = parameters[everycolor][1]; j <= parameters[everycolor][3]; j++) {
                    if (painting[i][j] != everycolor) clone.remove(painting[i][j]);
                }
            }
        }



        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        writer.println(clone.size());
        writer.close();

    }

}