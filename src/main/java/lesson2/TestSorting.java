package lesson2;

import java.util.Comparator;
import java.util.Random;

public class TestSorting {
    public static void main(String[] args) {
        Random rnd = new Random();
        int capacity = 100000;
        MyArrayList<Integer> myArrSelectionSort = new MyArrayList<>(capacity, Comparator.naturalOrder());

        for (int i = 0; i < capacity; i++) {
            myArrSelectionSort.add(rnd.nextInt(100000) + i);
        }
//        System.out.println(myArrSelectionSort);
        MyArrayList<Integer> myArrBubbleSort = myArrSelectionSort.clone();
        MyArrayList<Integer> myArrInsertionSort = myArrSelectionSort.clone();

        long begin, end;
        begin = System.currentTimeMillis();
        myArrSelectionSort.selectionSort();
        end = System.currentTimeMillis();
        System.out.println("selection sort: " + (end - begin));

        begin = System.currentTimeMillis();
        myArrBubbleSort.bubbleSort();
        end = System.currentTimeMillis();
        System.out.println("bubble sort: " + (end - begin));

        begin = System.currentTimeMillis();
        myArrInsertionSort.insertionSort();
        end = System.currentTimeMillis();
        System.out.println("insertion sort: " + (end - begin));

//        System.out.println(myArrSelectionSort);
//        System.out.println(myArrBubbleSort);

    }
}
