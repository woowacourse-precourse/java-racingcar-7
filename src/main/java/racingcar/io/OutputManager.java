package racingcar.io;

import static racingcar.io.ErrorMessage.GUIDE_MESSAGE;
import static racingcar.io.ErrorMessage.TRY_COUNT_MESSAGE;
import static racingcar.io.ErrorMessage.WINNER_RESULT_MESSAGE;

import java.util.List;

public class OutputManager {


    private static final String DELIMITER = ", ";

    public static void printGuideMessage() {
        System.out.println(GUIDE_MESSAGE);
    }

    public static void printWinner(List<String> winnerList) {
        String joinedName = String.join(DELIMITER, winnerList);
        System.out.println(WINNER_RESULT_MESSAGE + joinedName);
    }

    public static void printTryCountMessage() {
        System.out.println(TRY_COUNT_MESSAGE);
    }
}
