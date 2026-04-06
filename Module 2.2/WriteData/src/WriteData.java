import java.io.*;
import java.util.Random;

/**
 * WriteData.java
 * Generates 5 random integers and 5 random doubles
 * Them append to MiguelFernandez datafile.dat
 */
public class WriteData {

    public static void main(String[] args) {

        String fileName = "MiguelFernandez datafile.dat";
        Random rand = new Random();

        // --- Generate Info ---
        int[]    integers = new int[5];
        double[] doubles  = new double[5];

        for (int i = 0; i < 5; i++) {
            integers[i] = rand.nextInt(1000);          // 0 – 999
            doubles[i]  = Math.round(rand.nextDouble() * 1000.0) / 10.0; // 0.0 – 100.0
        }

        // --- Write / append to file ---

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName, true))) {

            bw.write("=== Entry ===");
            bw.newLine();

            bw.write("Integers");
            bw.newLine();
            for (int value : integers) {
                bw.write("  " + value);
                bw.newLine();
            }

            bw.write("Doubles:");
            bw.newLine();
            for (double value : doubles) {
                bw.write("  " + value);
                bw.newLine();
            }

            bw.newLine(); // blank line between entries

            System.out.println("Data written to \"" + fileName + "\" successfully.");
            System.out.println("\nIntegers written : ");
            for (int v : integers)  System.out.println("  " + v);
            System.out.println("Doubles written  : ");
            for (double v : doubles) System.out.println("  " + v);

        } catch (IOException e) {
            System.err.println("Error writing file: " + e.getMessage());
        }
    }
}
