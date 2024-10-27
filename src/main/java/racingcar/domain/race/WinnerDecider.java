package racingcar.domain.race;

import racingcar.domain.car.Car;

import java.util.Set;
import java.util.stream.Collectors;

public class WinnerDecider {

    public Set<String> getWinners(Set<Car> cars) {
        Integer maxPosition = findMaxPosition(cars);
        return findWinnerNames(cars, maxPosition);
    }

    private Integer findMaxPosition(Set<Car> cars) {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElse(0);
    }

    private Set<String> findWinnerNames(Set<Car> cars, Integer maxPosition) {
        return cars.stream()
                .filter(car -> car.getPosition().equals(maxPosition))
                .map(Car::getName)
                .collect(Collectors.toSet());
    }
}
