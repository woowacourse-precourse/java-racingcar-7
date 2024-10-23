package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {

    private static final String EXECUTION_RESULT_MESSAGE = "실행 결과";
    private static final String CAR_MOVE = "%s : %s";

    public static void printExecutionResultMessage() {
        System.out.println(EXECUTION_RESULT_MESSAGE);
    }

    public static void printCarMove(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(String.format(CAR_MOVE, car.getName(), "-".repeat(car.getPosition())));
        }
    }
}
