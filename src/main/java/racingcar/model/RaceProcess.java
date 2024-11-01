package racingcar.model;

import java.util.Collection;

import racingcar.util.MoveStrategy;
import racingcar.validation.CarsValidator;

public class RaceProcess {
    private final MoveStrategy moveStrategy;
    private final Collection<Car> cars;

    public RaceProcess(Collection<Car> cars, MoveStrategy moveStrategy, CarsValidator carsValidator) {
        carsValidator.validate(cars);
        this.cars = cars;
        this.moveStrategy = moveStrategy;
    }

    public void moveCars() {
        cars.stream()
                .filter(car -> moveStrategy.isMovable())
                .forEach(Car::moveForward);
    }

    public Collection<Car> getCars() {
        return cars;
    }
}
