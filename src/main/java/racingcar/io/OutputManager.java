package racingcar.io;

import static racingcar.io.constant.ErrorMessage.ATTEMPT_COUNT_MESSAGE;
import static racingcar.io.constant.ErrorMessage.WINNER_RESULT_MESSAGE;

import java.util.List;

public class OutputManager {


    private static final String DELIMITER = ", ";

    public static void printWinner(List<String> winnerList) {
        String joinedName = String.join(DELIMITER, winnerList);
        System.out.println(WINNER_RESULT_MESSAGE + joinedName);
    }

    public static void printTryCountMessage() {
        System.out.println(ATTEMPT_COUNT_MESSAGE);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printMessage() {
        System.out.println();
    }
}
