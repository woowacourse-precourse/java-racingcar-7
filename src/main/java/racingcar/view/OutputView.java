package racingcar.view;

import java.util.List;
import racingcar.entity.Car;

public class OutputView {
    public static void printRoundResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPositionDisplay());
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
