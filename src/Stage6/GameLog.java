package bullscows;

import java.util.Arrays;
import java.util.List;

public class GameLog {
    private static StringBuilder secret_num;

    public static boolean acceptLength(int length, int noOfSymbol) {
        secret_num = generateRandomNumber(length, noOfSymbol);
        if (secret_num == null) {
            return true;
        }
        System.out.print("The secret is prepared: " + "*".repeat(length)
                + " (0-9, ");
        if (noOfSymbol - 10 == 0) {
            System.out.println("a).");
        } else {
            System.out.print("a-" + (char) (96 + (noOfSymbol - 10)) + ").\n");
        }
        return false;
    }

    public static boolean newTurn(String guess) {
        char[] secretNum = String.valueOf(secret_num).toCharArray();
        char[] guessNum = guess.toCharArray();
        int cntBull = 0;
        int cntCow = 0;
        for (int i = 0; i < secretNum.length; i++) {
            if (secretNum[i] == guessNum[i]) {
                ++cntBull;
                guessNum[i] = '-';
            }
            for (int j = 0; j < guessNum.length; j++) {
                if (secretNum[i] == guessNum[j]) {
                    if (i == j) {
                        ++cntCow;
                    }
                    guessNum[j] = '-';
                    break;
                }
            }
        }
        return calBullCow(secretNum.length, cntBull, cntCow);
    }

    public static void formatStage1() {
        System.out.println("""
                The secret code is prepared: ****.
                                
                Turn 1. Answer:
                1234
                Grade: None.
                                
                Turn 2. Answer:
                9876
                Grade: 4 bulls.
                Congrats! The secret code is 9876.
                """);
    }

    public static boolean calBullCow(int lengthSecretNum, int cntBull, int cntCow) {
        System.out.print("Grade: ");
        if (cntBull > 0) {
            System.out.printf("%d bull", cntBull);
            if (cntBull > 1) System.out.print("s");
        }

        if (cntBull % 4 != 0 && cntCow > 0) {
            System.out.print(" and ");
        }

        if (cntCow > 0) {
            System.out.printf("%d cow", cntCow);
            if (cntBull > 1) System.out.print("s");
        }

        if (cntBull == 0 && cntCow == 0) {
            System.out.print("None.");
        }
        System.out.println();
        if (cntBull == lengthSecretNum) {
            System.out.print("Congratulations! You guessed the secret code.");
            return true;
        }
        return false;
    }

    public static StringBuilder generateRandomNumber(int length, int noOfSymbol) {
        if (length > 36) {
            System.out.println("Error: can't generate a secret number with a length " +
                    "of 11 because there aren't enough unique digits.");
            return null;
        } else {
            StringBuilder generateNum;
            String letter = "0123456789abcdefghijklmnopqrstuvwxyz";
            do {
                generateNum = new StringBuilder();
                for (int i = 0; i < length; ++i) {
                    generateNum.append(letter.charAt((int) (Math.random() * 10) % noOfSymbol));
                }
            } while (!checkUnique(generateNum));
            return generateNum;
        }
    }

    private static boolean checkUnique(StringBuilder num) {
        String number = String.valueOf(num);
        List<String> arr = Arrays.stream(number.split("")).distinct().toList();
        return arr.size() == number.length();
    }
}
