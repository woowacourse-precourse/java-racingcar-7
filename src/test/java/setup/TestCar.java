package setup;

import racingcar.model.domain.Car;

public class TestCar {

    public static Car getTestCar(String carName) {
        return Car.of(carName);
    }
}
