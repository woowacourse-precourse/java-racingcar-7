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
}
