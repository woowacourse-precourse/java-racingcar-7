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

    public static void finalWinners() {
        System.out.print(ViewMessages.FINAL_WINNERS.getViewMessages());
    }

    public static void finalWinnersResult(List<Car> cars) {
        for (int i = 0; i < cars.size(); i++) {
            if (i != cars.size() - 1) {
                System.out.print(cars.get(i).getName() + ", ");
            }
            if (i == cars.size() - 1) {
                System.out.print(cars.get(i).getName());
            }
        }
    }

}
