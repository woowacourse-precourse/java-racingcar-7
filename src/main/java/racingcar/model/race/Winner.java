package racingcar.model.race;

import java.util.List;
import racingcar.common.ErrorMessage;
import racingcar.model.car.Car;
import racingcar.model.car.Cars;

public class Winner {
    private final Cars cars;

    public Winner(final Cars cars) {
        this.cars = cars;
    }

    public List<String> find() {
        final int maxDistance = findMaxMovingDistance();
        return cars.getCars().stream()
                .filter(car -> car.getPosition().calculateMovingDistance() == maxDistance)
                .map(Car::getName)
                .toList();
    }

    private int findMaxMovingDistance() {
        return cars.getCars().stream()
                .mapToInt(car -> car.getPosition().calculateMovingDistance())
                .max()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.CAN_NOT_CALCULATE_DISTANCE.getMessage()));
    }
}
