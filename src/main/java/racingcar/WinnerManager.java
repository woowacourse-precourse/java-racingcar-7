package racingcar;

import java.util.List;

public class WinnerManager {
    public int getMaxDistance(List<Car> cars) {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("자동차가 없습니다"));
    }
}
