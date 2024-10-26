package racingcar.model;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import racingcar.factory.ValidatorFactory;
import racingcar.validation.Validator;

public class Cars {
    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
        Validator<Cars> validator = ValidatorFactory.createCarsValidator();
        validator.validate(this);
    }

    public Cars moveCars() {
        cars.forEach(Car::move);
        return this;
    }

    public List<String> findWinnerNames() {
        int maxMoveDistance = Collections.max(
                cars.stream()
                        .map(Car::getMoveDistance)
                        .collect(Collectors.toList())
        );
        return cars.stream()
                .filter(car -> car.getMoveDistance() == maxMoveDistance)
                .map(Car::getName)
                .collect(Collectors.toList());
    }

    public List<Car> getCars() {
        return cars;
    }
}
