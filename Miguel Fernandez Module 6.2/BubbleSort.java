/*
 * Module 6
 * Comparator interface
 * Miguel Fernandez
 */

import java.util.Comparator;

public class BubbleSort {

    /**
     * Bubble sort using Comparable
     * @param <E> w
     * @param list w
     */
    public static <E extends Comparable<E>> void bubbleSort(E[] list) {

        boolean swapped = true;

        // Continue looping
        while (swapped) {
            swapped = false;

            for (int i = 0; i < list.length - 1; i++) {

                // compareTo()
                if (list[i].compareTo(list[i + 1]) > 0) {

                    //Swap
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    swapped = true;
                }
            }
        }
    }

    /**
     * Bubble using Comparator
     * @param <E> w
     * @param list w
     * @param comparator w
     */
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {

        boolean swapped = true;

        while (swapped) {
            swapped = false;

            for (int i = 0; i < list.length - 1; i++) {

                // Compare using comparator
                if (comparator.compare(list[i], list[i + 1]) > 0) {

                    // Swap
                    E temp = list[i];
                    list[i] = list[i + 1];
                    list[i + 1] = temp;

                    swapped = true;
                }
            }
        }
    }

    /** print arrays */
    public static <E> void printArray(E[] arr) {
        System.out.print("{ ");
        for (E e : arr) {
            System.out.print(e + " ");
        }
        System.out.println("}");
    }
}
