package racingcar.util;

import java.util.List;

public abstract class CustomStringUtils {

    public static void printStringLineFeed(String str) {
        System.out.print(str.concat("\n"));
    }

    public static void printFinalWinners(List<String> winners) {
        String winner = String.join(", ", winners);
        System.out.print(ConstantVariable.FINAL_WINNER.value().concat(winner).concat("\n"));
    }
}
