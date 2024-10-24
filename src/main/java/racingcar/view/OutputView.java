package racingcar.view;

import racingcar.model.Car;

import java.util.List;

import static racingcar.util.ConstOutputMessage.*;

public class OutputView {

    public void carRegistMessage() {
        System.out.println(INPUT_CAR_NAME);
    }

    public void newline() {
        System.out.println();
    }

    public void countRegistMessage() {
        System.out.println(INPUT_TURN_COUNT);
    }

    public void executionMessage() {
        System.out.println(EXECUTION_RESULT);
    }

    public void printResult(List<Car> cars) {
        cars.forEach(System.out::println);
    }
}
