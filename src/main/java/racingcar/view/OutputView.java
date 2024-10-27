package racingcar.view;

import racingcar.domain.Car;
import racingcar.domain.Cars;

public class OutputView {

    private static final String POSITION_POINT = "-";

    public static void renderCars(Cars cars) {
        for (Car car : cars) {
            System.out.printf("%s : %s\n", car.name(), POSITION_POINT.repeat(car.position()));
        }
    }
}
