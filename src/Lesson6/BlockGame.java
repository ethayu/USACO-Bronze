package Lesson6;

import java.io.*;
import java.util.*;

public class BlockGame {

    public static void main( String [] args) throws FileNotFoundException {

        String filename = "blocks";
        Scanner sc = new Scanner(new File(filename + ".in"));

        String[][] blocks = new String[sc.nextInt()][2];
        int[] letters1 = new int[26];
        int[] letters2 = new int[26];
        int[] output = new int[26];

        for (int i = 0; i < blocks.length; i++) {
            blocks[i][0] = sc.next();
            blocks[i][1] = sc.next();
        }

        for (int i = 0; i < blocks.length; i++) {
            for (int j = 0; j < blocks[i][0].length(); j++) {
                letters1[(int)blocks[i][0].charAt(j) - 97]++;
            }
            for (int j = 0; j < blocks[i][1].length(); j++) {
                letters2[(int)blocks[i][1].charAt(j) - 97]++;
            }
            for (int j = 0; j < 26; j++) {
                output[j] += Math.max(letters1[j], letters2[j]);
            }
            Arrays.fill(letters1, 0);
            Arrays.fill(letters2, 0);
        }

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        for (int i = 0; i < 26; i++) {
            writer.println(output[i]);
        }
        writer.close();

    }

}