package TryIO;

import java.util.Scanner;

public class TryScanner {
    public static void main(String[] args) {
        // tryHasNext();
        tryHasNextDouble();
    }

    public static void tryHasNext() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input some characters: ");
        while (scan.hasNext()) {
            // hasNext can receive a pattern as an argument. such as "\\d{4}-\\d{2}-\\d{2}"
            System.out.println("What you input is: " + scan.next());
        }
        scan.close();
    }

    public static void tryHasNextDouble() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Please input a score: ");
        if (scan.hasNextDouble()) {
            double score = scan.nextDouble();
            System.out.println("What you input is: " + score);
        } else {
            System.out.println("error: what you input is not a float.");
        }
        scan.close();
    }
}
