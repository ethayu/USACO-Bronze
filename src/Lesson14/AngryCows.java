package Lesson14;
//50M timeout
import java.io.*;
import java.util.*;

public class AngryCows {

    static int check (int i, int[] bales, int t, boolean r, boolean l) {
        int n = 0;
        if (l && (i > 0) && (bales[i-1] >= bales[i] - t)) {
            int j = 1;
            for (j = 2; j < bales.length; j++) {
                if (i - j < 0) {
                    j--;
                    break;
                }
                if (!(bales[i-j] >= bales[i] - t)) {
                    j--;
                    break;
                }
            }
            n += check(i-j, bales, t+1, false, true) + 1;
        }
        if (r && (i < bales.length - 1) && (bales[i+1] <= bales[i] + t)) {
            int j = 1;
            for (j = 2; j < bales.length; j++) {
                if (i+j > bales.length - 1) {
                    j--;
                    break;
                }
                if (!(bales[i+j] <= bales[i] + t)) {
                    j--;
                    break;
                }
            }
            n += check(i+j, bales, t+1, true, false) + 1;
        }
        return n;
    }

    public static void main(String [] args) throws FileNotFoundException {

        String filename = "angry";
        Scanner sc = new Scanner( new File( filename + ".in"));

        int[] bales = new int[sc.nextInt()];

        for (int i = 0; i < bales.length; i++) {
            bales[i] = sc.nextInt();
        }

        Arrays.sort(bales);

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < bales.length; i++) {
            max = Integer.max(max, check(i, bales, 1, true, true));
        }

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        writer.println(max);
        writer.close();

    }

}
