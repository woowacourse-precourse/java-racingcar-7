package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    private static final int BASIC_DISTANCE = 0;
    private static final String WINNER_NAME_DELIMITER = ", ";

    public String find(List<Car> cars) {
        int maxMovedDistance = findMaxMovedDistance(cars);
        return cars.stream()
                .filter(car -> car.getMovedDistance() == maxMovedDistance)
                .map(Car::getName)
                .collect(Collectors.joining(WINNER_NAME_DELIMITER));
    }

    private int findMaxMovedDistance(List<Car> cars) {
        int maxMovedDistance = BASIC_DISTANCE;
        for (Car car : cars) {
            if (car.getMovedDistance() > maxMovedDistance) {
                maxMovedDistance = car.getMovedDistance();
            }
        }
        return maxMovedDistance;
    }

}
