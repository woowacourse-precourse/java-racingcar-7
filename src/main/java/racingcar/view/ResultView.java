package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class ResultView {
    private static final String CAR_POSITION_FORMAT = " : ";
    private static final String POSITION_MARK = "-";
    private static final String WINNER_MESSAGE_PREFIX = "최종 우승자 : ";
    private static final String DELIMITER = ", ";

    private ResultView() {
    }

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + CAR_POSITION_FORMAT + POSITION_MARK.repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        List<String> winnerNames = winners.stream().map(Car::getName).toList();
        System.out.println(WINNER_MESSAGE_PREFIX + String.join(DELIMITER, winnerNames));
    }
}
