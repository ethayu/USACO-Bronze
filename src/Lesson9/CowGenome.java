package Lesson9;

import java.io.*;
import java.util.*;

public class CowGenome {

    public static void main( String [] args) throws FileNotFoundException {

        String filename = "cownomics";
        Scanner sc = new Scanner(new File(filename + ".in"));

        int n = sc.nextInt();
        int m = sc.nextInt();

        HashSet<Character>[] spotty = new HashSet[m];
        HashSet<Character>[] normal = new HashSet[m];

        for (int i = 0; i < m ; i++) {
            spotty[i] = new HashSet<Character>();
            normal[i] = new HashSet<Character>();
        }

        for (int i = 0; i < n ; i++) {
            String genome = sc.next();
            for (int j = 0; j < m ; j++) {
                spotty[j].add(genome.charAt(j));
            }
        }
        for (int i = 0; i < n ; i++) {
            String genome = sc.next();
            for (int j = 0; j < m ; j++) {
                normal[j].add(genome.charAt(j));
            }
        }

        int counter = 0;

        HashSet<Character> current = new HashSet<>();

        for (int i = 0; i < m; i++) {
            spotty[i].retainAll(normal[i]);
            if (spotty[i].isEmpty()) counter++;
        }


        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        writer.println(counter);
        writer.close();

    }

}