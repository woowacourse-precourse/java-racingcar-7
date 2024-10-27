package racingcar;

import java.util.List;

public class Judge {

    public List<Car> getWinners(List<Car> cars) {
        final long maxMoveCount = cars.stream()
                .mapToLong(Car::getMoveCount).max().orElse(0);

        return cars.stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
                .toList();
    }
}
