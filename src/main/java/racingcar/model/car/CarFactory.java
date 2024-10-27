package racingcar.model.car;

import racingcar.model.movement.Movement;

import java.util.ArrayList;
import java.util.List;

import static racingcar.common.Error.NOT_EMPTY_CAR_LIST;

public class CarFactory {
    private final Movement movement;

    public CarFactory(Movement movement) {
        this.movement = movement;
    }

    public List<Car> produceCars(List<String> carNames) {
        validateEmptyList(carNames);

        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            cars.add(Car.of(carName, movement));
        }
        return cars;
    }

    private void validateEmptyList(List<String> carNames) {
        if (carNames.isEmpty()) {
            throw new IllegalArgumentException(NOT_EMPTY_CAR_LIST.getMessage());
        }
    }
}
