package racingcar.model.car.factory;

import racingcar.model.car.Car;
import racingcar.model.car.strategy.MoveStrategy;

public class CarFactory {
    public static Car createCar(
            String carNames,
            MoveStrategy moveStrategy
    ) {
        return new Car(carNames, moveStrategy);
    }
}
