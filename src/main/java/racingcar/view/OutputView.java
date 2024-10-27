package racingcar.view;

import static racingcar.message.OutputMessage.ANNOUNCE_WINNER;
import static racingcar.message.OutputMessage.GAME_START;
import static racingcar.message.OutputMessage.PROMPT_CAR_NAMES;
import static racingcar.message.OutputMessage.PROMPT_TRY_COUNT;

import java.util.Map;
import java.util.Set;

public class OutputView {

    public static void printGameStart() {
        System.out.println(PROMPT_CAR_NAMES.getMessage());
    }

    public static void printTryCount() {
        System.out.println(PROMPT_TRY_COUNT.getMessage());
    }

    public static void displayGameStart() {
        System.out.println(GAME_START.getMessage());
    }

    public static void displayGameResult(Map<String, Integer> result) {
        result.forEach((key, value) -> {
            String bar = "-".repeat(Math.max(0, value));
            System.out.println(key + " : " + bar);
        });
        System.out.println();
    }


    public static void printAnnounceWinner(Set<String> cars) {
        System.out.println(ANNOUNCE_WINNER.getMessage() + String.join(", ", cars));
    }

}
