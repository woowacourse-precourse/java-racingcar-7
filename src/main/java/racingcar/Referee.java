package racingcar;

import java.util.List;

public class Referee {

    public List<Car> getWinningCars(final List<Car> cars) {
        final int maxPosition = getCarMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .toList();
    }

    private int getCarMaxPosition(final List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
    }
}
