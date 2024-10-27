package racingcar.util;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.model.Car;

public class WinnerDecision {

    public static List<Car> determineWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
