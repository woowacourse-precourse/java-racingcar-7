package racingcar.game;

import racingcar.dto.Car;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerDecider {
    public List<Car> decideWinner(List<Car> cars) {
        int maxCount = getMaxCount(cars);
        return cars.stream()
                .filter(car -> car.getMoveCount() == maxCount)
                .collect(Collectors.toList());
    }

    private int getMaxCount(List<Car> result) {
        return result.stream()
                .mapToInt(Car::getMoveCount)
                .max()
                .orElse(Integer.MIN_VALUE);
    }
}
