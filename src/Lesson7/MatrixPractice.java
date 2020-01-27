package Lesson7;

public class MatrixPractice {

    public static void main (String [] args) {

        char[][] chars = new char[4][5];

        char a = 'a';

        for (int i = 0; i < chars.length; i++) {
            for (int c = 0; c < chars[i].length; c++) {
                chars[i][c] = a;
                a++;
            }
        }

        char[] target = {'a', 'b', 'c'};

        int counter = 0;

        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length - target.length + 1; j++) {
                if ((chars[i][j] == target[0]) && (chars[i][j] == target[1]) && (chars[i][j] == target[2])) counter++;
            }
        }

    }

}
