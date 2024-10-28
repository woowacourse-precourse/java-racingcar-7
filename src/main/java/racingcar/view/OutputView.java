package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class OutputView {

    private static final String RESULT_START_MESSAGE = "실행 결과";
    private static final String WINNERS_PREFIX = "최종 우승자 : ";
    private static final String CAR_INFIX = " : ";
    private static final String CAR_DELIMITER = ", ";
    private static final String POSITION_CHARACTER = "-";

    public void noticeResult() {
        System.out.println(RESULT_START_MESSAGE);
    }

    public void printStatusOf(List<Car> cars) {
        for (Car car : cars) {
            printStatusOf(car);
        }
        System.out.println();
    }

    private void printStatusOf(Car car) {
        int fromZeroToPosition = car.getPosition();
        String progress = POSITION_CHARACTER.repeat(fromZeroToPosition);
        System.out.println(car.getName() + CAR_INFIX + progress);
    }

    public void printWinners(List<Car> winners) {
        System.out.println(WINNERS_PREFIX + joinNamesOf(winners));
    }

    private String joinNamesOf(List<Car> cars) {
        return cars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(CAR_DELIMITER));
    }
}
