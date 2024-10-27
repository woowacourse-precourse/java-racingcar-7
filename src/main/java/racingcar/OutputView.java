package racingcar;

import java.util.List;

public class OutputView {

    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
