package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String CAR_MOVE = "%s : %s";
    private static final String FINAL_WINNER_MESSAGE = "최종 우승자 : %s";

    public static void printExecutionResultMessage() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public static void printCarMove(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(String.format(CAR_MOVE, car.getName(), "-".repeat(car.getPosition())));
        }
    }

    public static void printFinalWinners(List<Car> winners) {
        String winnerString = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));

        System.out.println(String.format(FINAL_WINNER_MESSAGE, winnerString));
    }
}
