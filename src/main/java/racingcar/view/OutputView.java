package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    private static final String OUTPUT_RESULT_MESSAGE = "\n실행결과";
    private static final String OUTPUT_RESULT = "%s : %s\n";
    private static final String OUTPUT_MOVE_COUNT = "-";
    private static final String OUTPUT_WINNERS = "최종 우승자 : %s";
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

    public void printWinners(List<String> winnerNames) {
        final String winners = String.join(DELIMITER, winnerNames);
        System.out.printf(OUTPUT_WINNERS, winners);
    }
}
