//Miguel Fernandez
// 5/3/2026
//Module 8.2

public class MiguelThreeThreads {

    public static void main(String[] args) {

        // Thread 1
        Thread letters = new Thread(() -> {
            while (true) {
                char c = (char) ('a' + (int)(Math.random() * 28));
                System.out.print(c);
                sleep();
            }
        });

        // Thread 2
        Thread numbers = new Thread(() -> {
            while (true) {
                char n = (char) ('0' + (int)(Math.random() * 10));
                System.out.print(n);
                sleep();
            }
        });

        // Thread 3
        Thread symbols = new Thread(() -> {
            char[] sym = {'&', '/', '#', '$', '%', ']', '*', '?'};
            while (true) {
                char s = sym[(int)(Math.random() * sym.length)];
                System.out.print(s);
                sleep();
            }
        });

        letters.start();
        numbers.start();
        symbols.start();
    }

    //sleep method
    private static void sleep() {
        try {
            Thread.sleep(150);
        } catch (Exception e) {}
    }
}

