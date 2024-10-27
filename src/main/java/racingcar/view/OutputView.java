package racingcar.view;

import java.util.List;
import java.util.Map;
import racingcar.constant.SystemMessage;
import racingcar.model.Car;

public class OutputView {
    private void printLineFeed() {
        System.out.println();
    }

    public void printInputCarNamesMessage() {
        System.out.println(SystemMessage.INPUT_CAR_NAMES);
    }

    public void printInputAttemptsMessage() {
        System.out.println(SystemMessage.INPUT_ATTEMPTS);
    }

    public void printResultMessage() {
        printLineFeed();
        System.out.println(SystemMessage.RESULT_PREFIX);
    }

    public void printMovementStates(Map<Car, String> movementStates) {
        movementStates.forEach((racer, moved) -> {
            System.out.println(
                    String.format(SystemMessage.MOVEMENT_STATE_FORMAT, racer.getName(), moved)
            );
        });
        printLineFeed();
    }

    public void printWinners(List<Car> racers) {
        String winners = String.join(
                SystemMessage.WINNER_DELIMITER,
                racers.stream()
                        .map(Car::getName)
                        .toList()
        );

        System.out.println(String.format(SystemMessage.WINNER_RESULT_FORMAT, winners));
    }
}
