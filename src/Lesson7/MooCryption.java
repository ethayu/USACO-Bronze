package Lesson7;

import java.io.*;
import java.util.*;

public class MooCryption {

    private static int Calculate(char[] target, char[][] crossword) {
        int counter = 0;
        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[i].length; j++) {
                char M = target[0];
                char O = target[1];
                if (crossword[i][j] == M) {
                    if (i - 2 >= 0) {
                        if ((crossword[i - 1][j] == O) && (crossword[i - 2][j] == O)) counter++;
                        if (j + 2 <  crossword[i].length) {
                            if ((crossword[i - 1][j + 1] == O) && (crossword[i - 2][j + 2] == O)) counter++;
                        }
                        if (j - 2 >= 0) {
                            if ((crossword[i - 1][j - 1] == O) && (crossword[i - 2][j - 2] == O)) counter++;
                        }
                    }
                    if (j + 2 < crossword[i].length) {
                        if ((crossword[i][j + 1] == O) && (crossword[i][j + 2] == O)) counter++;
                        if (i + 2 < crossword.length) {
                            if ((crossword[i + 1][j + 1] == O) && (crossword[i + 2][j + 2] == O)) counter++;
                        }
                    }
                    if (i + 2 < crossword.length) {
                        if ((crossword[i + 1][j] == O) && (crossword[i + 2][j] == O)) counter++;
                        if (j - 2 >= 0) {
                            if ((crossword[i + 1][j - 1] == O) && (crossword[i + 2][j - 2] == O)) counter++;
                        }
                    }
                    if (j - 2 >= 0) {
                        if ((crossword[i][j - 1] == O) && (crossword[i][j - 2] == O)) counter++;
                    }
                }
            }
        }
        //System.out.println(counter);
        return counter;
    }

    public static void main( String [] args) throws FileNotFoundException {

        String filename = "moocrypt";
        Scanner sc = new Scanner(new File(filename + ".in"));

        char[][] crossword = new char[sc.nextInt()][sc.nextInt()];

        String row;

        for (int i = 0; i < crossword.length ; i++) {
            row = sc.next();
            for (int j = 0; j < crossword[i].length; j++) {
                crossword[i][j] = row.charAt(j);
            }
        }

        char[] target = new char[2];

        int num = 0;
        int temp = 0;

        for (char a = 'A'; a <= 'Z'; a++) {
            if (a == 'M') continue;
            for (char b = 'A'; b <= 'Z'; b++) {
                if ((b == 'O') || (a == b)) continue;
                target[0] = a;
                target[1] = b;
                num = Math.max(num, Calculate(target, crossword));
            }
        }

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        writer.println(num);
        writer.close();

    }

}