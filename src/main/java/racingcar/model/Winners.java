package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Winners {
    private static final int MIN_POSITION = 0;

    private final int maxPosition;
    private final List<Car> winners;

    public Winners(List<Car> cars) {
        maxPosition = getMaxPosition(cars);
        winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }

    private int getMaxPosition(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(MIN_POSITION);
    }
}
