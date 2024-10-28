package racingcar.view;

import racingcar.model.Car;

import java.util.List;

public class OutputView {

    public static void printGameStatus(List<Car> cars) {
        System.out.println("\n실행 결과");
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getPosition()));
        }
        System.out.println();
    }
}
