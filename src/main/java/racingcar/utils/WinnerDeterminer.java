package racingcar.utils;

import racingcar.domain.Car;

import java.util.List;

public class WinnerDeterminer {
    public static List<String> determineWinners(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private static int findMaxPosition(List<Car> cars) {
        return cars.stream().map(Car::getPosition).max(Integer::compareTo).orElse(0);
    }
}
