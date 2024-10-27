package racingcar.domain;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

    public String toStringCarsPosition() {
        StringBuilder positions = new StringBuilder();
        for (Car car : cars) {
            positions.append(String.format("%s : %s%n", car.getName(), "-".repeat(car.getDistance())));
        }
        return positions.toString();
    }


    public List<Car> findWinners() {
        int maxDistance = findMaxDistance();

        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .collect(Collectors.toList());
    }

    private int findMaxDistance() {
        int maxDistance = Integer.MIN_VALUE;
        for (Car car : cars) {
            maxDistance = Math.max(maxDistance, car.getDistance());
        }
        return maxDistance;
    }
}
