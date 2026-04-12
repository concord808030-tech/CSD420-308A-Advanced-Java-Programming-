// Miguel Fernandez Brazon
// 4/12/2026
// Module 4.2 Programming Assignment

import java.util.LinkedList;
import java.util.Iterator;

public class LinkedListTiming {

    public static void main(String[] args) {

        System.out.println("Test 50,000 integers");
        TestResult(50000);

        System.out.println("Test 500,000 integers");
        TestResult(500000);
    }

    public static void TestResult(int size) {

        LinkedList<Integer> list = new LinkedList<>();

        // Fill list
        for (int i = 0; i < size; i++) {
            list.add(i);
        }

        //Test 1 Iterator traversal
        long startIterator = System.nanoTime();

        Iterator<Integer> it = list.iterator();
        long sum1 = 0;
        while (it.hasNext()) {
            sum1 += it.next();
        }

        long endIterator = System.nanoTime();
        long iteratorTime = endIterator - startIterator;

        //Test 2 get(index)
        long startGet = System.nanoTime();

        long sum2 = 0;
        for (int i = 0; i < list.size(); i++) {
            sum2 += list.get(i);
        }

        long endGet = System.nanoTime();
        long getTime = endGet - startGet;

        // Output results
        System.out.println("List values: " + size);
        System.out.println("Iterator traversal time: " + iteratorTime + " ns");
        System.out.println("get(index) traversal time: " + getTime + " ns");

        // correctness test
        if (sum1 == sum2) {
            System.out.println("Traversal test PASS sums match");
        } else {
            System.out.println("Traversal test FAILED sums do not match");
        }
    }
}

/*
Transversal iteration is faster because it traverses the LinkedList sequentially
using internal node references get(index) is sluggish for long LinkedLists because
each call must start from the beginning of the list to reach the specified index.
*/
