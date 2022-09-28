package Stage2;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameLog {
    private static final int secret_num = 9305;

    public GameLog() {
    }

    public static void newTurn(int guess) {
        char[] secretNum = String.valueOf(secret_num).toCharArray();
        char[] guessNum = String.valueOf(guess).toCharArray();
        int cntBull = 0;
        int cntCow = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (secretNum[i] == guessNum[j]) {
                    if (i == j) {
                        ++cntBull;
                    } else {
                        ++cntCow;
                    }
                    guessNum[j] = '-';
                    break;
                }
            }
        }
        formatStage2(cntBull, cntCow);
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

    public static void formatStage2(int cntBull, int cntCow) {
        System.out.print("Grade: ");
        if (cntBull > 0) {
            System.out.printf("%d bull(s)", cntBull);
        }

        if (cntBull % 4 != 0 && cntCow > 0) {
            System.out.print(" and ");
        }

        if (cntCow > 0) {
            System.out.printf("%d cow(s)", cntCow);
        }

        if (cntBull == 0 && cntCow == 0) {
            System.out.print("None");
        }

        System.out.printf(". The secret code is %d.", secret_num);
    }
}
