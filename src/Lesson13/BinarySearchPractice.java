package Lesson13;

import java.util.Arrays;

public class BinarySearchPractice {

    public static void main(String [] args) {

        int[] test = {1, 2, 3, 4, 5};
        Arrays.sort(test);
        System.out.println(Arrays.binarySearch(test,4));
        //if does not exist, will output -IP - 1 instead.

    }

}
