package racingcar.view;

import racingcar.model.Car;
import racingcar.message.ViewMessage;

import java.util.List;

public class OutputView {
    public static void printRunResult(List<Car> cars) {
        System.out.println(ViewMessage.RUN_RESULT_MESSAGE);
        for (Car car : cars) {
            printCarRunResult(car);
        }
    }

    public static void printCarRunResult(Car car) {
        System.out.print(car.getName() + " : " + "-".repeat(car.getMove()));
        System.out.println();
    }

    public static void printWinner(List<String> cars) {
        System.out.print(ViewMessage.GET_WINNER_MESSAGE);
        System.out.println(String.join(",", cars));
    }
}