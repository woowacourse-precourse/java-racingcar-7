package racingcar;

import java.util.List;

public class OutputView {
    public static void printRoundResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}