import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;
// Miguel Fernandez Brazon
// 4/19/2026
// Module 5.2 Programming Assignment
public class WordSorter {

    // Reads all words from the file
    public static Set<String> readWordsFromFile(String filename) {
        Set<String> words = new TreeSet<>(); //sorts ascending

        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNext()) {
                String word = scanner.next().toLowerCase().replaceAll("[^a-zA-Z]", "");
                if (!word.isEmpty()) {
                    words.add(word);
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + filename);
        }

        return words;
    }

    // words ascending order
    public static void displayAscending(Set<String> words) {
        System.out.println("\nAscending Order:");
        for (String word : words) {
            System.out.println(word);
        }
    }

    // words descending order
    public static void displayDescending(Set<String> words) {
        System.out.println("\nDescending Order:");
        List<String> list = new ArrayList<>(words);
        Collections.reverse(list);

        for (String word : list) {
            System.out.println(word);
        }
    }

    //method to verify function
    public static void runTests() {
        System.out.println("Running Test");

        // file loads
        Set<String> testWords = readWordsFromFile("collection_of_words.txt");
        assert testWords != null : "Test Failed";

        //Ensure duplicates removed
        boolean noDuplicates = testWords.size() == new ArrayList<>(testWords).size();
        assert noDuplicates : "Duplicate words encounter";

        // Ensure ascending order is fine
        List<String> ascList = new ArrayList<>(testWords);
        List<String> sortedCopy = new ArrayList<>(ascList);
        Collections.sort(sortedCopy);
        assert ascList.equals(sortedCopy) : "Words not sorted ascending";

        //Ensure descending order is correct
        List<String> descList = new ArrayList<>(testWords);
        Collections.reverse(descList);
        assert descList.get(0).compareTo(descList.get(descList.size() - 1)) > 0 :
                "Descending order incorrect";

        System.out.println("All tests passed");
    }

    public static void main(String[] args) {
        String filename = "collection_of_words.txt";

        // Read words
        Set<String> words = readWordsFromFile(filename);

        // Display
        displayAscending(words);
        displayDescending(words);

        // Run test code
        runTests();
    }
}

