package racingcar.view;

import static racingcar.view.OutputMessage.*;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    public void printResultMessage() {
        System.out.println(RESULT_MESSAGE.getMessage());
    }

    public void printEachStep(List<Car> cars) {
        for (Car car : cars) {
            String position = "-".repeat(car.getDistance());
            System.out.printf(CAR_POSITION.getMessage(), car.getName(), position);
            System.out.println();
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.printf(WINNERS.getMessage(), String.join(", ", winners));
    }
}
