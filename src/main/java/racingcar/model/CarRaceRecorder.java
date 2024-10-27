package racingcar.model;

import java.util.List;
import racingcar.dto.RoundRaceRecord;

public class CarRaceRecorder {

    public List<RoundRaceRecord> recordRound(List<Car> cars) {
        return cars.stream()
                .map(this::mapToRoundRaceRecord)
                .toList();
    }

    private RoundRaceRecord mapToRoundRaceRecord(Car car) {
        return new RoundRaceRecord(car.getName(), car.getPosition());
    }

    public List<String> getWinnerCarNames(List<Car> cars) {
        int maxPosition = findMaxPosition(cars);
        return cars.stream()
                .filter(car -> car.getPosition() == maxPosition)
                .map(Car::getName)
                .toList();
    }

    private int findMaxPosition(List<Car> cars) {
        return cars.stream()
                .map(Car::getPosition)
                .max(Integer::compareTo)
                .orElseThrow(() -> new IllegalStateException("자동차가 존재하지 않습니다."));
    }
}
