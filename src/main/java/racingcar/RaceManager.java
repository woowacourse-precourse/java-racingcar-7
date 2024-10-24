package racingcar;

import java.util.List;

public class RaceService {

    public List<Car> getWinners(List<Car> cars) {
        int maxLocation = cars.stream()
                .mapToInt(Car::getLocation)
                .max()
                .orElseThrow(() -> new IllegalArgumentException("경주차가 존재하지 않습니다."));

        return cars.stream()
                .filter(car -> car.getLocation() == maxLocation)
                .toList();
    }
}
