package Lesson4;

import java.io.*;
import java.util.*;

public class Diamond {

    public static void main( String [] args) throws FileNotFoundException {

        String filename = "diamond";
        Scanner sc = new Scanner( new File ( filename + ".in"));

        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] sizes = new int[n];

        for (int i = 0; i < n; i++) {
            sizes[i] = sc.nextInt();
        }

        Arrays.sort(sizes);

        int maxnum = Integer.MIN_VALUE;
        int num = 0;

        for (int i = 0; i < n-1; i++) {
            if ((i > 0) && (sizes[i] == sizes[i-1])) continue;
            num = n - i;
            for (int j = i; j < n; j++) {
                if (sizes[j] > sizes[i] + k) {
                    num -= n-j;
                    break;
                }
            }

            maxnum = Math.max(maxnum, num);

        }

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        writer.println(maxnum);
        writer.close();

    }

}
