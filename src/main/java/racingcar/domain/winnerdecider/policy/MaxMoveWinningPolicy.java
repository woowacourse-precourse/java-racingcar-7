package racingcar.domain.winnerdecider.policy;

import java.util.List;
import racingcar.domain.Car;

public class MaxMoveWinningPolicy implements WinningPolicy {

    @Override
    public List<Car> determineWinners(List<Car> cars) {
        final int maxMoveCount = getMaxMoveCount(cars);
        return cars.stream()
                .filter(car -> car.getMoveCount() == maxMoveCount)
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
