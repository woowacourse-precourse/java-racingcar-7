package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    public void printCurrentStatus(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getDistance()));
        }
        System.out.println();
    }

    public void announceWinners(List<String> winners) {
        System.out.println("우승자: " + String.join(", ", winners));
    }
}
