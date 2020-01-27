package Lesson11;

import java.io.*;
import java.util.*;

public class BovineShuffle {

    public static void main(String [] args) throws FileNotFoundException {
        String filename = "shuffle";
        Scanner sc = new Scanner(new File(filename + ".in"));

        int[] shuffle = new int[sc.nextInt()];
        String[] result = new String[shuffle.length];
        String[] result1 = new String[shuffle.length];
        String[] result2 = new String[shuffle.length];
        String[] result3 = new String[shuffle.length];


        for (int i = 0; i < shuffle.length; i++) {
            shuffle[i] = sc.nextInt();
        }

        for (int i = 0; i < result.length ; i++) {
            result[i] = sc.next();
        }

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));


        for (int i = 0; i < result.length; i++) {
            int desiredindex = i + 1;//each result
            for (int j = 0; j < shuffle.length; j++) { //find in shuffle
                if (shuffle[j] == desiredindex) {
                    result1[j] = result[i];
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            int desiredindex = i + 1;//each result
            for (int j = 0; j < shuffle.length; j++) { //find in shuffle
                if (shuffle[j] == desiredindex) {
                    result2[j] = result1[i];
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            int desiredindex = i + 1;//each result
            for (int j = 0; j < shuffle.length; j++) { //find in shuffle
                if (shuffle[j] == desiredindex) {
                    result3[j] = result2[i];
                }
            }
        }

        for (int i = 0; i < result.length; i++) {
            writer.println(result3[i]);
        }
        writer.close();

    }

}
