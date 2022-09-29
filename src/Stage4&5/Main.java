package bullscows;

import java.util.Scanner;

import static bullscows.GameLog.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Please, enter the secret code's length:");
        while (acceptLength(scanner.nextInt())) ;
        for (int i = 1; ; i++) {
            System.out.printf("Turn %d:\n", i);
            if (newTurn(scanner.next())) {
                break;
            }
        }
    }
}
