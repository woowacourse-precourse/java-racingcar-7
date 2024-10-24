package racingcar.view;

import java.util.List;
import racingcar.entity.Car;
import racingcar.enums.NotificationMessage;

public class OutputView {
    public static void printRoundResults(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getPositionDisplay());
        }
        System.out.println();
    }

    public void printWinners(List<String> winners) {
        System.out.println(NotificationMessage.FINAL_WINNERS.getMessage() + String.join(", ", winners));
    }
}
