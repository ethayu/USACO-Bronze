package Lesson6;

import java.io.*;
import java.util.*;

public class FindCow {

    /*static class Possibilities {
        int number;
        char leg;
        public Possibilities (int a, char b) {
            number = a;
            leg = b;
        }
    }*/

    public static void main( String [] args) throws FileNotFoundException {

        String filename = "cowfind";
        Scanner sc = new Scanner(new File(filename + ".in"));

        String input = sc.next();

        //Possibilities[] pos = new Possibilities[input.length()];

        int counter = 0;
        int before = 0;
        //char previous = 'a';
        //char current;

        for (int i = 1; i < input.length(); i++) {
            if ((input.charAt(i-1) == '(') && (input.charAt(i) == '(')) before++;
            if ((input.charAt(i-1) == ')') && (input.charAt(i) == ')')) counter += before;
        }

        /*for (int i = 0; i < input.length(); i++) {
            current = input.charAt(i);
            if (i == 0) {
                consecutives++;
                previous = current;
                continue;
            }
            if (i == input.length() - 1) {
                if (input.charAt(i - 1) == current) {
                    if (consecutives == 0) continue;
                    pos[counter] = new Possibilities(consecutives, current);
                    continue;
                }

            }
            if ((input.charAt(i - 1) == current) || (input.charAt(i + 1) == current)) {
                if (current == previous) {
                    consecutives++;
                } else {
                    if (consecutives - 1 != 0) {
                        pos[counter] = new Possibilities(consecutives - 1, current);
                        counter++;
                    }
                }
            } else {
                if (consecutives - 1 != 0) {
                    pos[counter] = new Possibilities(consecutives - 1, previous);
                    counter++;
                }
                consecutives = 1;
            }
            previous = current;
        }


        consecutives = 0;
        for (int i = 0; i <= counter; i++ ) {
            if (pos[i].leg == '(')
            for (int j = i + 1; j <= counter; j++) {
                if (pos[j].leg == ')') consecutives += pos[i].number*pos[j].number;
            }
        }*/

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        writer.println(counter);
        writer.close();

    }

}
