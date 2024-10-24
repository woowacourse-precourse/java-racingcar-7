package racingcar.model.judge;

import java.util.List;
import racingcar.common.ErrorMessage;
import racingcar.model.car.Cars;

public class WinnerFinder {
    private final Cars cars;

    public WinnerFinder(final Cars cars) {
        this.cars = cars;
    }

    public List<String> find() {
        final int maxDistance = findMaxMovingDistance();
        return cars.getCars().stream()
                .filter(car -> car.getPosition().calculateMovingDistance() == maxDistance)
                .map(Car -> Car.getName().getCarName())
                .toList();
    }

    private int findMaxMovingDistance() {
        return cars.getCars().stream()
                .mapToInt(car -> car.getPosition().calculateMovingDistance())
                .max()
                .orElseThrow(() -> new IllegalArgumentException(ErrorMessage.CAN_NOT_CALCULATE_DISTANCE.getMessage()));
    }
}
