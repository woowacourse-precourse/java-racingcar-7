package racingcar;

import java.util.List;

public class WinnersDecider {

    public List<Car> run(final List<Car> cars) {
        final int maxMoveCount = getMaxMoveCount(cars);

        return cars.stream()
                .filter((car) -> car.getMoveCount() == maxMoveCount)
                .toList();
    }

    private int getMaxMoveCount(final List<Car> cars) {
        int maxMoveCount = 0;
        for (Car car : cars) {
            maxMoveCount = Math.max(maxMoveCount, car.getMoveCount());
        }

        return maxMoveCount;
    }

}
