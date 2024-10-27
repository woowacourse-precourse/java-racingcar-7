package racingcar.view;

import racingcar.domain.car.Car;
import racingcar.domain.car.Cars;

public class OutputView {
    public static void printResultPrefix() {
        System.out.println();
        System.out.println("실행 결과");
    }

    public static void printRoundResult(Cars cars) {
        for (Car car : cars.getCars()) {
            System.out.println(car.getStatus());
        }
        System.out.println();
    }
}
