/*
 * Test program for BubbleSort
 */

import java.util.Comparator;

public class TestBubbleSort {

    public static void main(String[] args) {


        //Integer sorting (Comparable)

        Integer[] numbers = {5, 3, 9, 1, 4, 2};

        System.out.println("Original Integer :");
        BubbleSort.printArray(numbers);

        BubbleSort.bubbleSort(numbers);

        System.out.println("Sorted using Comparable:");
        BubbleSort.printArray(numbers);



        //String sorting (Comparable)

        String[] words = {"calabaza", "dos", "bravo", "alpha"};

        System.out.println("\nOriginal String:");
        BubbleSort.printArray(words);

        BubbleSort.bubbleSort(words);

        System.out.println("Sorted using Comparable:");
        BubbleSort.printArray(words);



        //sorting using Comparator

        Person[] people = {
            new Person("MI", 32),
            new Person("AL", 25),
            new Person("KA", 50)
        };

        System.out.println("\nOriginal  array:");
        BubbleSort.printArray(people);

        // Sort by age
        Comparator<Person> byAge = (p1, p2) -> Integer.compare(p1.age, p2.age);

        BubbleSort.bubbleSort(people, byAge);

        System.out.println("Sorted by age");
        BubbleSort.printArray(people);
    }
}

/* Comparator testing */
class Person {
    String name;
    int age;

    Person(String n, int a) {
        name = n;
        age = a;
    }

    public String toString() {
        return name + " (" + age + ")";
    }
}
