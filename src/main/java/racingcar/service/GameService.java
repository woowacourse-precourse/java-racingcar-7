package racingcar.service;

import java.util.List;
import racingcar.domain.Car;

public class GameService {

    public int getMaxLocation(List<Car> cars) {
        return cars.stream().mapToInt(Car::getPresentLocation).max()
                .orElseThrow(() -> new IllegalArgumentException("Cannot get max location"));
    }

    public List<Car> selectWinners(List<Car> cars) {
        final int maxLocation = getMaxLocation(cars);
        return cars.stream().filter(car -> car.getPresentLocation() == maxLocation).toList();
    }
}
