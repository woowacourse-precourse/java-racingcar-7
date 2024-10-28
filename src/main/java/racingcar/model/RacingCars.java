package racingcar.model;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import racingcar.message.ErrorMessage;
import racingcar.exception.CarNameException;
import racingcar.util.MoveStrategy;

public class RacingCars implements Cars {
    private final MoveStrategy moveStrategy;
    private final Collection<Car> cars;

    public RacingCars(Collection<Car> cars, MoveStrategy moveStrategy) {
        validateEmpty(cars);
        validateDuplicateNames(cars);
        this.cars = cars;
        this.moveStrategy = moveStrategy;
    }

    @Override
    public void moveCars() {
        cars.stream()
                .filter(car -> moveStrategy.isMovable())
                .forEach(Car::moveForward);
    }

    @Override
    public Collection<Car> getCars() {
        return cars;
    }

    private void validateEmpty(Collection<Car> cars) {
        Optional.ofNullable(cars)
                .filter(c -> !c.isEmpty())
                .orElseThrow(() -> new CarNameException(ErrorMessage.CAR_NAME_IS_EMPTY.getMessage()));
    }

    private void validateDuplicateNames(Collection<Car> cars) {
        Set<String> carNames = new HashSet<>();
        cars.stream()
                .map(Car::getName)
                .forEach(name -> validateUniqueName(name, carNames));
    }

    private void validateUniqueName(String name, Set<String> carNames) {
        Optional.of(name)
                .filter(carNames::add)
                .orElseThrow(() -> new CarNameException(ErrorMessage.CAR_NAME_IS_DUPLICATED.getMessage()));
    }
}
