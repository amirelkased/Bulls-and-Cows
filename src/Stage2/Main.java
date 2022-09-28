package Stage2;

import java.util.Scanner;

import static Stage2.GameLog.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new GameLog();
        newTurn(scanner.nextInt());
    }
}
