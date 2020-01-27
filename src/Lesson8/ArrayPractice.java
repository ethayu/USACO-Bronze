package Lesson8;

import java.util.*;

public class ArrayPractice {

    public static void main (String [] args) {

        //ArrayList of Integers
        ArrayList <Integer> myList = new ArrayList<> ();
        myList.add(1);
        myList.add(5);

        System.out.println(myList);

        int num = myList.get(0);

        myList.remove(0);
        System.out.println(myList);

        myList.add(0, 5);
        System.out.println(myList);

        myList.remove((Integer) 5);
        System.out.println(myList);

    }

}
