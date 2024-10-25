package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Racing {

    public String findWinner(List<Car> cars) {
        int maxMovedDistance = findMaxMovedDistance(cars);
        return cars.stream()
                .filter(car -> car.getMovedDistance() == maxMovedDistance)
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

    private int findMaxMovedDistance(List<Car> cars) {
        int maxMovedDistance = 0;
        for (Car car : cars) {
            if (car.getMovedDistance() > maxMovedDistance) {
                maxMovedDistance = car.getMovedDistance();
            }
        }
        return maxMovedDistance;
    }

}
