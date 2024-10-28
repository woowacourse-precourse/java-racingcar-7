package racingcar;

import java.util.List;

public class Referee {

    public List<Car> findWinners(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);

        return cars.stream()
                .filter(car -> car.isPositionSameAs(maxPosition))
                .toList();
    }

    private int findMaxPosition(List<Car> cars) {
        int maxPosition = 0;
        for (Car car : cars) {
            maxPosition = Math.max(maxPosition, car.getPosition());
        }

        return maxPosition;
    }

}
