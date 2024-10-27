package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class GameResult {
    public static String announceWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        List<String> winners = cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .collect(Collectors.toList());

        return String.join(",", winners);
    }
}
