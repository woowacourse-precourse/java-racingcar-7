package racingcar.view;

import racingcar.model.Car;
import java.util.List;

public class OutputView {
    public void displayRoundResults(List<Car> cars) {
        for (Car car : cars) {
            String position = "-".repeat(car.getPosition());
            System.out.println(car.getName() + " : " + position);
        }
        System.out.println();
    }

    public void displayWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
