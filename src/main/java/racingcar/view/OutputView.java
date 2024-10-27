package racingcar.view;

import static racingcar.config.GameMessage.GAME_START_MESSAGE;
import static racingcar.config.GameMessage.REQUEST_ATTEMPT_MESSAGE;
import static racingcar.config.GameMessage.RESULT_NOTIFICATION_MESSAGE;
import static racingcar.config.GameMessage.WINNER_NOTIFICATION_MESSAGE;

import java.util.List;
import racingcar.entity.Car;

public class OutputView {
    private OutputView() {
        throw new IllegalStateException("View Class");
    }

    public static void printGameStartMessage() {
        printMessage(GAME_START_MESSAGE);
    }

    public static void printRequestAttemptMessage() {
        printMessage(REQUEST_ATTEMPT_MESSAGE);
    }

    public static void printRacingResultMessage() {
        printMessage(RESULT_NOTIFICATION_MESSAGE);
    }

    public static void printCarPosition(List<Car> carList) {
        for (Car car : carList) {
            printMessage(car.getPositionString());
        }
        printLineBreak();
    }

    public static void printWinnerMessage(String winnerString) {
        StringBuilder winnerMessage = new StringBuilder(WINNER_NOTIFICATION_MESSAGE);
        winnerMessage.append(winnerMessage);
        printMessage(winnerString);
    }

    public static void printLineBreak() {
        System.out.println();
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }
}
