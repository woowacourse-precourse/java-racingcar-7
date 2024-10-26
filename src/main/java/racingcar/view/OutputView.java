package racingcar.view;

import static racingcar.common.Constant.CAR_MOVE_SYMBOL;
import static racingcar.common.Constant.DELIMITER;
import static racingcar.common.Constant.OUTPUT_DELIMITER;
import static racingcar.common.Constant.WHITESPACE;
import static racingcar.view.ViewMessage.INPUT_ATTEMPTS;
import static racingcar.view.ViewMessage.INPUT_CAR_NAMES;
import static racingcar.view.ViewMessage.OUTPUT_RESULT;
import static racingcar.view.ViewMessage.OUTPUT_WINNER;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class OutputView {

    private OutputView() {
    }

    public static void printInputCarNames() {
        printMessage(INPUT_CAR_NAMES.getMessage());
    }

    public static void printInputAttempts() {
        printMessage(INPUT_ATTEMPTS.getMessage());
    }

    public static void printResultMessage() {
        printMessage();
        printMessage(OUTPUT_RESULT.getMessage());
    }

    public static void printRacingStage(List<Car> cars) {
        for (Car car : cars) {
            printMessage(getCarMovement(car));
        }
        printMessage();
    }

    public static void printWinner(List<String> winnerNames) {
        printMessage(OUTPUT_WINNER.getMessage() + getWinnerNames(winnerNames));
    }

    private static String getCarMovement(Car car) {
        StringBuilder sb = new StringBuilder(car.getName());
        sb.append(WHITESPACE.getValue()).append(OUTPUT_DELIMITER.getValue()).append(WHITESPACE.getValue());
        for (int distance = 0; distance < car.getDistance(); distance++) {
            sb.append(CAR_MOVE_SYMBOL.getValue());
        }
        return sb.toString();
    }

    private static String getWinnerNames(List<String> winnerNames) {
        if (winnerNames.size() == 1) {
            return winnerNames.getFirst();
        }

        return winnerNames.stream()
                .collect(Collectors.joining(DELIMITER.getValue() + WHITESPACE.getValue()));
    }

    private static void printMessage() {
        System.out.println();
    }

    private static void printMessage(String message) {
        System.out.println(message);
    }

}
