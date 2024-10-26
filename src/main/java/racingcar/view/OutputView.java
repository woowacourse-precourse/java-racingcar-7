package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

import static racingcar.view.OutputMessage.*;

public class OutputView {
    public void printResultMessage() {
        System.out.println(RESULT.getMessage());
    }

    public void printEachStep(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(car.getDistance()));
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.printf(WINNERS.getMessage(), String.join(", ", winners));
    }
}
