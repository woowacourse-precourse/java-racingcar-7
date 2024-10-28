package racingcar.service;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.domain.Car;

public class WinnerService {

    public String calculateWinners(List<Car> cars) {
        int maxLength = findMaxLength(cars);
        return findWinnerNames(cars, maxLength);
    }

    private String findWinnerNames(List<Car> cars, int maxLength) {
        return cars.stream()
                .filter(car -> car.getResult().length() == maxLength)
                .map(Car::getName)
                .collect(Collectors.joining(","));
    }

    private int findMaxLength(List<Car> cars) {
        return cars.stream()
                .mapToInt(car -> car.getResult().length())
                .max()
                .orElse(0);
    }
}
