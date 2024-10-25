package racingcar.domain;

import racingcar.util.Util;

import java.util.List;

import static racingcar.view.OutputView.*;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public void moveCars() {
        for (Car car : cars) {
            boolean canGo = Util.isCanGo();
            if (canGo) {
                car.move();
            }
            printCarStatus(car);
        }
        lineSeparator();
    }


}
