package bullscows;

import java.util.Scanner;

import static bullscows.GameLog.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int length = 0;
        int noOfChar = 0;
        do {
            System.out.println("Input the length of the secret code:");
            length = scanner.nextInt();
            System.out.println("Input the number of possible symbols in the code:");
            noOfChar = scanner.nextInt();
        } while (acceptLength(length, noOfChar));

        for (int i = 1; ; i++) {
            System.out.printf("Turn %d:\n", i);
            if (newTurn(scanner.next())) {
                break;
            }
        }
    }
}
