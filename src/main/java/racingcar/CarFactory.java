package racingcar;

import racingcar.car.Car;
import racingcar.car.CarImpl;
import racingcar.car.CarUpdater;
import racingcar.decider.Decider;
import racingcar.observer.ExecutionResultOutputObserver;
import racingcar.observer.Observer;

public class CarFactory {
    static Car of(String carName, Decider decider) {
        CarImpl car = new CarImpl(carName);
        CarUpdater carUpdater = new CarUpdater(car, decider);
        Observer executionObserver = ExecutionResultOutputObserver.stdOutput(car);
        carUpdater.append(executionObserver);
        return carUpdater;
    }
}
