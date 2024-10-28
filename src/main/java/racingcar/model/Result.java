package racingcar.model;

import java.util.List;
import java.util.stream.Collectors;

public class Result {
    public static List<String> findWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("자동차 리스트가 비어 있습니다."));

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());
    }
}