package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class RaceResult {

    // 우승자를 계산하는 메서드
    public static List<String> determineWinners(List<Car> cars) {
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