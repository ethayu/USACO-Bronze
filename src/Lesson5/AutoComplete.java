package Lesson5;

import java.io.*;
import java.util.*;

public class AutoComplete {

    static class Words implements Comparable <Words>{

        Integer number;
        String word;
        int index;
        private Words (Integer a, String word, int n) {
            if (a != null) number = a;
            this.word = word;
            index = n;
        }
        public int compareTo (Words a) {
            return word.compareTo(a.word);
        }
    }

    public static void main( String [] args) throws FileNotFoundException {

        String filename = "auto";
        Scanner sc = new Scanner( new File ( filename + ".in"));

        int n = sc.nextInt();
        int k = sc.nextInt();

        Words[] dictionary = new Words[n];

        for (int i = 0; i < n; i++) {
            dictionary[i] = new Words(null, sc.next(), i+1);
        }

        Arrays.sort(dictionary);

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));

        Words[] input = new Words[k];

        for (int i = 0; i < k; i++) {
            input[i] = new Words(sc.nextInt(), sc.next(), i+1);
        }

        Arrays.sort(input);

        int start = 0;
        int first = input[0].word.length();
        int firstindex = 0;
        int current;
        int number;

        for (int counter = 0; counter < k; counter++) {
            current = input[counter].word.length();
            for (start = firstindex; start < n; start++) {
                if (start < 0) start = 0;
                if (dictionary[start].word.startsWith(input[counter].word)) break;
            }
            if (current < first) firstindex = counter;

            number = input[counter].number;

            if (start + number - 1 >= n) {
                input[counter].number = -1;
            } else if (!dictionary[start + number - 1].word.startsWith(input[counter].word)) {
                input[counter].number = -1;
            } else {
                input[counter].number = dictionary[start + (number - 1)].index;
            }
        }

        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (input[j].index == i +1) writer.println(input[j].number);
            }
        }

        writer.close();

    }

}
