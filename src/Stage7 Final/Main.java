package Stage7 Final;

import java.util.Scanner;
import java.util.regex.Pattern;

import static Stage7 Final.GameLog.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    final static Pattern pattern = Pattern.compile("[^0-9]");

    public static void main(String[] args) {
        if (takeInput()) {
            query();
        }
    }

    private static boolean takeInput() {
        int length;
        int noOfChar;
        do {
            // first i/p
            System.out.println("Input the length of the secret code:");
            String len = scanner.nextLine();
            if (checkInput(len)) {
                System.out.printf("Error: \"%s\" isn't a valid number.", len);
                return false;
            }
            length = Integer.parseInt(len);
            if (length < 1) {
                System.out.println("Error: is not logic!");
                return false;
            }
            // second i/p
            System.out.println("Input the number of possible symbols in the code:");
            String chars = scanner.nextLine();
            if (checkInput(chars)) {
                System.out.printf("Error: \"%s\" isn't a valid number.", chars);
                return false;
            }
            noOfChar = Integer.parseInt(chars);
            // not of chars
            if (noOfChar < length) {
                System.out.printf("Error: it's not possible to generate a code with " +
                        "a length of %d with %d unique symbols.\n", length, noOfChar);
                return false;
            } else if (noOfChar > 36) {
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
                return false;
            }
        } while (acceptLength(length, noOfChar));
        return true;
    }

    private static void query() {
        for (int i = 1; ; i++) {
            System.out.printf("Turn %d:\n", i);
            if (newTurn(scanner.next())) {
                break;
            }
        }
    }

    private static boolean checkInput(String x) {
        return pattern.matcher(x).find();
    }
}
