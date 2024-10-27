package racingcar.view;

import static racingcar.message.OutputMessage.*;

import java.util.Map;

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



    public static void printAnnounceWinner() {
        System.out.println(ANNOUNCE_WINNER.getMessage());
    }

}
