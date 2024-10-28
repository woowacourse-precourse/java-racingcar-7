package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {
    private static final String EXECUTION_RESULTS = "실행 결과";

    public static void executionResult() {
        System.out.println();
        System.out.println(EXECUTION_RESULTS);
    }

    public static void RoundResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
