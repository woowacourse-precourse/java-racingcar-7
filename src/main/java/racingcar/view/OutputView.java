package racingcar.view;

import racingcar.model.Car;

import java.util.List;

import static racingcar.util.OutputMessageConstant.*;

public class OutputView {

    public void carRegistMessage() {
        System.out.println(INPUT_CAR_NAME.getMessage());
    }

    public void newline() {
        System.out.println();
    }

    public void countRegistMessage() {
        System.out.println(INPUT_TURN_COUNT.getMessage());
    }

    public void executionMessage() {
        System.out.println(EXECUTION_RESULT.getMessage());
    }

    public void printResult(List<Car> cars) {
        cars.forEach(System.out::println);
    }

    public void finalWinnerMessage(List<Car> winners) {
        System.out.print(FINAL_WINNER.getMessage());
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).getName());
            if(i + 1 < winners.size()) {
                System.out.print(", ");
            }
        }
    }
}
