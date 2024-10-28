package racingcar.view;

import static racingcar.util.constant.OutputMessageConstant.*;

import java.util.List;

import racingcar.model.Cars;

public class OutputView {

    public void newline() {
        System.out.println();
    }

    public void executionResultMessage() {
        System.out.println(EXECUTION_RESULT.getMessage());
    }

    public void printResult(Cars cars) {
        cars.carsToString().forEach(System.out::println);
        newline();
    }

    public void finalWinnerMessage(List<String> winners) {
        System.out.print(FINAL_WINNER.getMessage());
        System.out.println(String.join(", ", winners));
    }
}
