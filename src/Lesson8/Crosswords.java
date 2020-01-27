package Lesson8;

import java.io.*;
import java.util.*;

public class Crosswords {

    public static void main( String [] args) throws FileNotFoundException {

        String filename = "crosswords";
        Scanner sc = new Scanner(new File(filename + ".in"));

        char[][] crossword = new char[sc.nextInt()][sc.nextInt()];

        String row;

        for (int i = 0; i < crossword.length; i++) {
            row = sc.next();
            for (int j = 0; j < crossword[i].length; j++) {
                crossword[i][j] = row.charAt(j);
            }
        }

        ArrayList<Integer> clues = new ArrayList<>();

        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[i].length; j++) {
                if (crossword[i][j] == '#') continue;
                if (i == 0) {
                    try {
                        if ((crossword[i][j - 1] == '#') && (crossword[i][j + 1] == '.') && (crossword[i][j + 2] == '.')) {
                            clues.add(i + 1);
                            clues.add(j + 1);
                            continue;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {}
                    try {
                        if ((crossword[i + 1][j] == '.') && (crossword[i + 2][j] == '.')) {
                            clues.add(i + 1);
                            clues.add(j + 1);
                            continue;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {}
                }
                if (j == 0) {
                    try {
                        if ((crossword[i][j + 1] == '.') && (crossword[i][j + 2] == '.')) {
                            clues.add(i + 1);
                            clues.add(j + 1);
                            continue;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {}
                    try {
                        if ((crossword[i - 1][j] == '#') && (crossword[i + 1][j] == '.') && (crossword[i + 2][j] == '.')) {
                            clues.add(i + 1);
                            clues.add(j + 1);
                            continue;
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {}
                }
                try {
                    if ((crossword[i][j - 1] == '#') && (crossword[i][j + 1] == '.') && (crossword[i][j + 2] == '.')) {
                        clues.add(i + 1);
                        clues.add(j + 1);
                        continue;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {}
                try {
                    if ((crossword[i - 1][j] == '#') && (crossword[i + 1][j] == '.') && (crossword[i + 2][j] == '.')) {
                        clues.add(i + 1);
                        clues.add(j + 1);
                        continue;
                    }
                } catch (ArrayIndexOutOfBoundsException e) {}
            }
        }

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        writer.println((int)clues.size()/2);
        for (int i = 0; i < (int)clues.size()/2; i++) {
            writer.print(clues.get(i*2) + " ");
            writer.print(clues.get(i*2+1));
            writer.println();
        }
        writer.close();

    }

}