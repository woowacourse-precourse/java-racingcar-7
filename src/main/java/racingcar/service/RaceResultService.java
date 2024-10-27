package racingcar.service;

import java.util.List;
import racingcar.domain.Car;

public class RaceResultService {
    public List<String> determineWinners(List<Car> cars) {
        int maxPosition = cars.stream()
                .mapToInt(Car::getPosition)
                .max()
                .orElse(0);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getCarName)
                .toList();
    }
}
