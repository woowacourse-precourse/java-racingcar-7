package racingcar;

import racingcar.car.Car;
import racingcar.car.CarImpl;
import racingcar.car.CarUpdater;
import racingcar.decider.Decider;

public class CarFactory {
    static Car of(String carName, Decider decider) {
        CarImpl car = new CarImpl(carName);
        return new CarUpdater(car, decider);
    }
}
