package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
    private static final String DISTANCE_SYMBOL = "-";
    private static final String DELIMITER = " : ";
    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String WINNER_NOTICE_MESSAGE = "최종 우승자";

    public static void printExecutionResultMessage() {
        System.out.println();
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public static void printRoundResult(Cars cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + DELIMITER + DISTANCE_SYMBOL.repeat(car.getDistance()));
        }
        System.out.println();
    }

    public static void printWinner(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
        System.out.print(WINNER_NOTICE_MESSAGE + DELIMITER + winnerNames);
    }

}
