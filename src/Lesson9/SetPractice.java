package Lesson9;
import java.util.*;


public class SetPractice {

    public static void main (String [] args) {

        ArrayList<Integer> aList = new ArrayList<>();

        HashSet<Integer> hSet = new HashSet<>();

        hSet.add (3);
        hSet.add (3);

        for (int eachNum : hSet) {
            System.out.println(eachNum);
        }


    }

}
