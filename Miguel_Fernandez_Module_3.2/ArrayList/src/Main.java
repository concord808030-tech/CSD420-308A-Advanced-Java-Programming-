import java.util.ArrayList;
import java.util.Random;

public class Main {

    /**
     * Miguel Fernandez
     * 4/12/2026
     * Module 3.2
     * Returns a new ArrayList containing all unique values from the original list
     *
     */
    public static <E> ArrayList<E> removeDuplicates(ArrayList<E> list) {
        ArrayList<E> uniqueList = new ArrayList<>();

        for (E element : list) {
            if (!uniqueList.contains(element)) {
                uniqueList.add(element);
            }
        }

        return uniqueList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> primary = new ArrayList<>();
        Random rand = new Random();

        // Fill 50 random integers
        for (int i = 0; i < 50; i++) {
            primary.add(rand.nextInt(20) + 1);
        }

        ArrayList<Integer> unique = removeDuplicates(primary);

        // Show Results
        System.out.println("Remove Dupes\n");

        System.out.println("Original ArrayList (" + primary.size() + " elements):");
        System.out.println(primary);

        System.out.println("\nAfter deleteDuplicates (" + unique.size() + " elements):");
        System.out.println(unique);

        System.out.println("\nDuplicates delete: " + (primary.size() - unique.size()));
    }
}
