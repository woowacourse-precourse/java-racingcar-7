package racingcar.view;

import racingcar.constants.MessageConstants;
import racingcar.model.component.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    public static void requestCarNames() {
        System.out.print(MessageConstants.INPUT_CAR_NAMES);
    }

    public static void requestAttemptCount() {
        System.out.print(MessageConstants.INPUT_ATTEMPT_COUNT);
    }

    public static void printExecutionResult() {
        System.out.print(MessageConstants.EXECUTION_RESULT);
    }

    public static void printCurrentStatus(List<Car> cars) {
        for(Car car : cars) {
            System.out.println(String.format(MessageConstants.PLAYER_POSITION_FORMAT, car.getName())
                    + MessageConstants.DASH.repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        System.out.print(MessageConstants.FINAL_WINNER);
        System.out.println(winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", ")));
    }

}
