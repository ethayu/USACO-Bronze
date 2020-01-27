package Lesson1;

import java.io.*;
import java.util.*;

public class Paint {

    public static void main(String [] args) throws FileNotFoundException {

        Scanner sc = new Scanner(new File("paint.in"));

        int[] info = new int[4];
        int[] sortedinfo = new int[4];

        for (int i = 0; i < 4; i++) {
            info[i] = sc.nextInt();
            sortedinfo[i] = info[i];
        }

        Arrays.sort(sortedinfo);

        PrintWriter writer = new PrintWriter(new File("paint.out"));

        if (((sortedinfo[1] != info[2]) && (sortedinfo[2] != info[1])) && ((sortedinfo[1] != info[0]) && (sortedinfo[2] != info[3]))) {
            writer.println(sortedinfo[2] - sortedinfo[0] - (sortedinfo[2] - sortedinfo[1]) + sortedinfo[3] - sortedinfo[2]);
        } else {
            writer.println(sortedinfo[2] - sortedinfo[0] - (sortedinfo[2] - sortedinfo[1]) + sortedinfo[3] - sortedinfo[1]);
        }

        /**if ((info[0] < info[2]) && (info[1] > info[3])) {
            writer.println(info[1] - info[0]);
        } else if ((info[2] < info[0]) && (info[3] > info[1])) {
            writer.println(info[3] - info[2]);
        } else if ((info[0] > info[3]) || (info[1] < info[2])) {
            writer.println(info[1] - info[0] + info[3] - info[2]);
        } else if (info[1] > info[3]) {
            writer.println(info[1] - info[2]);
        } else {
            writer.println(info[3] - info[0]);
        }**/

       writer.close();

    }

}
