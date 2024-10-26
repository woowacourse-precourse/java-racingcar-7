package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.view.enums.ViewMessages;

public class OutputView {

    public static void attemptsResult() {
        System.out.println();
        System.out.println(ViewMessages.ATTEMPTS_RESULT.getViewMessages());
    }

    public static void eachAttemptsResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(
                    car.getName() + " : " + car.getFinalPosition(car.getPosition()));
        }
        System.out.println();
    }

}
