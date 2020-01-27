package Lesson12;

import java.io.*;
import java.util.*;

public class SecretCode {

    static int decrypt (String code) {
        int counter = 0;
        if ((code.length() % 2) == 0) {
            return 0;
        } else {
            if (code.substring(0, code.length() / 2 + 1).startsWith(code.substring((code.length() / 2 + 1), code.length()))) {
                counter += 1 + decrypt(code.substring(0, code.length() / 2 + 1));
            }
            if (code.substring(0, code.length() / 2 + 1).endsWith(code.substring((code.length() / 2 + 1), code.length()))) {
                counter += 1 + decrypt(code.substring(0, code.length() / 2 + 1));
            }
            if (code.substring(code.length() / 2).startsWith(code.substring(0, code.length() / 2))) {
                counter += 1 + decrypt(code.substring(code.length() / 2));
            }
            if (code.substring(code.length() / 2).endsWith(code.substring(0, code.length() / 2))) {
                counter += 1 + decrypt(code.substring(code.length() / 2));
            }
        }
        return counter;
    }

    public static void main (String [] args) throws FileNotFoundException {

        String filename = "scode";
        Scanner sc = new Scanner(new File(filename + ".in"));

        PrintWriter writer = new PrintWriter(new File(filename + ".out"));
        writer.println(decrypt(sc.next()));
        writer.close();

    }

}
