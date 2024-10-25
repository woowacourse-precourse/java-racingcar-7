package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerFinder {
    public List<String> findWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}