package racingcar.service;

import java.util.List;
import racingcar.model.Car;

public class RacingService {

    public void processRound(List<Car> cars) {
        cars.forEach(Car::attemptMove);
    }

    public List<Car> findWinners(List<Car> cars) {
        int maxMovedDistance = cars.stream()
                .map(Car::getMovedDistance)
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalArgumentException("자동차 중 가장 많이 이동한 거리를 구할 수 없습니다."));
        return cars.stream()
                .filter(car -> car.isWinner(maxMovedDistance))
                .toList();
    }
}
