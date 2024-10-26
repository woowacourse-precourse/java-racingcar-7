package racingcar.view;

import racingcar.domain.Car;

public class OutputView {
    private static final String OUTPUT_RESULT_MESSAGE = "\n실행결과";
    private static final String OUTPUT_RESULT = "%s : %s\n";
    private static final String OUTPUT_MOVE_COUNT = "-";
    private static final String DELIMITER = ", ";

    public void printResultMessage() {
        System.out.println(OUTPUT_RESULT_MESSAGE);
    }

    public void printNewLine() {
        System.out.println();
    }

    public void printResult(Car car) {
        final String carName = car.getName();
        final String moveCount = OUTPUT_MOVE_COUNT.repeat(car.getMoveCount());
        System.out.printf(OUTPUT_RESULT, carName, moveCount);
    }
}
