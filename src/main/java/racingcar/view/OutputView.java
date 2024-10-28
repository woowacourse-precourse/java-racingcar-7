package racingcar.view;

import static racingcar.view.Message.CAR_NAME_MESSAGE;
import static racingcar.view.Message.COUNT_MESSAGE;
import static racingcar.view.Message.FINAL_WINNER_MESSAGE;
import static racingcar.view.Message.ROUND_RESULT_MESSAGE;

import java.util.List;
import racingcar.Entity.Car;

public class OutputView {

    public static void printEnterCarNames() {
        System.out.println(CAR_NAME_MESSAGE);
    }

    public static void printEnterMoveCount() {
        System.out.println(COUNT_MESSAGE);
    }

    public static void printGameResult(List<List<Car>> history) {
        System.out.println(ROUND_RESULT_MESSAGE);

        for (List<Car> round : history) {
            for (Car car : round) {
                System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()) + " ");
            }
            System.out.println();
        }
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = String.join(", ", winners.stream().map(Car::getName).toList());
        System.out.println(FINAL_WINNER_MESSAGE + winnerNames);
    }

    public static void printError(String message) {
        System.out.println(message);
    }
}
