package racingcar.domain;

import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

public class RaceResult {
    public static List<Car> getWinners(List<Car> racingCars) {
        int maxPosition = racingCars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);

        return racingCars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .collect(Collectors.toList());
    }
}
