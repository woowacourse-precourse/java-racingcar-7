package racingcar;

import java.util.List;
import java.util.stream.Collectors;

public class WinnerManager {
    public WinnerManager() {
    }

    public int getMaxDistance(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("자동차가 없습니다"));
    }

    public List<Car> determineWinners(List<Car> cars) {
        int maxDistance = getMaxDistance(cars);
        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .toList();
    }

    boolean isSingleWinner(List<Car> winners) {
        return winners.size() == 1;
    }

    String getWinnerNames(List<Car> winners) {
        if (isSingleWinner(winners)) {
            return winners.getFirst().getCarName();
        }
        return winners.stream()
                .map(Car::getCarName)
                .collect(Collectors.joining(", "));
    }
}
