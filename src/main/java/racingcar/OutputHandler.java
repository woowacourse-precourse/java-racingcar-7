package racingcar;

import static racingcar.OutputMessage.*;

import java.util.List;

public class OutputHandler {
    public void printResultMessage() {
        System.out.println();
        System.out.println(RESULT_MESSAGE.getMessage());
    }

    public void printRoundResult(List<String> results) {
        results.forEach(System.out::println);
        System.out.println();
    }

    public void printWinner(List<String> winners) {
        System.out.println(WINNER_NOTICE_PREFIX.getMessage() + String.join(", ", winners));
    }
}
