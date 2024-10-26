package racingcar.view;

import racingcar.domain.Car;

public class OutputView {
    private static final String OUTPUT_RESULT_MESSAGE = "실행결과";
    private static final String DELIMITER = ", ";

    public void printResultMessage() {
        System.out.println(OUTPUT_RESULT_MESSAGE);
    }

    public void printResult(Car car) {
        System.out.println("car.getName() = " + car.getName());
    }
}
